package com.js.stk.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.stk.domain.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	Optional<Profile> findByName(String name);
	
}
