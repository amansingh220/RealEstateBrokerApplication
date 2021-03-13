package com.capg.rba.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.rba.entities.User;
import com.capg.rba.exceptions.InvalidEmailException;
import com.capg.rba.exceptions.InvalidPasswordException;
import com.capg.rba.repositories.IUserRepository;

@SpringBootTest
public class LoginServiceTests {

	@Autowired
	LoginServiceImpl loginService;

	@MockBean
	IUserRepository repository;

	@Test
	public void TestLoginLogin() {
		User user = new User();
		user.setEmail("ms2283939@gmail.com");
		user.setPassword("aktu45");

		Mockito.when(loginService.login(user)).thenReturn(user);
		User user1 = loginService.login(user);
		Assertions.assertEquals(user, user1);
	}

	@Test
	void TestLoginInvalidEmailException() {
		User user1 = new User();
		user1.setEmail("ms2283939@gmail.@com");
		user1.setPassword("aktu45");

		Mockito.when(loginService.login(user1)).thenThrow(new InvalidEmailException());
		Assertions.assertThrows(InvalidEmailException.class, () -> loginService.login(user1));

	}

	@Test
	void TestLoginInvalidPasswordException() {
		User user = new User();
		user.setEmail("ms2283939@gmail.com");
		user.setPassword("aktu45ldd");

		Mockito.when(loginService.login(user)).thenThrow(new InvalidPasswordException());
		Assertions.assertThrows(InvalidPasswordException.class, () -> loginService.login(user));

	}
}
