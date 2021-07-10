package com.rakutech.api.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakutech.api.ImageResourceHttpRequestHandler;

@RestController
@RequestMapping("/images")
public class ImageController {
	@Resource
    private ImageResourceHttpRequestHandler imageResourceHttpRequestHandler;

    @GetMapping("/{image}")
    public void download(@PathVariable String image, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        File file = new File("src/main/resources/static/images/" + image);
        httpServletRequest.setAttribute(ImageResourceHttpRequestHandler.ATTRIBUTE_FILE, file);
        imageResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);
    }
}
