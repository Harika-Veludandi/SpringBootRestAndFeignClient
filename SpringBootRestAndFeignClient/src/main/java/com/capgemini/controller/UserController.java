package com.capgemini.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.eo.User;
@RestController
@RequestMapping("/api")
public class UserController {
	
	    @Value("${springboot.provider.url}")
	    private String url;
		
		@Autowired
		RestTemplate restTemplate;
		
		@GetMapping("/alluserapi")
		public String getUsersList() {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<String> entity = new HttpEntity<String>(headers);
		      
		      return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		    
		   }
		
		@Autowired
		private UserFeignClient userFeignClient;
		
		@GetMapping("/allusersfeign")
		public ResponseEntity<List<User>> getAllUsers()
		{
			return userFeignClient.getAllUsers();
		}
}
