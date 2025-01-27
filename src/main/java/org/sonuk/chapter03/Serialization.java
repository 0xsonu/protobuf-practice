package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Serialization {
    private static final Logger LOG = LoggerFactory.getLogger(Serialization.class);
    private static final Path PATH = Path.of("employee.out");
    public static void main(String[] args) throws IOException {
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
        serialize(employee);
        var deserializedEmployee = deserialize();
        LOG.info("Deserialized Employee: {}", deserializedEmployee );
        LOG.info("Equals : {}", employee.equals(deserializedEmployee));
        LOG.info("Bytes length: {}", deserializedEmployee.toByteArray().length);

    }

    private static void serialize(Employee employee) throws IOException {
        try( var stream = Files.newOutputStream(PATH)) {
            employee.writeTo(stream);
        }

    }

    private static Employee deserialize() throws IOException {
        try( var stream = Files.newInputStream(PATH)) {
            return Employee.parseFrom(stream);
        }
    }

}
