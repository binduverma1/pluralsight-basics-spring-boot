package com.divyendu.pluralsightbasics.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divyendu.pluralsightbasics.conference.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
}
