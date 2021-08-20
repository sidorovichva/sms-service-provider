package com.vs.communicationservice.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vs.communicationservice.models.SmsEntity;

import java.util.List;

public class OtherProvider implements SmsAble{
    private final String accountSid = "ACXXXXXX";
    private final String authToken = "XXXXXXXX";
    private final String phone = "46456456";

    public OtherProvider() {
        System.out.println("OTHER PROVIDER");
    }

    @Override
    public void sendSms(List<SmsEntity> list) {
        list.forEach(sms -> System.out.println(sms));
    }
}
