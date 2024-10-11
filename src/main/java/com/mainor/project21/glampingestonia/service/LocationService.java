package com.mainor.project21.glampingestonia.service;

import com.mainor.project21.glampingestonia.mapper.LocationMapper;
import com.mainor.project21.glampingestonia.model.Location;
import com.mainor.project21.glampingestonia.repository.LocationRepository;
import com.mainor.project21.glampingestonia.dto.CreateLocationRequest;
import com.mainor.project21.glampingestonia.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository = new LocationRepository();

    public LocationDto addLocation(CreateLocationRequest createLocationRequest){
        Location location = LocationMapper.toEntity(createLocationRequest);
        return LocationMapper.toDto(locationRepository.save(location));

    }

    public List<LocationDto> getAll(){
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDto)
                .toList();
    }
    public boolean findById(String id){
        Location location = requireLocation(id);
        return true;
    }
    private Location requireLocation(String id) {
        return locationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("location not found"));
    }

    public void delete(String id){
        Location location = requireLocation(id);
        locationRepository.delete(location);
    }

}
