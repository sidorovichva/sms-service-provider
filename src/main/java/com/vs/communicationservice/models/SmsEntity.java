package com.vs.communicationservice.models;

import com.vs.communicationservice.enums.CommunicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SMS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    @Column(nullable = false, name = "ID", updatable = false)
    private Long id;

    @Column(nullable = false, length = 256, name = "FIRST_NAME")
    private String firstName;

    @Column(nullable = false, length = 256, name = "LAST_NAME")
    private String lastName;

    @Column(nullable = false, length = 256, name = "TEXT")
    private String text;

    @Column(nullable = false, length = 16, name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(nullable = false, length = 16, name = "STATUS")
    private CommunicationStatus status;

    public SmsLight conversion() {
        return SmsLight.builder()
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .text(this.getText())
                .phoneNumber(this.getPhoneNumber()).build();
    }
}
