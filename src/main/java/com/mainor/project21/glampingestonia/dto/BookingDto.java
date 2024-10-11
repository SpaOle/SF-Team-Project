package com.mainor.project21.glampingestonia.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookingDto {
    private String id;
    private String user_id;
    private String location_id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String errorMessage;

}
