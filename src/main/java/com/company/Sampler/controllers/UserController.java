package com.company.Sampler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.Sampler.beans.Actor;
import com.company.Sampler.exceptionhandlers.ActorNotFoundException;
import com.company.Sampler.services.ActorService;

@RestController
public class UserController {
	
	@Autowired
	ActorService actorService;
	
	@GetMapping("/hello")
	public String tryData() {
		return "try";
	}
	@GetMapping("/actor/{id}")
	public ResponseEntity<Actor> getActorDetails(@PathVariable int id) {
		Actor actor=null;
	try {
		actor = actorService.getActor(id);
	}catch(ActorNotFoundException ex) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Actor not found with id " + id ,ex);
		
	}
		return new ResponseEntity<>(actor,HttpStatus.OK);
	}
}
