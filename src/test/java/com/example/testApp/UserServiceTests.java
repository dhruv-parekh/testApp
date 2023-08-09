package com.example.testApp;

import com.example.testApp.models.User;
import com.example.testApp.service.TestAppService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTests {


	@Autowired
	private TestAppService testAppService;

	@BeforeEach
	public void saveUser(){
		testAppService.saveUser(new User("7","Dhruv","Gujarat India","test@gmail.com",30,"c:/test/sample.jpg","+1234567890","http://test.com"));
	}

	@Test
	public void getUser(){
		User user = testAppService.findUserById("7");
		Assert.assertEquals("Dhruv",user.getName());
	}

	@Test
	public void editUser(){
		User user = testAppService.findUserById("7");
		user.setName("Arpit");
		testAppService.saveUser(user);
		Assert.assertEquals("Dhruv",user.getName());
	}

	@After
	public void deleteUser(){
		testAppService.deleteuserById("7");
	}


}
