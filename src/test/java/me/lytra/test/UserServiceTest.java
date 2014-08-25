package me.lytra.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import me.lytra.domain.user.User;
import me.lytra.init.Application;
import me.lytra.persistence.repository.UserRepository;
import me.lytra.persistence.service.UserService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


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
		
		logger.info("All users: {}", userService.findAll());
	}
	
	@Test
	public void testAuth(){
		User foo = userService.login("admin", "admin");
		logger.info("foo");
	}
	@Test 
	public void fooTest(){
		String file = "iStock_000015201389Small.jpg";
		logger.info("FileName: {}", file.split("\\.")[1]);
	}
	@Ignore @Test
	public void testCreateUser(){
		User initialUser = new User("admin", "admin", new Date(), false, true);
		User encryptedUser = userService.create(initialUser);
		logger.info("initial: {}", initialUser);
	}	
	public void testCreateDeleteUser(){
		User initialUser = new User("shouldNotExist", "shouldNotExist", new Date(), true, false);
		User encryptedUser = userService.create(initialUser);
		logger.info("initial: {}", initialUser);
		userService.delete(encryptedUser);
	}
}
