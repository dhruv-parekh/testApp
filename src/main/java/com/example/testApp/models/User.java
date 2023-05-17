package com.example.testApp.models;

import com.example.testApp.Validation.ValidName;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {

    @Id
    private String id;

    @NotEmpty @ValidName
    private String name;

    @NotEmpty
    private String address;

    @Email
    private String email;

    @Min(value = 13)
    private int age;

    @NotEmpty
    private String profilePicUrl;

    public User(String name, String address, String email, int age, String profilePicUrl) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
