package me.lytra.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "upload";
    }
	
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
            	String extension = file.getOriginalFilename().split("\\.")[1];
            	logger.info("Filename: {}", file.getName());
            	logger.info("Filename: {}", extension);
            	
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "." + extension)));
                stream.write(bytes);
                stream.close();
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