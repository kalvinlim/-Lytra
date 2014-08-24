package me.lytra.persistence.repository;

import me.lytra.domain.BlogPost;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends MongoRepository<BlogPost, Integer>{
	
/*	public List<BlogPost> findAll();
	
	@Query("Select p from BlogPost p where p.deleted = 0 and p.published = 1 order by p.timeStamp desc")
	public List<BlogPost> findAllByNewestFirstPublishedOnly();
	
	@Query("Select p from BlogPost p where p.deleted = 0 order by p.timeStamp desc")
	public List<BlogPost> findAllByNewestFirst();
	
	@Modifying
	@Query("update BlogPost p set p.published = 1 where p.id = ?1")
	public void publish(int id);*/
}
