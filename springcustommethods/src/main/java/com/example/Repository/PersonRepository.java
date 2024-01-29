package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	List<Person> findByfirstName(String firstName);
	List<Person> findBySalaryBetween(double minsalary, double maxsalary);
	List<Person> findBySalaryGreaterThan(double salary);
	List<Person> findByAge(int age);
	List<Person> findByfirstNameAndAge(String firstName,int age);
}
