package me.lytra.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import me.lytra.domain.BlogPost;
import me.lytra.init.Application;
import me.lytra.persistence.service.BlogService;

import org.junit.Before;
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
public class BlogServiceTest {
	static Logger logger = LoggerFactory.getLogger(BlogServiceTest.class);
	
	@Autowired 
	private BlogService blogService;
	
	private BlogPost blogPost;
	
	@Before
	public void setUp() throws Exception {
		blogPost = new BlogPost();
		blogPost.setTitle("Title 999");
		blogPost.setContent("Content 999");
	}
	@Test
	public void whenContextIsBootstrapped_thenNoExceptions() {
		assertTrue(true);
	}
	
	@Test
	public void findAll(){
		//blogService.save(blogPost);
		List<BlogPost> blogPosts = blogService.findAll();
		logger.info("Posts: {}", blogPosts);
		//assertTrue(blogPosts.contains(blogPost));
	}
	
	@Test
	public void testSave(){
		//BlogPost saved = blogService.save(blogPost);
		//assertTrue(saved.getId() != null);
	}
/*	@Test 
	public void testFindAllByNewestFirst(){
		DateTime today = new DateTime();
	    DateTime tomorrow = today.plusDays(1);
	    DateTime dayAfterTomorrow = today.plusDays(2);
	    
		BlogPost blogPost1 = new BlogPost();
		blogPost1.setTitle("First Post");
		blogPost1.setContent("Content");
		BlogPost blogPost2 = new BlogPost();
		blogPost2.setTitle("Second Post");
		blogPost2.setContent("Content");
		BlogPost blogPost3 = new BlogPost();
		blogPost3.setTitle("Third Post");
		blogPost3.setContent("Content");		
		
	    
	    BlogPost blogPostSaved1 = blogService.save(blogPost1, today.toDate());
	    BlogPost blogPostSaved2 = blogService.save(blogPost2, tomorrow.toDate());
	    BlogPost blogPostSaved3 = blogService.save(blogPost3, dayAfterTomorrow.toDate());
	    
		List<BlogPost> blogPosts = blogService.findAllByNewestFirst();
			
		assertTrue(blogPosts.size() >= 3);
		assertTrue(blogPosts.get(0).getId() > blogPosts.get(1).getId());
		assertTrue(blogPosts.get(1).getId() > blogPosts.get(2).getId());

	}*/
}
