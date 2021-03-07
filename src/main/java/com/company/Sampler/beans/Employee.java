package com.company.Sampler.beans;

public class Employee {
	private long id;
    private String name;
    private Integer grade;
    private Boolean address;
    private Actor actorDetails;
    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Boolean getAddress() {
		return address;
	}

	public void setAddress(Boolean address) {
		this.address = address;
	}

	public Actor getActorDetails() {
		return actorDetails;
	}

	public void setActorDetails(Actor actorDetails) {
		this.actorDetails = actorDetails;
	}
	
}
