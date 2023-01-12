package com.hibernate.jpa;

import com.hibernate.jpa.ManyToMany.Stream;
import com.hibernate.jpa.ManyToMany.StreamRepository;
import com.hibernate.jpa.ManyToMany.Viewer;
import com.hibernate.jpa.ManyToMany.ViewerRepository;
import com.hibernate.jpa.OneToMany.Cart;
import com.hibernate.jpa.OneToMany.CartRepository;
import com.hibernate.jpa.OneToMany.Item;
import com.hibernate.jpa.OneToMany.ItemRepository;
import com.hibernate.jpa.OneToMany_Unidirectional.Student;
import com.hibernate.jpa.OneToMany_Unidirectional.StudentRepository;
import com.hibernate.jpa.OneToMany_Unidirectional.University;
import com.hibernate.jpa.OneToMany_Unidirectional.UniversityRepository;
import com.hibernate.jpa.OneToOne_Unidirectional.Address;
import com.hibernate.jpa.OneToOne_Unidirectional.AddressRepository;
import com.hibernate.jpa.OneToOne_Unidirectional.User;
import com.hibernate.jpa.OneToOne_Unidirectional.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaApplication {


	private static final Logger log = LoggerFactory.getLogger((JpaApplication.class));
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		                    SpringApplication.run(JpaApplication.class, args);


		StreamRepository streamRepository = configurableApplicationContext.getBean(StreamRepository.class);
		ViewerRepository viewerRepository = configurableApplicationContext.getBean(ViewerRepository.class);

		Viewer viewer1 = new Viewer("sedat1");
		Viewer viewer2 = new Viewer("sedat12");
		Viewer viewer3 = new Viewer("sedat123");
		List<Viewer> viewerList = Arrays.asList(viewer1,viewer2,viewer3);

		Stream stream1 = new Stream ("techTalk");
		Stream stream2 = new Stream ("GamimgStream");
		List<Stream> streamList = Arrays.asList(stream1,stream2);

		streamRepository.saveAll(streamList);// stream1 and stream2 added to Stream table

		// associations
		viewer1.followStream(stream2);
		viewer2.followStream(stream2);
		viewer3.followStream(stream1);

		viewerRepository.saveAll(viewerList);// viewers added to Viewer table
        /*
		CartRepository cartRepository =configurableApplicationContext.getBean(CartRepository.class);
		ItemRepository itemRepository =configurableApplicationContext.getBean(ItemRepository.class);

		Cart cart =new Cart("visa");
		Item item1 = new Item("xx0432543",cart);
		Item item2 = new Item("xx8823423",cart);

		cart.setItemList(Arrays.asList(item1,item2));
		cartRepository.save(cart);
        */

		/*
		StudentRepository studentRepository =configurableApplicationContext.getBean(StudentRepository.class);
		UniversityRepository universityRepository =configurableApplicationContext.getBean(UniversityRepository.class);

		Student student1 = new Student("111");
		Student student2 = new Student("112");

		List<Student> students = Arrays.asList(student1,student2);
		University university = new University("Marmara",students);
		universityRepository.save(university);
		 */


		/*
		AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

		Address address = new Address("Kadıköy");
		addressRepository.save(address);

		User user =new User("sedat",address);
		User temp =userRepository.save(user);
        */

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
