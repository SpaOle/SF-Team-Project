package com.mainor.project21.glampingestonia.mapper;

import com.mainor.project21.glampingestonia.model.Booking;
import com.mainor.project21.glampingestonia.dto.BookingDto;
import com.mainor.project21.glampingestonia.dto.CreateBookingRequest;


public class BookingMapper {

        public static BookingDto toDto(Booking booking) {
            BookingDto bookingDto = new BookingDto();
            bookingDto.setCheckInDate(booking.getCheckInDate());
            bookingDto.setCheckOutDate(booking.getCheckOutDate());
            bookingDto.setUser_id(booking.getUser_id());
            bookingDto.setId(booking.getId());
            bookingDto.setLocation_id(booking.getLocation_id());
            return bookingDto;
        }

        public static Booking toEntity(CreateBookingRequest request){
            Booking booking = new Booking();
            booking.setCheckOutDate(request.getCheckOutDate());
            booking.setCheckInDate(request.getCheckInDate());
            booking.setUser_id(request.getUser_id());
            booking.setLocation_id(request.getLocation_id());
            return booking;
        }

        public static Booking updateEntity(BookingDto source, Booking target) {
            target.setCheckInDate(source.getCheckInDate());
            target.setCheckOutDate(source.getCheckOutDate());
            target.setLocation_id(source.getLocation_id());
            target.setUser_id(source.getUser_id());
            return target;
        }

}
