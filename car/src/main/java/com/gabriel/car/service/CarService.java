package com.gabriel.car.service;

import com.gabriel.car.repository.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> findAllCars();

    Optional<Car> findCarById(Long id);

    Optional<Car> updateCar(Car car);

    Optional<Boolean> deleteCarById(Long id);

    Car createCar(Car car);


}
