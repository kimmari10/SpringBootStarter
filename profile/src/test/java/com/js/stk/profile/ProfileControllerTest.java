package com.js.stk.profile;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileControllerTest {

	@Autowired
	ProfileRepository profileRepository;
	
	@Test
	public void di() throws SQLException {
		Profile profile = new Profile();
		
		profile.setName("js");
		
		Profile newProfile = profileRepository.save(profile);
		
		assertThat(newProfile).isNotNull();
		
		Optional<Profile> existingAccount = profileRepository.findByName(newProfile.getName());
		assertThat(existingAccount).isNotEmpty();
		
		Optional<Profile> nonExistingAccount = profileRepository.findByName("kjs");
		assertThat(nonExistingAccount).isEmpty();
	}

}
