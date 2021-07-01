package com.rakutech.api.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.rakutech.api.model.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
	
}
