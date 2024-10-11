package com.mainor.project21.glampingestonia.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookingRequest {
    private Long guestId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
