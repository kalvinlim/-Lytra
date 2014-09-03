package me.lytra.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lytra.domain.user.User;
import me.lytra.persistence.service.GridFsService;
import me.lytra.persistence.service.UserService;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.gridfs.GridFSDBFile;

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
		mav.addObject("user", new User());
        return mav;
    }
	
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, 
    			@RequestParam("file") MultipartFile file, @ModelAttribute User user){
    	//logger.info("User: {}", user);
        if (!file.isEmpty()) {
            try {
            	String extension = file.getOriginalFilename().split("\\.")[1];
            	//logger.info("Filename: {}", file.getName());
            	//logger.info("Filename: {}", extension);
            	
                byte[] bytes = file.getBytes();
                
              
                gridFsService.saveOne(file, user, name);
                //BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "." + extension)));
                //stream.write(bytes);
                // stream.close();
                logger.info("You successfully uploaded: {} as {}.{}, using userId: {}", name, name, extension, user.getId());
                //logger.info("You successfully uploaded " + name + " into " + name + "." + extension);
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
	@RequestMapping(value="/foo/{userId}")
	public @ResponseBody void getPhoto2(HttpServletRequest request, HttpServletResponse response, @PathVariable String userId){
		List<GridFSDBFile> result = gridFsService.getGridFSDBFilesByUserId(userId);
		
		logger.info("Retrieving photos, results: {}", result.size());
		
		for(GridFSDBFile file : result){
			try {
				response.getOutputStream().write(IOUtils.toByteArray(file.getInputStream()));
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping(value="/photo/{photoId}")
	public @ResponseBody void getPhotoByPhotoId(HttpServletRequest request, HttpServletResponse response, @PathVariable String photoId){
		GridFSDBFile file = gridFsService.getGridFSDBFileByPhotoId(photoId);
		
		try {
			response.getOutputStream().write(IOUtils.toByteArray(file.getInputStream()));
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/user/{userid}")
	public @ResponseBody void getPhotoIdsByUserId(HttpServletRequest request, HttpServletResponse response, @PathVariable String photoId){
		GridFSDBFile file = gridFsService.getGridFSDBFileByPhotoId(photoId);
		
		try {
			response.getOutputStream().write(IOUtils.toByteArray(file.getInputStream()));
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}