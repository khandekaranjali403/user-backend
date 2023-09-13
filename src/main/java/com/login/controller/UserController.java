package com.login.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.login.entity.User;
import com.login.repositroy.UserRepository;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserRepository userrepo;

	@PostMapping("/login")
	ResponseEntity<?> loginUser(@RequestBody User userdata) {
		System.out.println(userdata);
		User user = userrepo.findByUsername(userdata.getUsername());
		if (user.getPassword().equals(userdata.getPassword())) 
		{
			
			return ResponseEntity.ok(user);
		}
			return (ResponseEntity<?>)ResponseEntity.internalServerError();
	}
}
