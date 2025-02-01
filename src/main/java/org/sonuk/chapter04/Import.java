package org.sonuk.chapter04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter04.Person;
import org.sonuk.models.chapter04.common.Address;
import org.sonuk.models.chapter04.common.Car;
import org.sonuk.models.chapter04.common.Cars;

public class Import {
    private static final Logger log = LoggerFactory.getLogger(Import.class);

    public static void main(String[] args) {
        var address = Address.newBuilder().setCity("Patna")
                .setStreet("India")
                .setState("Bihar")
                .build();
        var cars = Cars.newBuilder()
                .addCar(Car.newBuilder().setMake("BMW"))
                .addCar(Car.newBuilder().setMake("Honda"))
                .build();

        var person = Person.newBuilder().setFirstName("Sonu")
                .setLastName("Kumar")
                .setAddress(address)
                .setCars(cars)
                .build();
        log.info("{}", person);

    }
}
