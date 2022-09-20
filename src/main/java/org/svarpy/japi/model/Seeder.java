package org.svarpy.japi.model;

public class Seeder {
	
	int id;
	String name;
	String team;
	int projects;
	
	public Seeder(int id, String name, String team, int projects) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.projects = projects;
	}

	public Seeder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
/* Getters and Setters */
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

	public int getProjects() {
		return projects;
	}

	public void setProjects(int projects) {
		this.projects = projects;
	}

	//toString() Method
	@Override
	public String toString() {
		return "Seeder [id=" + id + ", name=" + name + ", team=" + team + ", projects=" + projects + "]";
	}

}
