package com.junit.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junit.entity.Person;
import com.junit.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	private List<Person> data = null;
	private Person uniquePersonData = null;
	
	@GetMapping("/persondata")
	public ResponseEntity<List<Person>> personData()
	{
		this.data = this.personService.getAllData();
		if(this.data.size() == 0)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
		{
//			System.out.println(this.data);
			return ResponseEntity.status(HttpStatus.FOUND).body(this.data);
		}
	}
	
	@GetMapping("/persondata/{id}")
	public ResponseEntity<Person> personDataById(@PathVariable("id") int id)
	{
		this.uniquePersonData = this.personService.getPersonById(id);
		if(this.uniquePersonData == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.FOUND).body(this.uniquePersonData);
	}
	
	@PostMapping("/persondata")
	public ResponseEntity<Person> postPersonData(@RequestBody Person person)
	{
//		System.out.println(person);
		this.uniquePersonData = this.personService.postData(person);
		if(this.uniquePersonData == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else
			return ResponseEntity.status(HttpStatus.CREATED).body(this.uniquePersonData);
	}
	
	
}
