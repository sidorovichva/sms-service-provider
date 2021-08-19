package com.vs.communicationservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SmsLight {
    private String firstName;
    private String lastName;
    private String text;
    private String phoneNumber;

    @Override
    public String toString() {
        return "SmsLight{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", text='" + text + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
