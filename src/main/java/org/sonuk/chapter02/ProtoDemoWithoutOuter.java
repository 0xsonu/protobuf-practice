package org.sonuk.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter02.Person;

public class ProtoDemoWithoutOuter {
    private static final Logger LOG = LoggerFactory.getLogger(ProtoDemoWithoutOuter.class);

    public static void main(String[] args) {
        // create person1
        var person1 = createPerson();
        // create another person with same value
        var person2 = createPerson();
        // compare
        LOG.info("Using Equals(): {}", person1.equals(person2));
        LOG.info("Using == : {}", person1==person2);

        // mutable?
//        person1.setAge(23); it will give error because setters are private and make object immutable.

        // create another instance with different value
        var person3 = person1.toBuilder().setName("John Doe").setAge(34).build();
        LOG.info("Updated person1: {} to person3: {}", person1, person3);

        // compare
        LOG.info("Using Equals(): {}", person1.equals(person3));
        LOG.info("Using == : {}", person1==person3);


        // null?
        var nullPerson = Person.newBuilder().setName(null).build(); // this will throw NullPointerException
        LOG.info("nullPerson: {}", nullPerson);
    }

    private static Person createPerson() {
        return Person.newBuilder().setName("Sonu Kumar").setAge(25).build();
    }
}
