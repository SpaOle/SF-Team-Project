package com.mainor.project21.glampingestonia.repository;

import com.mainor.project21.glampingestonia.model.Booking;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookingRepository {
    public List<Booking> findAll() {
        return null;
    }
    /*@Query("SELECT b FROM Booking b WHERE b.location_Id = :locationId AND ((b.check_In_Date < :checkOutDate AND b.check_Out_Date > :checkInDate)" +
            " OR (b.check_In_Date BETWEEN :checkInDate AND :checkOutDate) OR (b.check_Out_Date BETWEEN :checkInDate AND :checkOutDate))")*/
    public List<Booking> findOverlappingBookings(@Param("locationId") String locationId, @Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate) {
        return null;
    }

    public void delete(Booking booking) {
    }

    public Optional<Booking> findById(String id) {
        return null;
    }

    public Booking save(Booking booking) {
        return null;
    }
}


