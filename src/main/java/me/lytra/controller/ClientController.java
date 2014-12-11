package me.lytra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lytra.domain.client.Client;
import me.lytra.persistence.service.BlogService;
import me.lytra.persistence.service.ClientService;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;
import me.lytra.service.facebook.LytraFacebookService;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	static Logger logger = LoggerFactory.getLogger(ClientController.class);

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



}
