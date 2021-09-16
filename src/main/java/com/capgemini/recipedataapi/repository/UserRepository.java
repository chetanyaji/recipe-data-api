package com.capgemini.recipedataapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.recipedataapi.model.User;

/**
 * This user repository interface containing transaction related methods.
 * 
 * @author chetasin
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
