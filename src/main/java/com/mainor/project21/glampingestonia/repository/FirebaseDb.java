package com.mainor.project21.glampingestonia.repository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import java.io.IOException;

public class FirebaseDb {
    static Firestore db;

    public static synchronized Firestore getFirestoreDb() throws IOException {
        if (db != null)
            return db;

        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId("glamping-estonia")
                        .setDatabaseId("glampingestonia")
                        .setCredentials(GoogleCredentials.getApplicationDefault())
                        .build();
        db = firestoreOptions.getService();
        return db;
    }
}
