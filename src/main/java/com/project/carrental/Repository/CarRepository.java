package com.project.carrental.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.carrental.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
