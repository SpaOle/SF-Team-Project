package com.mainor.project21.glampingestonia.web;

import com.mainor.project21.glampingestonia.dto.BookingDto;
import com.mainor.project21.glampingestonia.dto.CreateBookingRequest;
import com.mainor.project21.glampingestonia.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
        public BookingDto create(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }

    @GetMapping
    public List<BookingDto> getAll(){
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public BookingDto findById(@PathVariable String id){
        return bookingService.findById(id);
    }

    @PutMapping("/{id}")
    public BookingDto update(@PathVariable String id, @RequestBody BookingDto request) {
        return bookingService.updateBooking(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookingService.delete(id);
    }
}
