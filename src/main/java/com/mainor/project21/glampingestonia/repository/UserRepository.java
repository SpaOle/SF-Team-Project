package com.mainor.project21.glampingestonia.repository;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.mainor.project21.glampingestonia.mapper.UserMapper;
import com.mainor.project21.glampingestonia.model.User;

import java.util.Optional;

public class UserRepository {
    public User save(User user) throws Exception {
        Firestore db = FirebaseDb.getFirestoreDb();
        /*Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("password", user.getPassword());*/
        ApiFuture<DocumentReference> result =
                db.collection("users").add(UserMapper.toDto(user));
        user.setId(result.get().getId());
        return user;
    }

    public Optional<User> findById(String id) {
        return null;
    }
}

