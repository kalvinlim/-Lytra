package me.lytra.persistence.service;

import java.util.List;

import me.lytra.domain.user.User;
import me.lytra.persistence.repository.UserRepository;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private JBCryptService jbCryptService;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User create(User user){
		String hashedPassword = jbCryptService.hashPassword(user.getPassword());
		user.setPassword(hashedPassword);
		
		DateTime today = new DateTime();
		
		user.setCreated(today.toDate());
		logger.info("Creating User: {}", user);
		return userRepository.save(user);
	}
	public void delete(User user){
		userRepository.delete(user);
	}
	
	public User login(String username, String password){
		User validUser = userRepository.findByUsername(username);
		String hashed = validUser.getPassword();
		Boolean valid = jbCryptService.checkpw(password, hashed);
		if(valid){
			return validUser;
		}
		else{
			return null;	
		}
		
	}
	
	public boolean createUser(String username, String password){
		return false;
	}
	
	public boolean usernameExists(String username){
		User user = userRepository.findByUsername(username);
		return user!=null;
	}
	
	/*static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	

	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User create(User user){
		String hashedPassword = jbCryptService.hashPassword(user.getPassword());
		user.setPassword(hashedPassword);
		
		DateTime today = new DateTime();
		user.setCreated(today.toDate());
		logger.info("Creating User: {}", user);
		return userRepository.save(user);
	}
	public void delete(User user){
		userRepository.delete(user);
	}
	
	public User login(String username, String password){
		User validUser = userRepository.findByUsername(username);
		String hashed = validUser.getPassword();
		Boolean valid = jbCryptService.checkpw(password, hashed);
		if(valid){
			return validUser;
		}
		else{
			return null;	
		}
		
	}
	
	public boolean createUser(String username, String password){
		return false;
	}
	
	public boolean usernameExists(String username){
		User user = userRepository.findByUsername(username);
		return user!=null;
	}*/
}
