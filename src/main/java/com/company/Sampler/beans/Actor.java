package com.company.Sampler.beans;

public class Actor {

	private String actorName;
	private boolean star;
	private int id;
	
	public Actor(String actorName,boolean star, int id) {
		
		this.actorName = actorName;
		this.star=star;
		this.id = id;
		
	}
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public boolean isStar() {
		return star;
	}
	public void setStar(boolean star) {
		this.star = star;
	}
	
	
}

