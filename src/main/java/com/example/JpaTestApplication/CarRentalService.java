package com.example.JpaTestApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<Car>();
    CarRepository carRepository;

    @Autowired
    public CarRentalService(CarRepository carRepository){
        this.carRepository = carRepository;
        Car ferrari = new Car();
        ferrari.setPlateNumber("11AA22");
        ferrari.setBrand("Ferrari");
        ferrari.setPrice(1000000);
        ferrari.setRent(false);
        carRepository.save(ferrari);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Car> listOfCars(){
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        cars.add(car);
    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{

        for(Car car : cars) {
            if(car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }

        return null;

    }


    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Rent rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
                               @RequestBody Rent rendUser,
                               @RequestParam(value="rent", required = true)boolean rent) throws Exception {

        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                car.setRent(rent);

                if (car.isRent()) {
                    car.getRents().add(rendUser);
                    return car.getRents().get(car.getRents().size() -1);

                } else {
                    return null;
                }
            }
        }
        return null;
    }

}
