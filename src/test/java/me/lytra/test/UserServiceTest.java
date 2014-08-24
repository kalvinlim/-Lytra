package me.lytra.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import me.lytra.domain.user.User;
import me.lytra.init.Application;
import me.lytra.persistence.repository.UserRepository;
import me.lytra.persistence.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//@Transactional
public class UserServiceTest {
	static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired 
	private UserService userService;
	
	@Autowired UserRepository usr;
	private User User;
	
	 
	
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void whenContextIsBootstrapped_thenNoExceptions() {
		assertTrue(true);
	}
	
	@Test
	public void findAll(){
		
		logger.info("STUFF: {}", userService.findAll());
	}
	
	@Test
	public void testAuth(){
		User foo = userService.login("admin", "admin");
		logger.info("foo");
	}

/*	@Test
	public void testCreateUser(){
		User initialUser = new User("admin", "admin", new Date(), false, true);
		User encryptedUser = userService.create(initialUser);
		logger.info("initial: {}", initialUser);
	}
*/

}
