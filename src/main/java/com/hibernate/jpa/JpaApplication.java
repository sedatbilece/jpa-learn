package com.hibernate.jpa;

import com.hibernate.jpa.model.Person;
import com.hibernate.jpa.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		                    SpringApplication.run(JpaApplication.class, args);

		PersonRepository personRepository =
				   configurableApplicationContext.getBean(PersonRepository.class);

		Person myPerson = new Person("sedat","bilece");
		  personRepository.save(myPerson);
	}

}
