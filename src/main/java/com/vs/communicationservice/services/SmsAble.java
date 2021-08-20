package com.vs.communicationservice.services;

import com.vs.communicationservice.models.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmsAble {
    void sendSms(List<SmsEntity> list);
}
