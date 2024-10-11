package com.mainor.project21.glampingestonia.repository;

import ee.eek.booking.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();

}