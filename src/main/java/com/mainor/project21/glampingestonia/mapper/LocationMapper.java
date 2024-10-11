package com.mainor.project21.glampingestonia.mapper;

import com.mainor.project21.glampingestonia.model.Location;
import com.mainor.project21.glampingestonia.dto.CreateLocationRequest;
import com.mainor.project21.glampingestonia.dto.LocationDto;

public class LocationMapper {

    public static LocationDto toDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setType(location.getType());
        locationDto.setPrice(location.getPrice());
        return locationDto;
    }

    public static Location toEntity(CreateLocationRequest request){
        Location location = new Location();
        location.setType(request.getType());
        location.setPrice(request.getPrice());
        return location;
    }
}
