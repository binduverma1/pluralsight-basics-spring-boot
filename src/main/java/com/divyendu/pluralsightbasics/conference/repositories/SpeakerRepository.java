package com.divyendu.pluralsightbasics.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divyendu.pluralsightbasics.conference.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
