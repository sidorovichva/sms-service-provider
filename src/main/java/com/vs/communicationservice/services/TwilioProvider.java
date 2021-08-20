package com.vs.communicationservice.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vs.communicationservice.models.SmsEntity;

import java.util.List;

public class TwilioProvider implements SmsAble {
    private final String accountSid = "ACXXXXXX";
    private final String authToken = "XXXXXXXX";
    private final String phone = "46456456";

    public TwilioProvider() {
        com.twilio.Twilio.init(accountSid, authToken);
        System.out.println("TWILIO");
    }

    public Message createMessage(SmsEntity sms) {
        return Message.creator(
                new PhoneNumber(sms.getPhoneNumber()),
                new PhoneNumber(phone),
                sms.getText()
        ).create();
    }

    @Override
    public void sendSms(List<SmsEntity> list) {
        list.forEach(sms -> {
            this.createMessage(sms);
            System.out.println(sms);
        });
    }
}




