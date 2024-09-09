package com.practice.Notification_Service.Services;

import com.practice.Notification_Service.DTO.EmailDto;

public interface EmailSenderService {

	String sendMail(EmailDto emailDto);
}
