package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.model.BodyStyle;
import org.sonuk.model.Car;
import org.sonuk.model.Cars;
import org.sonuk.model.Dealer;

import java.util.List;

public class MapPractice {
    private static final Logger log = LoggerFactory.getLogger(MapPractice.class);

    public static void main(String[] args) {
        // I learned that default value of enum in proto is the value which is associated
        // with field id 0;
        // to demonstrate i am going to create a car with default value
        var myCar = Car.newBuilder().setMake("Tesla").setModel("Hatchback").build();
        log.info("Body Style : {}", myCar.getBodyStyle()); // it should print body style as SEDAN because of id 0
        // but in to string method bodyStyle will not be shown because we have not explicitly set it.
        log.info("MyCar : {}", myCar);
        var car = Car.newBuilder().setMake("Honda").setModel("civic").setBodyStyle(BodyStyle.SUV).setYear(2000).build();
        var car2 = car.toBuilder().setModel("accord").setBodyStyle(BodyStyle.COUPE).setYear(2000).build();

        var dealer = Dealer.newBuilder().putInventory(2000, Cars.newBuilder().addAllCar(List.of(car, car2)).build()).build();
        log.info(dealer.toString());
        log.info("2010 ? {}", dealer.containsInventory(2000));
        log.info("2020 ? {}", dealer.containsInventory(2020));
        log.info("2000 model {}", dealer.getInventoryOrThrow(2000));
    }
}
