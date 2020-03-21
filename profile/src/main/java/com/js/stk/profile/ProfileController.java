package com.js.stk.profile;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



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
		
		
		Optional<Profile> profile = profileRepository.findByName("js");
		
		model.addAttribute("profile", profile.get());
		
		return "profile";
	}
}
