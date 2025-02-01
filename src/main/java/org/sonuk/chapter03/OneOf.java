package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Credentials;
import org.sonuk.models.chapter03.Email;
import org.sonuk.models.chapter03.Phone;

public class OneOf {
    private static final Logger log = LoggerFactory.getLogger(OneOf.class);

    public static void main(String[] args) {
        var email = Email.newBuilder().setAddress("sonu@gmail.com").setPassword("123456").build();
        var phone = Phone.newBuilder().setNumber(8294008226L).setOtp(345987).build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());

        // if in case we will try to set multiple value to the field of type one of
        // then the last set value will be set
        // for ex: if we set email and phone together

        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build());  // phone should be set because phone is set at the last override previous value
        login(Credentials.newBuilder().setPhone(phone).setEmail(email).build());  // it should have email
    }

    public static void login(Credentials credentials) {
        switch (credentials.getLoginMethodCase()) {
            case EMAIL -> log.info("Login with email address {}", credentials.getEmail());
            case PHONE -> log.info("Login with phone number {}", credentials.getPhone());
        }
    }
}
