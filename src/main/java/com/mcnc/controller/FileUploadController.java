package com.mcnc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mcnc.service.PropertyConfiguration;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);
	
	@Autowired
	private PropertyConfiguration propertyConfiguration;
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				//String rootPath = System.getProperty("catalina.home");
				String rootPath = System.getProperty(propertyConfiguration.getImageDirectory());
				System.out.println("=========> root path: "+ rootPath);
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				System.out.println("You successfully uploaded file="+ file.getOriginalFilename() +" to "+ dir.getPath());
				return "You successfully uploaded file="+ file.getOriginalFilename() +" to "+ dir.getPath();
			} catch (Exception e) {
				System.out.println("You failed to upload " + " => " + e.getMessage());
				return "You failed to upload" + " => " + e.getMessage();
			}
		} else {
			System.out.println("You failed to upload " + " because the file was empty.");
			return "You failed to upload" + " because the file was empty.";
		}
	}
}
