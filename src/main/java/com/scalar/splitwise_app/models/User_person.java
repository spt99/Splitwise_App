package com.scalar.splitwise_app.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User_person extends BaseModel{
    private String name;
    private String phoneNumber;
    private String password;

}
