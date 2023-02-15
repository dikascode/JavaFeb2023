package com.emmanuelu.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/greeting")
@RestController
public class ControllerTest {
	
	@RequestMapping("/morning")
	public String greetMorning() {
		return "Hello good morning";
	}
	
	@RequestMapping("/afternoon")
	public String greetAfternoon(@RequestParam(value="q", required = true) String name) {
		return "Hello good afternoon, " + name;
	}
	

	@RequestMapping(value="eveninig", method=RequestMethod.GET)
	public String greetEvening() {
		return "Hello good evening";
	}



}
