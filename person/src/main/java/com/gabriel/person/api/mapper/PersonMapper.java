package com.gabriel.person.api.mapper;


import com.gabriel.car.model.Car;
import com.gabriel.car.model.PersonRequest;
import com.gabriel.car.model.PersonResponse;
import com.gabriel.person.repository.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonMapper {


    private final String CAR_SERVICE_URL =" http://localhost:8081/cars/";

    public Person toPersonEntity(PersonRequest personRequest){
        return Person.builder()
                .id(null)
                .name(personRequest.getName())
                .age(personRequest.getAge())
                .carId(personRequest.getCarId())
                .build();
    }

    public PersonResponse toPersonResponse (Person person){
        
        RestTemplate restTemplate = new RestTemplate();
        Car car = restTemplate.getForObject(CAR_SERVICE_URL + person.getCarId().toString(),Car.class);

        return new PersonResponse()
                .name(person.getName())
                .age(person.getAge())
                .car(car);

    }

}
