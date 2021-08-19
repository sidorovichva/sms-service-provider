package com.vs.communicationservice.enums;

public enum CommunicationStatus {
    NEW(0),
    IN_PROCESS(1),
    SENT_SUCCESSFULLY(2),
    NOT_SENT(3);

    private int status;

    CommunicationStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
