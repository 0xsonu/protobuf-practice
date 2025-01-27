package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Address;
import org.sonuk.models.chapter03.School;
import org.sonuk.models.chapter03.Student;

public class Composition {
    private static final Logger logger = LoggerFactory.getLogger(Composition.class);

    public static void main(String[] args) {
        // create student
        var studentAddress = Address.newBuilder()
                .setStreet("123, main street")
                .setCity("Patna")
                .setState("Bihar")
                .build();

        var student = Student.newBuilder()
                .setName("John")
                .setAddress(studentAddress)
                .build();

        var school = School.newBuilder()
                .setId(1)
                .setName("High School")
                .setAddress(studentAddress.toBuilder().setStreet("125, main street"))
                .build();
        
        logger.info(student.toString());
        logger.info(school.toString());
    }
}
