package com.mcnc.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mcnc.controller.FileUploadController;

@Component
public class UploadFileConfiguration {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	
	@Autowired
	private PropertyConfiguration propertyConfiguration;
	/**
	 * Upload single file using Spring Controller
	 */
	public Map<String, Object> uploadFileHandler(MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty(propertyConfiguration.getImageDirectory());
				System.out.println("=========> root path: "+ rootPath);
				File dir = new File(rootPath + File.separator + "tmpFiles");
				//File dir = new File("tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				Map<String, Object> fileDetail =new HashMap<>();
				fileDetail.put("name", file.getName());
				fileDetail.put("originalName", file.getOriginalFilename());
				fileDetail.put("size", file.getSize());
				fileDetail.put("contentType", file.getContentType());
				fileDetail.put("path", dir.getPath());
				
				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				System.out.println("You successfully uploaded file="+ file.getOriginalFilename() +" to "+ dir.getPath());
				return fileDetail;
			} catch (Exception e) {
				System.out.println("You failed to upload " + " * => " + e.getMessage());
				e.printStackTrace();
				return null;
			}
		} else {
			System.out.println("You failed to upload " + " because the file was empty.");
			return null;
		}
	}
}
