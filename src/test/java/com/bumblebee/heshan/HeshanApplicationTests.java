package com.bumblebee.heshan;

import com.bumblebee.heshan.controller.AuthController;
import com.bumblebee.heshan.controller.CustomersController;
import com.bumblebee.heshan.controller.ProductController;
import com.bumblebee.heshan.payload.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bumblebee.heshan.model.Product;
import com.bumblebee.heshan.service.ProductService;

@SpringBootTest
class TestloginAdmin {

@Autowired
AuthController authController;

	@Test
	void Test() {
		LoginRequest loginRequest=new LoginRequest();
		loginRequest.setUsername("admin1");
		loginRequest.setPassword("123456789");

		System.out.println(authController.authenticateUser(loginRequest).getBody());
	}

}
