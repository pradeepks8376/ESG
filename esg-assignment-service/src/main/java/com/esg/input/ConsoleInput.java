package com.esg.input;

import com.esg.constant.Constants;
import com.esg.exception.ApiException;
import com.esg.util.CsvReader;
import com.esg.model.Customer;
import com.esg.service.RestClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class ConsoleInput {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream("src/main/resources/application.properties")){
            properties.load(inputStream);
        }catch (IOException exception){
            System.out.println("Error loading file "+exception.getMessage());
        }

        try {
            CsvReader csvReader = new CsvReader();
            List<Customer> customers = csvReader.readCsvFile(Constants.FILE_PATH);
            if(customers.isEmpty()) {
                throw new ApiException("Customers Data is empty, can't process further", HttpStatus.NO_CONTENT.value());
            }
            RestClient restClient = new RestClient(properties.getProperty(Constants.ENDPOINT), new RestTemplate());
            restClient.sendCustomerData(customers);
        }
        catch (ApiException exception){
            throw new ApiException("Customer data is null hence unable to process request: ", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        catch (Exception exception){
            throw new ApiException("Something went wrong. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
