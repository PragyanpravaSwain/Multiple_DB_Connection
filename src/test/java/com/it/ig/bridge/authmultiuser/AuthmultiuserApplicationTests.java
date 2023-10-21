package com.it.ig.bridge.authmultiuser;

import com.it.ig.bridge.authmultiuser.mysql1.entities.Product;
import com.it.ig.bridge.authmultiuser.mysql1.repo.ProductRepo;
import com.it.ig.bridge.authmultiuser.mysql2.entities.User;
import com.it.ig.bridge.authmultiuser.mysql2.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthmultiuserApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductRepo productRepo;
	@Test
	public void dbTest(){
		User user = User.builder().firstName("Pragyan").lastName("Swain").email("pragyanpravas@gmail.com").build();

		Product product = Product.builder().name("Apple").price(100000).live(true).description("This is Apple Product.").build();
		productRepo.save(product);
		userRepo.save(user);
		System.out.println("Data Saved");
	}
	@Test
	public void getData(){
		productRepo.findAll().forEach(product -> System.out.println(product.getName()));
		userRepo.findAll().forEach(user -> System.out.println(user.getFirstName()));
	}

}
