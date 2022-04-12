package com.database.dbex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.dbex.dto.PersonResponse;
import com.database.dbex.dto.PresonRequest;
import com.database.dbex.model.Persons;
import com.database.dbex.service.PersonsService;

@RestController
@RequestMapping("/persons")
public class PersonsController {
	
	@Autowired
	private PersonsService ps;
	
	@PostMapping("/save")
	ResponseEntity<PersonResponse> savePerson(@RequestBody PresonRequest pReq) {
		
		
	    return new ResponseEntity<>(ps.savePerson(pReq), HttpStatus.OK);
	} 
	
	@GetMapping("/get")
	ResponseEntity<List<Persons>> getPersons() {
		
		
	    return new ResponseEntity<>(ps.getPerson(), HttpStatus.OK);
	}
	@PutMapping("/update")
	ResponseEntity<Persons> updatePerson(@RequestBody PresonRequest pReq){
		return new ResponseEntity<>(ps.updatePerson(pReq), HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersons(@PathVariable Long id){
		return new ResponseEntity<>(ps.deletePerson(id), HttpStatus.OK);
	}
}
