package com.rouf.employeeManagement.controller;

import com.rouf.employeeManagement.model.User;
import org.springframework.web.bind.annotation.*;


@RestController
@ResponseBody
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "this is home";
	}

	@GetMapping("/admin")
	public User admin(){
		User admin = new User();

		admin.setId("1");
		admin.setName("Rouf Syed");
		admin.setEmailId("rouf@duck.com");

		return admin;
	}

	@GetMapping("/{id}")
	public String pathVariable(@PathVariable String id) {
		return "The path variable given is " + id;
	}

	@GetMapping("/requestParam")
	public String requestParam(@RequestParam String name) {
		return "the request is " + name;
	}

	@GetMapping("/userData")
	public String getData(
			@RequestParam String name,
			@RequestParam(name = "email", required = false, defaultValue = "") String emailId
	) {
			return "the request is " + name + " and " + emailId;
	}

}
