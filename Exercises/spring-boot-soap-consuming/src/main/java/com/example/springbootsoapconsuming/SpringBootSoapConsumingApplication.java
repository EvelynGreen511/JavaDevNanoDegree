package com.example.springbootsoapconsuming;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class SpringBootSoapConsumingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapConsumingApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		NumberClient numberClient = new NumberClient();

		//create and setup marshaller
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		//provide location to the ObjectFacory
		marshaller.setContextPath("com.dataaccess.webservicesserver");

		//add marshaller to the client
		numberClient.setMarshaller(marshaller);
		numberClient.setUnmarshaller(marshaller);

		//retrieve the word format of the number
		NumberToWordsResponse response = numberClient.getWords("11235");

		//print to screen
		System.out.println(response.getNumberToWordsResult());
	}
}
