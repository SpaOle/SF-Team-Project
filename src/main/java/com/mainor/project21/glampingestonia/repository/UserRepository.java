package com.mainor.project21.glampingestonia.repository;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.mainor.project21.glampingestonia.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    public User save(User user) throws Exception {
        Firestore db = FirebaseDb.getFirestoreDb();
        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("password", user.getPassword());
        ApiFuture<DocumentReference> result =
                db.collection("users").add(data);
        user.setId(result.get().getId());
        return user;
    }

    public Optional<User> findById(String id) {
        Optional<User> result = Optional.empty();
        try {
            Firestore db = FirebaseDb.getFirestoreDb();
            DocumentReference docRef = db.collection("users").document(id);
            var data = docRef.get().get().getData();

            User user = new User();
            user.setId(id);
            user.setUsername((String) data.get("username"));
            user.setPassword((String) data.get("password"));
            result = Optional.of(user);
        } finally {
            return result;
        }
    }
}

