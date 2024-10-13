package com.mainor.project21.glampingestonia.web;

import com.mainor.project21.glampingestonia.dto.CreateLocationRequest;
import com.mainor.project21.glampingestonia.dto.LocationDto;
import com.mainor.project21.glampingestonia.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("location")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public LocationDto addLocation(@RequestBody CreateLocationRequest request){
        return locationService.addLocation(request);
    }

    @GetMapping
    public List<LocationDto> getAll(){
        return locationService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        locationService.delete(id);
    }
}

