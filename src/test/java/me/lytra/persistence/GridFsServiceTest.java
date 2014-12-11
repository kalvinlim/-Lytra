package me.lytra.persistence;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import me.lytra.init.Application;
import me.lytra.persistence.repository.UserRepository;
import me.lytra.persistence.service.GridFsService;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class GridFsServiceTest {

	@Autowired
	GridFsOperations operations;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(GridFsServiceTest.class);
	
	@Autowired GridFsService gridFsService;
	
	@Test
	public void testBootstrapped() {
		assertTrue(true);
	}

	@Ignore @Test
	public void testGrid(){
		DBObject metaData = new BasicDBObject();
		metaData.put("foo", "Bar");
		
		Resource file = new ClassPathResource("iStock_000015201389Small.jpg");
		try {
			operations.store(file.getInputStream(),"testfile.jpg", metaData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Ignore @Test 
	public void testGridFsRetrieve(){
		List<GridFSDBFile> result = operations.find(
	               new Query().addCriteria(Criteria.where("metadata.foo").is("Bar")));
		
		logger.info("{}", result.size());
		
		for(GridFSDBFile file : result){
			try {
				file.writeTo("/cache/fooFileTest.jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Ignore @Test
	public void testGridFsRetrieveByUserId(){
		//List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.foo").is("Bar")));
		String userid = "53ffe8ea8d598e24fa67d190";
		List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.userid").is(userid)));
		
		logger.info("{}", result.size());
		
		for(GridFSDBFile file : result){
			logger.info("{}", file.toString());
			logger.info("{}", file.getId());
			
			logger.info("==========================================");
		}
	}
	@Ignore @Test
	public void testGridFsRetrieveByPhotoId(){
		//List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("metadata.foo").is("Bar")));
		String photo1 = "540675d18d5940db8c78dca3";
		String photo2 = "540672cd8d5940db8c78dca0";
		
		List<GridFSDBFile> result = operations.find(new Query().addCriteria(Criteria.where("_id").is(photo2)));
		
		logger.info("{}", result.size());
		
		for(GridFSDBFile file : result){
			logger.info("{}", file.toString());
			logger.info("{}", file.getId());
			
			logger.info("==========================================");
		}
	}
	@Ignore @Test
	public void testGetGridFSDBPhotoIdsByUserId(){
		String userid = "53ffe8ea8d598e24fa67d190";
		//logger.info("photo ids: {}", gridFsService.getGridFSDBPhotoIdsByUserId(userid));
	}
	@Ignore @Test
	public void testGetGridFSDBPhotoCountByUserId(){
		String userid = "53ffe8ea8d598e24fa67d190";
		Integer size = operations.find(new Query().addCriteria(Criteria.where("metadata.userid").is(userid))).size();
		
		logger.info("Size: {}", size);
		 
	}
	
	public void testClient(){
		
	}
	
}