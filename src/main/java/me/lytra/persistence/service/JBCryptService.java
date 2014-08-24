package me.lytra.persistence.service;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class JBCryptService {
	static Logger logger = LoggerFactory.getLogger(JBCryptService.class);
	
	/**
	 * Generate hashed password from plaintext password
	 * @param password
	 * @return hashed password string
	 */
	public String hashPassword(String password){
		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		//String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	/**
	 * Authenticate plaintext password with stored hashed password
	 * @param candidate
	 * @param hashed
	 * @return true if plaintext and hashed password 'match'
	 */
	public boolean checkpw(String candidate, String hashed){
		return BCrypt.checkpw(candidate, hashed);
	}
	
	public void hash(){
		String password ="foo";
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		logger.info("hashed: {}", hashed);
		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		//String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		String candidate ="foo";
		// Check that an unencrypted password matches one that has
		// previously been hashed
		if (BCrypt.checkpw(candidate, hashed)){
			logger.info("It matches");
		}
		else{
			logger.info("It does not match");
		}	
	}
}
