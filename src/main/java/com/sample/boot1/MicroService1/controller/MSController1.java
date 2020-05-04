package com.sample.boot1.MicroService1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MSController1 {
	@Autowired
	private RestTemplate restTemplate;
	@Value(value = "${server.app.url}")
	private String url;
	
	@RequestMapping(value="/")
	public String getDefaultMessage() {
		System.out.println("url ********"+url);
		return restTemplate.getForObject(url, String.class);
	}
	@RequestMapping(value="/{name}")
	public String getMessage(@PathVariable("name") String customerName) {
		System.out.println("url ********"+url);
		return restTemplate.getForObject(url+customerName, String.class);
	}
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
