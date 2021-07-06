package com.rakutech.api.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	@RequestMapping(
			  value = "/get-image-with-media-type",
			  produces = MediaType.IMAGE_JPEG_VALUE
			)
			public @ResponseBody byte[] getImageWithMediaType() throws IOException {
			    InputStream in = getClass()
			      .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
			    return IOUtils.toByteArray(in);
			}
}
