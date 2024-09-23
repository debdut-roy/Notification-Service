package com.practice.Notification_Service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Notification_Service.DTO.EmailNotificationDetailsDto;
import com.practice.Notification_Service.Services.EmailSenderService;

@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailSenderService emailSenderService;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Okay", HttpStatus.OK);
	}
	
	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailNotificationDetailsDto emailDetailsDto) {
		return emailSenderService.sendMail(emailDetailsDto);
	}
}
