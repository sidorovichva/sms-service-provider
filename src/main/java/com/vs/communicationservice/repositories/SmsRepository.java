package com.vs.communicationservice.repositories;

import com.vs.communicationservice.enums.CommunicationStatus;
import com.vs.communicationservice.models.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmsRepository extends JpaRepository<SmsEntity, Long> {
    List<SmsEntity> getAllByStatus(CommunicationStatus  status);
}
