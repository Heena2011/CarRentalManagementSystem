package com.project.carrental.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carrental.Entity.Car;
import com.project.carrental.Repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	// add car
	public Car addCar(Car car) {

		return carRepository.save(car);
	}

	// Update car details by ID
	public Car updateCar(Long id, Car updatedCar) {
		Optional<Car> carOptional = carRepository.findById(id);
		if (carOptional.isPresent()) {
			Car existingCar = carOptional.get();
			existingCar.setModel(updatedCar.getModel());
			existingCar.setMake(updatedCar.getMake());
			existingCar.setBrand(updatedCar.getBrand());
			existingCar.setType(updatedCar.getType());
			existingCar.setPricePerDay(updatedCar.getPricePerDay());
			existingCar.setAvailable(updatedCar.isAvailable());
			return carRepository.save(existingCar); // Save the updated car
		} else {
			return null; // Or throw an exception if you prefer to handle it
		}
	}
	// Delete car by ID
    public void deleteCar(Long id) {
        carRepository.deleteById(id);  // Delete the car with the given ID
    }
    
    // Get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();  // Fetch all cars from the database
    }

    // Get car by ID
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);  // Fetch car by ID
    }
    
    public List<Car> searchCars(String make, String model) {
        // Get all cars
        List<Car> allCars = carRepository.findAll();

        // Create a list to hold filtered cars
        List<Car> filteredCars = new ArrayList<>();

        // Loop through all cars and filter based on the provided parameters
        for (Car car : allCars) {
            boolean matches = true; // Flag to check if the car matches the criteria

            // Check if the make matches (if provided)
            if (make != null && !make.isEmpty() && !car.getMake().equalsIgnoreCase(make)) {
                matches = false;
            }

            // Check if the model matches (if provided)
            if (model != null && !model.isEmpty() && !car.getModel().equalsIgnoreCase(model)) {
                matches = false;
            }

            // If the car matches the criteria, add it to the filtered list
            if (matches) {
                filteredCars.add(car);
            }
        }

        return filteredCars; // Return the list of filtered cars
    }
}
