package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import com.example.Entity.Person;
import com.example.Repository.PersonRepository;

@SpringBootApplication
public class SpringcustommethodsApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringcustommethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		personRepository.save(new Person(1, "deekshitha", "patruni", 22, 50000.00));
		personRepository.save(new Person(2, "adilaxmi", "rodda", 22, 40000.00));
		personRepository.save(new Person(3, "rajyalaxmi", "rodda", 24, 30000.00));
		List<Person>personWithfirstName=personRepository.findByfirstName("deekshitha");
		List<Person>personWithAge22=personRepository.findByAge(22);
		List<Person>personSalaryGreaterThan=personRepository.findBySalaryGreaterThan(30000.00);
		List<Person>personSalaryBetween=personRepository.findBySalaryBetween(30000.00, 50000.00);
		List<Person>personWithfirstNameAndAge=personRepository.findByfirstNameAndAge("deekshitha", 22);
		System.out.println("person with first name");
		printPersons(personWithfirstName);
		System.out.println("persons with age 22");
		printPersons(personWithAge22);
		System.out.println("person with salary greaterthan 30000");
		printPersons(personSalaryGreaterThan);
		System.out.println("persons with salary between");
		printPersons(personSalaryBetween);
		System.out.println("persons with name and age");
		printPersons(personWithfirstNameAndAge);
		
		
	}

	private void printPersons(List<Person> persons) {
		// TODO Auto-generated method stub
		for(Person person:persons) {
			System.out.println(person.getId()+""+person.getFirstName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getSalary());
		}
		
	}

}
