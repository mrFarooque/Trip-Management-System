package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Admin;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}

	// to update admin by passing key
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin, @RequestParam(required = false) String key) {

		return adminService.updateAdmin(admin, key);
	}
}
