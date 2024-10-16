package com.mainor.project21.glampingestonia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Location {
    @Id
    private String id;
    private String type;
    private double price;
}
