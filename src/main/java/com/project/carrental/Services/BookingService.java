package com.project.carrental.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carrental.Entity.Booking;
import com.project.carrental.Repository.BookingRepository;

@Service
public class BookingService {

	 @Autowired
	    private BookingRepository bookingRepository;

	    public Booking addBooking(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    public Optional<Booking> getBookingById(Long id) {
	        return bookingRepository.findById(id);
	    }

	    public void deleteBooking(Long id) {
	        bookingRepository.deleteById(id);
	    }
}
