package com.javabrains;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model , @RequestParam("name") String name, @RequestParam("surname") String surname) {

		log.debug("Updated - {} {} ", name, surname);
		model.addAttribute("name", name + " " + surname);
		
		return "welcome";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {

		// logic

		return "home";
	}

}
