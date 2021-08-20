package com.vs.communicationservice.services;

import com.vs.communicationservice.models.SmsEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmsFactory {

    @Value("${communication.provider}")
    private String communicationProvider;

    public SmsAble defineProvider() {
        SmsAble provider;
        switch (communicationProvider) {
            case "twilio":
                provider = new TwilioProvider();
                break;
            case "other":
                provider = new OtherProvider();
                break;
            default:
                provider = new OtherProvider();
                break;
        }
        return provider;
    }
}
