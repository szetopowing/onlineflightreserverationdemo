package com.clarence.fightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarence.fightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
