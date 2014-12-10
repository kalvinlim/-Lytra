package me.lytra.persistence.repository;

import java.util.List;

import me.lytra.domain.client.Client;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends MongoRepository<Client, String>{
	public Client findByName(String username);
	public List<Client> findAll();
	public Client findById(String id);
}