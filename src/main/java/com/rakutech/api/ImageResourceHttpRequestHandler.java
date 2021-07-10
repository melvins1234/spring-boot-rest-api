package com.rakutech.api;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Component
public class ImageResourceHttpRequestHandler extends ResourceHttpRequestHandler {
	public static final String ATTRIBUTE_FILE = "DOWNLOADING_FILE";

	@Override
	protected Resource getResource(HttpServletRequest request) throws IOException {
		File file = (File) request.getAttribute(ATTRIBUTE_FILE);
		return new FileSystemResource(file);
	}
	
}	
