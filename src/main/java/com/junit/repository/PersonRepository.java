package com.junit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.junit.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
