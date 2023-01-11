package com.hibernate.jpa;

import com.hibernate.jpa.model.OneToOne.Car;
import com.hibernate.jpa.model.OneToOne.CarRepository;
import com.hibernate.jpa.model.OneToOne.Owner;
import com.hibernate.jpa.model.OneToOne.OwnerRepository;
import com.hibernate.jpa.model.OneToOne_Unidirectional.Address;
import com.hibernate.jpa.model.OneToOne_Unidirectional.AddressRepository;
import com.hibernate.jpa.model.OneToOne_Unidirectional.User;
import com.hibernate.jpa.model.OneToOne_Unidirectional.UserRepository;
import com.hibernate.jpa.model.Person;
import com.hibernate.jpa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class JpaApplication {


	private static final Logger log = LoggerFactory.getLogger((JpaApplication.class));
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		                    SpringApplication.run(JpaApplication.class, args);


		AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

		Address address = new Address("Kadıköy");
		addressRepository.save(address);

		User user =new User("sedat",address);
		User temp =userRepository.save(user);


		/*
		CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
		OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);

		Car car = new Car("m200");
		carRepository.save(car);

		Owner owner= new Owner("sedat bilece");
		owner.setCar(car);
		ownerRepository.save(owner);

		Optional<Car> optionalCar = carRepository.findById(1L);
		Optional<Owner> optionalOwner = ownerRepository.findById(1L);

		log.info(optionalCar.get().getModel() +" owner is"+optionalCar.get().getOwner().getName());
        */

		/*
		PersonRepository personRepository =
				   configurableApplicationContext.getBean(PersonRepository.class);

		Person myPerson = new Person("sedat","bilece");
		  personRepository.save(myPerson);
		  */

	}

}
