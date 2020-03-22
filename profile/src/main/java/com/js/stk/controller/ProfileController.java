package com.js.stk.controller;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.js.stk.domain.entity.Profile;
import com.js.stk.domain.repository.ProfileRepository;



@Controller
public class ProfileController {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProfileRepository profileRepository;

	
	@GetMapping("/staticProfile")
	public String getStaticProfile() {
		
		return "index";
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model) {
		
		
		Optional<Profile> profile = profileRepository.findByName("김종성");
		
		model.addAttribute("profile", profile.get());
		
		return "profile";
	}
}
