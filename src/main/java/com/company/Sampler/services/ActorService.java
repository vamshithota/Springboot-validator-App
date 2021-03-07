package com.company.Sampler.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.company.Sampler.beans.Actor;
import com.company.Sampler.exceptionhandlers.ActorNotFoundException;

@Service
public class ActorService {

	
	public Actor getActor(int id) throws ActorNotFoundException {
		Actor resultActor =null;
		ArrayList<Actor> actorsList = new ArrayList<>();
		actorsList.add(new Actor("Vijay",false,1));
		actorsList.add(new Actor("Venkat",false,2));
		actorsList.add(new Actor("Ajay",false,3));
		actorsList.add(new Actor("Murali",false,4));
		for(Actor actor: actorsList) {
			if(actor.getId()==id) {
				resultActor = actor;
			}
		}
		if(resultActor== null) {
			throw new ActorNotFoundException();
		}
		 return resultActor;
	}
	
}
