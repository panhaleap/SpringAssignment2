package com.mcnc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfiguration {
	
	@Value( "${img.directory}" )
	private String imageDirectory;

	public String getImageDirectory() {
		return imageDirectory;
	}

}
