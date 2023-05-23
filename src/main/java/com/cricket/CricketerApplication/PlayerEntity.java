package com.cricket.CricketerApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",updatable=false,nullable=false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="team")
	private String team;
	
	@Column(name="batting style")
	private String bstyle;
	
	@Column(name="no.of Matches")
	private int matches;
	
	@Column(name="no.of Runs")
	private int runs;
	
	public PlayerEntity() {
		// TODO Auto-generated constructor stub
	}

	public PlayerEntity(int id, String name, String team, String bstyle, int matches, int runs) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.bstyle = bstyle;
		this.matches = matches;
		this.runs = runs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getBstyle() {
		return bstyle;
	}

	public void setBstyle(String bstyle) {
		this.bstyle = bstyle;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	
	
}
