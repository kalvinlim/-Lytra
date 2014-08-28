package me.lytra.persistence.service;

import java.io.IOException;
import java.util.List;

import me.lytra.domain.user.User;

import org.junit.Test;
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
	GridFsOperations operations;
	
	@Autowired
	UserService userService;
	
	public void saveOne(MultipartFile file, User user, String fileName){
		String extension = file.getOriginalFilename().split("\\.")[1];
		DBObject metaData = new BasicDBObject();
		
		User completedUser = userService.findById(user.getId());
		
		metaData.put("username", completedUser.getUsername());
		metaData.put("userid", completedUser.getId());
		
		String fileNameResult = fileName + "." + extension;
		//Resource file = new ClassPathResource("iStock_000015201389Small.jpg");
		
		
		
		
		try {
			operations.store(file.getInputStream(), fileNameResult, metaData);
			logger.info("Saved file into mongodb: {}, with user: {}", fileNameResult, completedUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<GridFSDBFile> getGridFSDBFilesByUserId(String id){
		//List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.foo").is("Bar")));
		
		List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.userid").is(id)));
		
		return result;
	}
}
