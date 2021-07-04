package com.rakutech.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.rakutech.api.model.Administrator;

public interface AdministratorRepository extends JpaRepositoryImplementation<Administrator, Long> {
}
