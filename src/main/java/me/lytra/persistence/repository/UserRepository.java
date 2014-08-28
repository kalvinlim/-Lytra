package me.lytra.persistence.repository;

import java.util.List;

import me.lytra.domain.user.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("Select p from User p where p.deleted = 0 and p.username = ?1")
	public User findByUsername(String username);
	
	public List<User> findAll();
	
	@Query("Select p from User p where p.deleted = 0")
	public List<User> findAllByActiveOnly();

}

*/
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByUsername(String username);
	public List<User> findAll();
	public User findById(String id);
}