package com.example.dloflife.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.dloflife.entities.Role;
import com.example.dloflife.tests.Factory;

@DataJpaTest
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository repository;

	private long exintingId;
	private long nonExintingId;
	private long countTotalRoles;

	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		nonExintingId = 1000L;
		countTotalRoles = 2L;
	}

	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(exintingId);
		Optional<Role> result = repository.findById(exintingId);

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
		Role role = Factory.createRole();
		role.setId(null);

		role = repository.save(role);

		Assertions.assertNotNull(role.getId());
		Assertions.assertEquals(countTotalRoles + 1, role.getId());
	}

	@Test
	public void findByIdShouldReturnNonEmptyOptionalWhenIdExists() {
		Optional<Role> result = repository.findById(exintingId);
		Assertions.assertTrue(result.isPresent());
	}

	@Test
	public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExists() {
		Optional<Role> result = repository.findById(nonExintingId);
		Assertions.assertTrue(result.isEmpty());
	}
}
