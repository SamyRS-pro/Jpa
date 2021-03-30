package com.example.JpaTestApplication;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {
    Car findByPlateNumber(String plateNumber);
}
