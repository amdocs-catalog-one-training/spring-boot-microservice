package com.amdocs.restservice.learnmicroservice.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.hibernate.JDBCException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.restservice.learnmicroservice.dao.DaoRegister;
import com.amdocs.restservice.learnmicroservice.models.RegModel;
import com.amdocs.restservice.learnmicroservice.repositories.RegistrationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jersey.repackaged.com.google.common.collect.Lists;




@RestController
@RequestMapping("/api")
public class MainRestController {

	 @Autowired
	 RegistrationRepository registrationRepository;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<String> registerationStatus(@RequestBody RegModel model) {
		
		DaoRegister daoRegister = new DaoRegister();
		daoRegister.setId(UUID.randomUUID());
		daoRegister.setLogin(model.getLogin());
		daoRegister.setPassword(model.getPassword());
		daoRegister.setRegDate(new Date());
		daoRegister.setUpdateDate(new Date());
		try {
			registrationRepository.save(daoRegister);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			ObjectMapper mapper = new ObjectMapper();
			String string = mapper.writeValueAsString(daoRegister);

			return new ResponseEntity<String>(string, HttpStatus.CREATED);

		} catch (JDBCException | JsonProcessingException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper = new ObjectMapper();
		Iterable<DaoRegister> itr = registrationRepository.findAll();
		ArrayList<DaoRegister> arrayListOfUsers = Lists.newArrayList(itr);
		String users = "";
		try {
			 users = mapper.writeValueAsString(arrayListOfUsers);
		} catch (JsonProcessingException e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(users, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String test() {
		System.out.print("terminate");
		return "hello lord";
	}

}