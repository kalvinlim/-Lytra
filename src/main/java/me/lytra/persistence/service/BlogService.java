package me.lytra.persistence.service;

import java.util.Date;
import java.util.List;

import me.lytra.domain.BlogPost;
import me.lytra.persistence.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {
	@Autowired
	BlogRepository blogRepository;
	
	public List<BlogPost> findAll(){
		return blogRepository.findAll();
	}
	public BlogPost save(BlogPost blogPost){
		blogPost.setTimeStamp(new Date(System.currentTimeMillis()));
		return blogRepository.save(blogPost);
	}
/*	public List<BlogPost> findAllByNewestFirstPublishedOnly(){
		return blogRepository.findAllByNewestFirstPublishedOnly();
	}
	public List<BlogPost> findAllByNewestFirst(){
		return blogRepository.findAllByNewestFirst();
	}
	public BlogPost save(BlogPost blogPost){
		blogPost.setTimeStamp(new Date(System.currentTimeMillis()));
		return blogRepository.save(blogPost);
	}
	public BlogPost save(BlogPost blogPost, Date timeStamp){
		blogPost.setTimeStamp(timeStamp);
		return blogRepository.save(blogPost);
	}
	public void delete(BlogPost blogPost){
		blogRepository.delete(blogPost);
	}
	public BlogPost findOne(Integer id){
		return blogRepository.findOne(id);
	}
	public void update(int id){
		blogRepository.publish(id);
	}*/
}
