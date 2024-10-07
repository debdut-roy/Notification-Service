package com.practice.Notification_Services.Consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.practice.Notification_Service.DTO.CandidateCreatedDetailsDto;
import com.practice.Notification_Service.DTO.EmailNotificationDetailsDto;
import com.practice.Notification_Service.Services.EmailSenderService;

@Service
public class CandidateCreatedEventListener {

    Logger log = LoggerFactory.getLogger(CandidateCreatedEventListener.class);
    @Autowired
    private EmailSenderService emailSenderService;

    @KafkaListener(topics = "candidate.created",groupId = "email-notification-group")
    public void handleCandidateCreatedEvent(CandidateCreatedDetailsDto candidateCreatedDetails) {
        log.info("consumer consume the events {}  from partition {}", candidateCreatedDetails.toString());
        EmailNotificationDetailsDto emailNotificationDetails = new EmailNotificationDetailsDto();
        emailNotificationDetails.setToRecipient(candidateCreatedDetails.getCandidateEmail());
        emailNotificationDetails.setSubject("Welcome "+candidateCreatedDetails.getCandidateName()+"!!");
        emailNotificationDetails.setBody("Hi "+candidateCreatedDetails.getCandidateName()+
        		"\nYour email id is "+candidateCreatedDetails.getCandidateEmail()+
        		"\nYour temporary password is "+candidateCreatedDetails.getCandidateTemporaryPassword());
        emailSenderService.sendMail(emailNotificationDetails);
    }
    
    
}