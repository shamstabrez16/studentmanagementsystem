package com.shamstabrez16.studentmanagementsystem;

import com.shamstabrez16.studentmanagementsystem.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@SpringBootApplication
@EnableWs
public class StudentmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}

}
