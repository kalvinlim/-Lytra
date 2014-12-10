package me.lytra.test;

import static org.junit.Assert.assertTrue;
import me.lytra.domain.client.AccessCode;
import me.lytra.domain.client.Client;
import me.lytra.init.Application;
import me.lytra.persistence.repository.ClientRepository;
import me.lytra.persistence.service.ClientService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ClientServiceTest {
	static Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);
	
	@Autowired private ClientService clientService;
	
	@Autowired ClientRepository cr;
	
	@Autowired MongoOperations mongoOperations;
	
	 
	
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void whenContextIsBootstrapped_thenNoExceptions() {
		assertTrue(true);
	}	
	@Ignore @Test
	public void createClient(){		
	
		Client client = clientService.createClient("TestClient1");	
		client.setAccessCode(clientService.generateClientAccessCode());
		logger.info("Creating client: {}", client);				
	}
	@Ignore @Test
	public void createClientAndPersist(){		
	
		Client client = clientService.createClient("TestClient1");	
		client = clientService.save(client);
		
		AccessCode accessCode = clientService.generateClientAccessCode();
		accessCode.setUserId(client.getId());
		
		client.setAccessCode(accessCode);
		clientService.save(client);
		logger.info("Created client: {}", client);				
		//clientService.delete(client);
		logger.info("deleted client: {}", clientService.findAll());
	}
	@Test
	public void findAll(){		
		logger.info("Fetching all: {}",clientService.findAll());
		
		//Client client = new Client();
		//client.setId("5487e0b7f97b4e2bb2bce083");
		//clientService.delete(client);
		//logger.info("deleting: {}",clientService.findAll());
	}
	@Test
	public void findByAccessCode(){
		logger.info("Searching for client accesscode: {}, fv2vu31shgcnhp8uvr3gkib818");
				
		Client client = mongoOperations.findOne(new Query().addCriteria(Criteria.where("accessCode.code").is("fv2vu31shgcnhp8uvr3gkib818")), Client.class);
		
		logger.info("{}", client);
	}
	@Ignore @Test
	public void createClientAccessCode(){
		
		Client client = clientService.createClient("TestClient1");
		AccessCode accessCode = clientService.generateClientAccessCode();
				
		client.setAccessCode(accessCode);
		
		logger.info("{}", client);
		logger.info("{}", accessCode);
	}
}
