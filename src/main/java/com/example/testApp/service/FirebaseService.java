package com.example.testApp.service;

import com.example.testApp.model.FirebaseUser;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {

//    public FirebaseApp initialiseFirebase() throws IOException {
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resolver.getResource("classpath:photoapplication-55bd7-firebase.json");
//
//        FileInputStream serviceAccount =
//                new FileInputStream(resource.getFile());
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//        return FirebaseApp.initializeApp(options);
//
//    }

    public FirebaseUser authenticate(String idToken) throws IOException, FirebaseAuthException {

        String uid = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
        String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();
        String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();

        return new FirebaseUser(uid,email,name);
    }
}
