package com.jpa.test;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;


//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		User user=new User();
		user.setName("amrendra");
		user.setCity("varanasi");
		user.setId(123);
		user.setStatus("404");
		
		User user1=userRepository.save(user);
		System.out.println(user1);
		
		Optional<User> optional=userRepository.findById(11);
		User value=optional.get();
		value.setName("xyz");
		
//		how to get all the data
		Iterable<User> iterator=userRepository.findAll();
		Iterator<User> itr=iterator.iterator();
		while(itr.hasNext()) {
			User user2=itr.next();
			System.out.println(user2);
		}
		
		iterator.forEach(user3->System.out.println(user3));
		
		
		
		
	}
	

}
