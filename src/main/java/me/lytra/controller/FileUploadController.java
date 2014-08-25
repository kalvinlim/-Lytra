package me.lytra.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import me.lytra.domain.user.User;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private GridFsService gridFsService;
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
    public ModelAndView provideUploadInfo() {
		List<User> users = userService.findAll();
		ModelAndView mav = new ModelAndView("upload");
		mav.addObject("users", users);
        return mav;
    }
	
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, 
    			@RequestParam("file") MultipartFile file, @RequestParam("user") User user){
    	
        if (!file.isEmpty()) {
            try {
            	String extension = file.getOriginalFilename().split("\\.")[1];
            	logger.info("Filename: {}", file.getName());
            	logger.info("Filename: {}", extension);
            	
                byte[] bytes = file.getBytes();
                
                logger.info("User: {}", user);
                //gridFsService.saveOne(file, user, name);
                //BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "." + extension)));
                //stream.write(bytes);
                //stream.close();
                logger.info("You successfully uploaded " + name + " into " + name + "." + extension);
                return "You successfully uploaded " + name + " into " + name + "." + extension;
                
            } catch (Exception e) {
            	logger.warn("You failed to upload " + name + " => " + e.getMessage());
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
        	logger.warn("You failed to upload " + name + " because the file was empty.");
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}