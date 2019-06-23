package com.avenir.retail.bill.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avenir.retail.bill.entities.User;
import com.avenir.retail.bill.enums.UserTypeEnum;

@Service
public class UserService { 

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	private Map<Long, User> usersDetailsMap;
	
	/**
	 * Loads the registered users of retail website.
	 * 
	 */
	@PostConstruct
	private void initUsers() {
		LOGGER.info("Pre Loading users ... ");
		// Considering this as list of users from DB.
		usersDetailsMap = new HashMap<>();
		usersDetailsMap.put(1L, new User(1L, "Ram", "Prasad", "abcd@gmail.com", "+919876543211", UserTypeEnum.Employee));
		usersDetailsMap.put(2L, new User(2L, "Ravi", "Varma", "abce@gmail.com", "+919876543212", UserTypeEnum.Employee));
		usersDetailsMap.put(3L, new User(3L, "Raghu", "Ram", "abcf@gmail.com", "+919876543213", UserTypeEnum.Affiliate));
		usersDetailsMap.put(4L, new User(4L, "Syed", "Ashraf", "abcf@gmail.com", "+919876543214", UserTypeEnum.New));
		usersDetailsMap.put(5L, new User(5L, "Mega", "G", "abch@gmail.com", "+919876543215", UserTypeEnum.Affiliate));
		usersDetailsMap.put(6L, new User(6L, "Ragini", "Viswanathan", "abci@gmail.com", "+919876543216", UserTypeEnum.Regular));
		usersDetailsMap.put(7L, new User(7L, "John", "Wesley", "abcj@gmail.com", "+919876543217", UserTypeEnum.Employee));
		usersDetailsMap.put(8L, new User(8L, "Prasanth", "A", "abck@gmail.com", "+919876543218", UserTypeEnum.New));
		
	}
	
	/**
	 * Gets the all the users registered.
	 * 
	 * @return usersMap
	 */
	public Map<Long, User> getUsers() {
		return usersDetailsMap;
	}
	
	/**
	 * Gets the user of given id.
	 * 
	 * @param id
	 * @return user
	 */
	public User getUser(Long id) {
		User user = usersDetailsMap.get(id);
		
		return user;
	}

}
