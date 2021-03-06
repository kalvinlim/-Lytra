package me.lytra.persistence.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.lytra.domain.client.Client;
import me.lytra.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@Service
public class GridFsService {
	
	static Logger logger = LoggerFactory.getLogger(GridFsService.class);
	
	@Autowired
	private GridFsOperations operations;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	public void saveOne(MultipartFile file, Client client){
		
		DBObject metaData = new BasicDBObject();
		
		
		Client completedClient = clientService.findById(client.getId());
		
				
		metaData.put("clientid", completedClient.getId());
		metaData.put("clientname", completedClient.getName());
		
		logger.info("Attempting to save file into mongodb: {}, with client: {}, metadata: {}", file.getOriginalFilename(), completedClient, metaData);
		try {
			operations.store(file.getInputStream(), file.getOriginalFilename(), metaData);
			logger.info("Saved file into mongodb: {}, with client: {}", file.getOriginalFilename(), completedClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<GridFSDBFile> getGridFSDBFilesByUserId(String id){
		List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.clientid").is(id)));
		return result;
	}
	public GridFSDBFile getGridFSDBFileByPhotoId(String id){
		GridFSDBFile result = operations.findOne(new Query().addCriteria(Criteria.where("_id").is(id)));
		return result;
	}
	public void deleteGridFSDBFileByPhotoId(String id){
		GridFSDBFile result = operations.findOne(new Query().addCriteria(Criteria.where("_id").is(id)));
		logger.info("Photo delete processed for: {}, ", result);
		operations.delete(new Query().addCriteria(Criteria.where("_id").is(id)));		
	}
	public List<String> getGridFSDBPhotoIdsByClientId(String clientid){
		
		List<GridFSDBFile> files = operations.find(new Query().addCriteria(Criteria.where("metadata.clientid").is(clientid)));
		List<String> photoIds = new ArrayList<>();
		
		
		for(GridFSDBFile file : files){
			photoIds.add(file.getId().toString());
		}
		
		if(photoIds.size() > 0){
			return photoIds;
		}
		return Collections.emptyList();
	}	
	public int getGridFSDBPhotoCountByClientId(String clientid){
		Integer count = operations.find(new Query().addCriteria(Criteria.where("metadata.clientid").is(clientid))).size();
		//logger.info("searching for files with userID: {}", userid);
		//logger.info("found: {}", operations.find(new Query().addCriteria(Criteria.where("metadata.userid").is(userid))));
		return count;
	}
	
}
