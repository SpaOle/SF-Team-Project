package com.mainor.project21.glampingestonia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Data
public class Booking {
    @Id
    private String id;
    private String user_id;
    private String location_id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
