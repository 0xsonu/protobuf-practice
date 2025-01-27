package org.sonuk.chapter03;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Employee;

public class PerformanceTest {
    private static final Logger LOG = LoggerFactory.getLogger(PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        var protoEmployee = Employee.newBuilder()
                .setFirstName("Sonu")
                .setLastName("Kumar")
                .setEmail("sonu@gmail.com")
                .setAge(25)
                .setBalance(500490)
                .setBankAccountNumber(258947937589L)
                .setSalary(50680)
                .build();

        var jsonEmployee = new JsonEmployee("Sonu", "Kumar", "sonu@gmail.com", 25, 50680, 258947937589L, 500490);
        for (int i = 0; i < 5; i++) {
            runTest("Proto Test ", () -> proto(protoEmployee));
            runTest("JSON Test ", () -> json(jsonEmployee));
        }
    }

    private static void proto( Employee employee ) {
        try {
            var bytes = employee.toByteArray();
            Employee.parseFrom(bytes);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
    private static void json(JsonEmployee jsonEmployee) {
        try {
            var bytes = mapper.writeValueAsBytes(jsonEmployee);
            mapper.readValue(bytes, JsonEmployee.class);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
    private static void runTest(String testName, Runnable runnable){
        var start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        LOG.info("Time taken for {} is {} ms", testName, (end - start));

    }
}
