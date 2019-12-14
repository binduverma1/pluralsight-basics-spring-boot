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

import com.divyendu.pluralsightbasics.conference.models.Speaker;
import com.divyendu.pluralsightbasics.conference.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers/")
public class SpeakerController {

	@Autowired
	private SpeakerRepository speakerRepo;
	
	@GetMapping
	public List<Speaker> getSpeakers() {
		return speakerRepo.findAll();
	}
	
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker getSpeakerByID(@PathVariable Long id) {
		return speakerRepo.getOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/create")
	public Speaker create(Speaker request) {
		return speakerRepo.saveAndFlush(request);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteByID(@PathVariable Long id) {
		speakerRepo.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existingSpeaker = speakerRepo.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speakerID");
		return speakerRepo.saveAndFlush(existingSpeaker);
	}
	
	
}
