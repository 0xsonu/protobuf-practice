package org.sonuk;

import org.sonuk.models.chapter01.PersonOuterClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setName("John").build();
        System.out.println(person);

    }
}