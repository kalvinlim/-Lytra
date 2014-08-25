package me.lytra.persistence.service;

import java.io.IOException;

import me.lytra.domain.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Service
public class GridFsService {
	
	static Logger logger = LoggerFactory.getLogger(GridFsService.class);
	
	@Autowired
	GridFsOperations operations;
	
	public void saveOne(MultipartFile file, User user, String fileName){
		String extension = file.getOriginalFilename().split("\\.")[1];
		DBObject metaData = new BasicDBObject();
		
		metaData.put("username", user.getUsername());
		metaData.put("userid", user.getId());
		
		String fileNameResult = fileName + "." + extension;
		//Resource file = new ClassPathResource("iStock_000015201389Small.jpg");
		try {
			operations.store(file.getInputStream(), fileNameResult, metaData);
			logger.info("Saved file into mongodb: {}, with user: {}", fileNameResult, user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
