package com.example.fcmtester;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class FCMIntializer {

    @PostConstruct
    public void init() throws IOException {

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("/credentials.json")))
                //.setProjectId("demo1-2009e")
                .build();

        FirebaseApp.initializeApp(options);

    }

}
