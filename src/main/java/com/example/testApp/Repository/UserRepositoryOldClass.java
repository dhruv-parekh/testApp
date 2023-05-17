//package com.example.testApp.Repository;
//
//import com.example.testApp.models.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserRepositoryOldClass {
//
//    List<User> userList = new ArrayList<>();
//    public User getUser(){
//        return new User("Dhruv","Canada",29,"R/Codes/ProfilePics/");
//    }
//
//    public User saverUser(User user) {
//        user.setUserId(userList.size()+1);
//        userList.add(user);
//        return user;
//    }
//
//    public List<User> getAllUsers() {
//        return userList;
//    }
//
//    public User getUserByUserId(int userId) {
//        User user;
//        for (User u :userList) {
//            if (userId == u.getUserId()){
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public User updateUserById(int userId, User user) {
//
//        for (User u : userList) {
//            if(userId == u.getUserId()){
//                u.setName(user.getName());
//                u.setAddress(user.getAddress());
//                u.setAge(user.getAge());
//                u.setProfilePicUrl(user.getProfilePicUrl());
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public void deleteUserById(int userId) {
//        for (User user: userList) {
//            if(userId==user.getUserId()){
//                userList.remove(user);
//                break;
//            }
//        }
//    }
//}
