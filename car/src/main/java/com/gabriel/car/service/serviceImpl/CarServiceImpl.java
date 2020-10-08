package com.gabriel.car.service.serviceImpl;

import com.gabriel.car.repository.CarRepository;
import com.gabriel.car.repository.entity.Car;
import com.gabriel.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Optional<Car> updateCar(Car car) {
        return carRepository.findById(car.getId())
                .map(c -> car)
                .map(carRepository::save);
    }

    @Override
    public Optional<Boolean> deleteCarById(Long id) {
        return carRepository.findById(id).map( car -> {
            carRepository.delete(car);
            return true;
        });
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
}
