package com.gabriel.car.api.mapper;

import com.gabriel.car.model.CarRequest;
import com.gabriel.car.model.CarResponse;
import com.gabriel.car.repository.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toCarEntity (CarRequest carRequest){
        return Car
                .builder()
                .id(null)
                .licensePlate(carRequest.getLicensePlate())
                .company(carRequest.getCompany())
                .model(carRequest.getModel())
                .build();
    }

    public CarResponse toCarResponse (Car car){
        return new CarResponse()
                .id(car.getId())
                .licensePlate(car.getLicensePlate())
                .company(car.getCompany())
                .model(car.getModel());
    }

}
