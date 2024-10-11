package com.mainor.project21.glampingestonia.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateBooking {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long guestId;
    private Long roomId;
}
