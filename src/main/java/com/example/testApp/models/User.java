package com.example.testApp.models;

import com.example.testApp.Validation.ValidName;
import com.example.testApp.Validation.ValidPhoneNumber;
import com.example.testApp.Validation.ValidWebsite;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.*;

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

    @ValidPhoneNumber
    @Size(max = 21)
    private String phoneNumber;

    @ValidWebsite
    private String website;


    public User() {
    }
//    @PersistenceConstructor
    public User(String name, String address, String email, int age, String profilePicUrl, String phoneNumber, String website) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    @PersistenceConstructor
    public User(String id,String name, String address, String email, int age, String profilePicUrl, String phoneNumber, String website) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
