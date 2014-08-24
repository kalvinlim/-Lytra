package me.lytra.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadConfig {
	
	private final String MAX_FILE_SIZE = "1024KB";
	private final String MAX_REQUEST_SIZE = "1024KB";
	
	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(MAX_FILE_SIZE);
        factory.setMaxRequestSize(MAX_REQUEST_SIZE);
        return factory.createMultipartConfig();
    }
}
