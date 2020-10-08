package com.gabriel.car.api.controller;

import com.gabriel.car.api.mapper.CarMapper;
import com.gabriel.car.endpoint.CarsApi;
import com.gabriel.car.model.CarRequest;
import com.gabriel.car.model.CarResponse;
import com.gabriel.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarController implements CarsApi {


    private final CarService carService;
    private final CarMapper carMapper;


    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @Override
    public ResponseEntity<CarResponse> createCar(CarRequest carRequest) {
        var car = carMapper.toCarEntity(carRequest);
        var carResponse = carMapper.toCarResponse(carService.createCar(car));
        return ResponseEntity.ok(carResponse);
    }

    @Override
    public ResponseEntity<Void> deleteCarById(Long carId) {
        return carService.deleteCarById(carId)
                .map(res -> new ResponseEntity<Void>(HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars()
                .stream()
                .map(carMapper::toCarResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<CarResponse> getCarById(Long carId) {
        return carService.findCarById(carId)
                .map(carMapper::toCarResponse)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Override
    public ResponseEntity<CarResponse> updateCarsById(Long carId, CarRequest carRequest) {

        var car = carMapper.toCarEntity(carRequest);
        car.setId(carId);
        return carService.updateCar(car)
                .map(carMapper::toCarResponse)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
