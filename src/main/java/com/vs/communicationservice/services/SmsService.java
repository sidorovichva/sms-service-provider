package com.vs.communicationservice.services;

import com.vs.communicationservice.enums.CommunicationStatus;
import com.vs.communicationservice.models.SmsEntity;
import com.vs.communicationservice.models.SmsLight;
import com.vs.communicationservice.repositories.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsRepository smsRepository;

    public void addSms(SmsEntity sms) {
        sms.setStatus(CommunicationStatus.NEW);
        smsRepository.save(sms);
    }

    public SmsLight getSmsById(Long id) {
        return smsRepository.findById(id).get().conversion();
    }

    public CommunicationStatus getSmsStatusById(Long id) {
        return smsRepository.findById(id).get().getStatus();
    }

    @Scheduled(fixedDelayString = "PT3S")
    public void sendSmsBatch() {
        smsRepository.getAllByStatus(CommunicationStatus.NEW).forEach(System.out::println);
        new SmsCommunicationProvider(smsRepository.getAllByStatus(CommunicationStatus.NEW));
    }
}
