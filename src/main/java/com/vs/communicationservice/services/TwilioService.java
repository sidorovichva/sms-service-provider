package com.vs.communicationservice.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vs.communicationservice.models.SmsEntity;
import lombok.Data;

import java.util.List;

@Data
public class TwilioService {
    private final String accountSid = "ACXXXXXX";
    private final String authToken = "XXXXXXXX";
    private final String phone = "46456456";

    public TwilioService(List<SmsEntity> list) {
        com.twilio.Twilio.init(accountSid, authToken);
        list.forEach(sms -> {
            System.out.println(this.createMessage(sms).getSid());
        });
    }

    public Message createMessage(SmsEntity sms) {
        return Message.creator(
                new PhoneNumber(sms.getPhoneNumber()),
                new PhoneNumber(phone),
                sms.getText()
        ).create();
    }
}




