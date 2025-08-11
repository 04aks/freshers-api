package aks.freshers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aks.freshers.service.firebase.FirebaseInit;

@SpringBootApplication
public class FreshersApplication {

	public static void main(String[] args) {
		//initialize firebase database 
		new FirebaseInit();
		SpringApplication.run(FreshersApplication.class, args);
	}

}
