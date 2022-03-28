package com.clarence.fightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarence.fightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
