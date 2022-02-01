package com.example.dloflife.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.dloflife.entities.User;
import com.example.dloflife.tests.Factory;

@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;

	private long exintingId;
	private long nonExintingId;
	private long countTotalUsers;
	private String existingEmail;
	private String nonExistingEmail;
	

	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		nonExintingId = 1000L;
		countTotalUsers = 2L;
		existingEmail = "thalles@gmail.com";
		nonExistingEmail = "trevizan@gmail.com";
	}

	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(exintingId);
		Optional<User> result = repository.findById(exintingId);

		Assertions.assertFalse(result.isPresent());
	}

	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExintingId);
		});
	}

	@Test
	public void saveShouldPersistWithAutoincrement() {
		User user = Factory.createUser();
		user.setId(null);

		user = repository.save(user);

		Assertions.assertNotNull(user.getId());
		Assertions.assertEquals(countTotalUsers + 1, user.getId());
	}

	@Test
	public void findByIdShouldReturnNonEmptyOptionalWhenIdExists() {
		Optional<User> result = repository.findById(exintingId);
		Assertions.assertTrue(result.isPresent());
	}

	@Test
	public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExists() {
		Optional<User> result = repository.findById(nonExintingId);
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void findByEmailShouldReturnNonEmptyObjectWhenEmailExists() {
		User result = repository.findByEmail(existingEmail);
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void findByEmailShouldReturnEmptyObjectWhenEmailExists() {
		User result = repository.findByEmail(nonExistingEmail);
		Assertions.assertNull(result);
	}
	
	

}
