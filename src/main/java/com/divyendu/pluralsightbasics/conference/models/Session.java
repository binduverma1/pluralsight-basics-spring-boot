package com.divyendu.pluralsightbasics.conference.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
	
	@Id
	@Column(name = "session_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionID;
	@Column(name = "session_name")
	private String sessionName;
	@Column(name = "session_description")
	private String sessionDescription;
	@Column(name = "session_length")
	private int sessionLength;
	
	@ManyToMany
	@JoinTable(
			name="session_speakers",
			joinColumns = @JoinColumn(name = "session_id"),
			inverseJoinColumns = @JoinColumn(name="speaker_id"))
	private List<Speaker> speakers;
	
	public Session() {}

	public Long getSessionID() {
		return sessionID;
	}

	public void setSessionID(Long sessionID) {
		this.sessionID = sessionID;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionDescription() {
		return sessionDescription;
	}

	public void setSessionDescription(String sessionDescription) {
		this.sessionDescription = sessionDescription;
	}

	public int getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(int sessionLength) {
		this.sessionLength = sessionLength;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	

}
