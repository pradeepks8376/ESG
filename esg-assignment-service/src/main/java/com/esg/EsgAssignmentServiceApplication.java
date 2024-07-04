package com.esg;

import com.esg.constant.Constants;
import com.esg.model.Customer;
import com.esg.service.RestClient;
import com.esg.util.CsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class EsgAssignmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsgAssignmentServiceApplication.class, args);
	}
}
