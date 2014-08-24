package me.lytra.test;

import static org.junit.Assert.assertTrue;
import me.lytra.init.Application;
import me.lytra.persistence.service.JBCryptService;

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
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//@Transactional
public class JBCryptServiceTest {
	static Logger logger = LoggerFactory.getLogger(JBCryptServiceTest.class);
	
	@Autowired JBCryptService jbCryptService;
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void whenContextIsBootstrapped_thenNoExceptions() {
		assertTrue(true);
	}
	
	@Test
	public void hashTest(){
		jbCryptService.hash();
	}
	

}
