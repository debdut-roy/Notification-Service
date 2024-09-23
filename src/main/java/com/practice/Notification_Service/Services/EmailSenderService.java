package com.practice.Notification_Service.Services;

import com.practice.Notification_Service.DTO.EmailNotificationDetailsDto;

public interface EmailSenderService {

	String sendMail(EmailNotificationDetailsDto emailDto);
}
