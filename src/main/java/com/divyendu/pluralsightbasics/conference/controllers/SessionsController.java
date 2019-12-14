package com.divyendu.pluralsightbasics.conference.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divyendu.pluralsightbasics.conference.models.Session;
import com.divyendu.pluralsightbasics.conference.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions/")
public class SessionsController {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@GetMapping
	public List<Session> getSessions(){
		return sessionRepo.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Session getSessionByID(@PathVariable Long id) {
		return sessionRepo.getOne(id);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/create")
	public Session create(@RequestBody final Session request) {
		return sessionRepo.saveAndFlush(request);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionRepo.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session existingSession = sessionRepo.getOne(id);
		BeanUtils.copyProperties(session, existingSession, "sessionID");
		return sessionRepo.saveAndFlush(existingSession);
	}

}
