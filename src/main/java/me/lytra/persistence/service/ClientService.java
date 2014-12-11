package me.lytra.persistence.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import me.lytra.domain.client.AccessCode;
import me.lytra.domain.client.Client;
import me.lytra.persistence.repository.ClientRepository;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	static Logger logger = LoggerFactory.getLogger(ClientService.class);
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private GridFsService gridFsService;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	public List<Client> findAllWithGalleryCount(){
		List<Client> clients = clientRepository.findAll();
		for(Client client : clients){
			Integer count = gridFsService.getGridFSDBPhotoCountByClientId(client.getId());
			client.setPhotos(count);
		}
		return clients;
	}
	public Client save(Client client){
		return clientRepository.save(client);
	}
	public Client createClient(String name){
		Client client = new Client(name);
		DateTime today = new DateTime();		
		client.setCreated(today.toDate());
		client.setDeleted(false);
		logger.info("Creating client: {}", client);
		return client;		
	}
	
	
	public Client createAndPersistClientWithAccessCode(String name){
		Client client = new Client(name);
		DateTime today = new DateTime();		
		client.setCreated(today.toDate());
		client.setDeleted(false);
		
		client = save(client);
		
		AccessCode accessCode = generateClientAccessCode();
		
		client.setAccessCode(accessCode);
		
		client = save(client);
		
		logger.info("Created client with access code: {}", client);
		return client;		
	}
	
	public AccessCode generateClientAccessCode(){	
		AccessCode accessCode = new AccessCode();
		accessCode.setExpired(false);
		DateTime today = new DateTime();
		accessCode.setCreated(today.toDate());		
		accessCode.setCode(generateSecureString());
		
		return accessCode;
	}
	
	
	public String generateSecureString(){		
		return SessionIdentifierGenerator.nextSessionId();
	}

	public void delete(Client client){
		clientRepository.delete(client);
	}

	public Client findById(String id){
		return clientRepository.findById(id);
	}

	public final static class SessionIdentifierGenerator {
		  private static SecureRandom random = new SecureRandom();

		  public static String nextSessionId() {
		    return new BigInteger(130, random).toString(32);
		  }
	}
}
