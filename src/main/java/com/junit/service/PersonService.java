package com.junit.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.entity.Person;
import com.junit.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> data = null;
	public Person personData = null;
	
	public List<Person> getAllData()
	{
		try
		{
			this.data = (List<Person>) this.personRepository.findAll();
//			System.out.println(this.data);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Not able to connect to DB");
			System.out.println(e.getMessage());
		}
		return this.data;
	}
	
	public Person getPersonById(int id)
	{
		try 
		{
			this.personData = this.personRepository.findById(id).get();
		}catch(NoSuchElementException e)
		{
			System.out.println("No element found with this id");
			System.out.println(e.getMessage());
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Not able to connect to DB");
			System.out.println(e.getMessage());
		}
		return this.personData;
	}

	public Person postData(Person person) {
		// TODO Auto-generated method stub
		try 
		{
			this.personRepository.save(person);
		}catch(IllegalArgumentException e)
		{
			System.out.println("entity is null");
			System.out.println(e.getMessage());
			return null;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return person;
	}
}
