package me.lytra.controller;

import me.lytra.domain.client.Client;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.ClientService;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;
import me.lytra.service.facebook.LytraFacebookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/photos")
public class PhotosController {
	static Logger logger = LoggerFactory.getLogger(PhotosController.class);

	@Autowired
	private BlogService blogService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private GridFsService gridFsService;
	
	@Autowired
	private LytraFacebookService lytraFacebookService;
	
	@Autowired
	private ClientService clientService;

	@Autowired
	private MongoOperations mongoOperations;
    @RequestMapping(value="/{accessCode}")
	public @ResponseBody String handleTest(@PathVariable String accessCode) {
    	Client client = mongoOperations.findOne(new Query().addCriteria(Criteria.where("accessCode.code").is(accessCode)), Client.class);
    	if(client == null){
    		return "Not found";
    	}
    	return client.toString();
	}




}
