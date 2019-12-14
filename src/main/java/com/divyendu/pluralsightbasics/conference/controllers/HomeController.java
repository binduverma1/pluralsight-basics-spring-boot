package com.divyendu.pluralsightbasics.conference.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${app.version}")
	private String appVersion; 
	
	@GetMapping
	@RequestMapping("/version")
	public Map<String, String> getVersion() {
		Map<String, String> versionInfo = new HashMap();
		versionInfo.put("app-version", appVersion);
		return versionInfo;
	}

}
