package com.vs.communicationservice.controllers;

import com.vs.communicationservice.models.SmsEntity;
import com.vs.communicationservice.services.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communication/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public void addSms(@RequestBody SmsEntity sms) {
        smsService.addSms(sms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSmsById(@PathVariable Long id) {
        return ResponseEntity.ok().body(smsService.getSmsById(id));
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<?> getSmsStatusById(@PathVariable Long id) {
        return ResponseEntity.ok().body(smsService.getSmsStatusById(id));
    }
}
