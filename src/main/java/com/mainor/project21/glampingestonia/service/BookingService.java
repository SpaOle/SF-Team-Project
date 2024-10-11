package com.mainor.project21.glampingestonia.service;

import com.mainor.project21.glampingestonia.mapper.BookingMapper;
import com.mainor.project21.glampingestonia.model.Booking;
import com.mainor.project21.glampingestonia.repository.BookingRepository;
import com.mainor.project21.glampingestonia.dto.BookingDto;
import com.mainor.project21.glampingestonia.dto.CreateBookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository = new BookingRepository();

    public BookingDto createBooking(CreateBookingRequest createBookingRequest){
        String locationId = createBookingRequest.getLocation_id();
        LocalDate checkInDate = createBookingRequest.getCheckInDate();
        LocalDate checkOutDate = createBookingRequest.getCheckOutDate();
        if(isLocationAvailable(locationId,checkInDate,checkOutDate)) {
            Booking booking = BookingMapper.toEntity(createBookingRequest);
            return BookingMapper.toDto(bookingRepository.save(booking));
        } else {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setErrorMessage("The location is not available at the specific time");
            return bookingDto;
        }
    }

    public BookingDto updateBooking(String id, BookingDto bookingDto){
        Booking booking = BookingMapper.updateEntity(bookingDto, requireBooking(id));
        return BookingMapper.toDto(bookingRepository.save(booking));
    }

    public List<BookingDto> getAll(){
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDto)
                .toList();
    }

    public BookingDto findById(String id){
        Booking booking = requireBooking(id);
        return BookingMapper.toDto(booking);
    }

    public boolean isLocationAvailable(String locationId, LocalDate checkInDate, LocalDate checkOutDate){
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(locationId, checkInDate, checkOutDate);
        return overlappingBookings.isEmpty();
    }

    public void delete(String id){
        Booking booking = requireBooking(id);
        bookingRepository.delete(booking);
    }

    private Booking requireBooking(String id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("booking not found"));
    }

}