package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Employee;

public class ScalarDataType {
    private static final Logger LOG = LoggerFactory.getLogger(ScalarDataType.class);
    public static void main(String[] args) {
        Employee employee = Employee.newBuilder()
                .setFirstName("Sonu")
                .setLastName("Kumar")
                .setEmail("sonu@gmail.com")
                .setAge(25)
                .setBalance(500490)
                .setBankAccountNumber(258947937589L)
                .setSalary(50680)
                .build();

        LOG.info("{}",employee);
    }
}
