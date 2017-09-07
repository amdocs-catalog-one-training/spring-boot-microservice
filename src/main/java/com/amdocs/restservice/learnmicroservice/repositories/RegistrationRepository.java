package com.amdocs.restservice.learnmicroservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.amdocs.restservice.learnmicroservice.dao.DaoRegister;

public interface RegistrationRepository extends CrudRepository<DaoRegister, UUID> {

}
