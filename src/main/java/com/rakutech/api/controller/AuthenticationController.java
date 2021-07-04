package com.rakutech.api.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rakutech.api.dto.Auth;
import com.rakutech.api.model.Administrator;
import com.rakutech.api.repository.AdministratorRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	@PostMapping("auth")
	public Auth log(@RequestParam("user") String username, 
					@RequestParam("password") String pwd) {
		
		Auth auth = new Auth();
		
		administratorRepository.findAll().forEach(e -> {
			if(e.getUsername().equals(username) && e.getPassword().equals(pwd)) {
				String token = getJWTToken(username);
				auth.setUser(username);
				auth.setPwd(pwd);
				auth.setToken(token);
			}
		});
		
		return auth;
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
