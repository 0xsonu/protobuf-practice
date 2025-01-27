package org.sonuk.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter01.PersonOuterClass;

public class ProtoDemo {
    private static final Logger LOG = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        // in proto if we need to create an object
        // we have to use builder pattern because of
        // private constructor.

        var person = PersonOuterClass.Person.newBuilder().setName("Sonu Kumar").setAge(25).build();
        LOG.info("{}",person);
    }
}
