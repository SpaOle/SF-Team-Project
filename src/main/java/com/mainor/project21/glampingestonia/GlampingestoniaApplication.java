package com.mainor.project21.glampingestonia;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GlampingestoniaApplication {

	public static void main(String[] args) throws IOException {
		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl("https://glamping-estonia-default-rtdb.europe-west1.firebasedatabase.app/")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(GlampingestoniaApplication.class, args);
	}

}
