package com.sumer.FirstProject;

import com.sumer.FirstProject.Impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {
	@Autowired
	NotificationService notificationServiceObj;//This is the dependency injection

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		//NotificationService notificationServiceObj=new EmailNotificationService();

		notificationServiceObj.send("Hello Sumer");
	}
}
