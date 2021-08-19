package com.vs.communicationservice.services;

import com.vs.communicationservice.models.SmsEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
public class SmsCommunicationProvider {

    private List<SmsEntity> list;

    @Value("${communication.provider}")
    private String communicationProvider;

    public SmsCommunicationProvider(List<SmsEntity> list) {
        this.list = list;
        if(communicationProvider.equals("twilio")) sendThroughTwilio();
    }

    private void sendThroughTwilio() {
        System.err.println("TWILIO");
        new TwilioService(list);
    }
}
