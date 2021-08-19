package com.vs.communicationservice.clr;

import com.vs.communicationservice.models.SmsEntity;
import com.vs.communicationservice.models.SmsLight;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(1)
@RequiredArgsConstructor
public class Tester implements CommandLineRunner {
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        String uri = "http://localhost:8080/communication/sms/send";

        SmsEntity sms1 = SmsEntity.builder()
                .firstName("John")
                .lastName("Smith")
                .text("Hello!")
                .phoneNumber("356456456")
                .build();
        restTemplate.postForEntity(uri, sms1, Long.class);

        SmsEntity sms2 = SmsEntity.builder()
                .firstName("Bob")
                .lastName("Marley")
                .text("World")
                .phoneNumber("45646457")
                .build();
        restTemplate.postForEntity(uri, sms2, Long.class);
    }
}
