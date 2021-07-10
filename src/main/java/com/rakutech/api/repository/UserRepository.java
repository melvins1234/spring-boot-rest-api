package com.rakutech.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.rakutech.api.model.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
	@Query("SELECT u from User u WHERE u.email = :email")
	Optional<User> findByEmailAddress(@Param("email") String email);
}
