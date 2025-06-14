package com.remindly.weekly_reminder_scheduler.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.from-number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

    public void sendWhatsAppMessage(String to, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),
                new PhoneNumber(fromNumber),
                messageBody
        ).create();
    }
}
