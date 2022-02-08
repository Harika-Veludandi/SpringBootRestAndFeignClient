package com.capgemini.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.eo.User;

@FeignClient(url="http://localhost:8080/user" ,value="feignClient")
public interface UserFeignClient {

	@GetMapping("/alluser")
	ResponseEntity<List<User>> getAllUsers();

}
