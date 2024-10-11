package com.mainor.project21.glampingestonia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    private Long   id;
    private String username;
    private String password;
}
