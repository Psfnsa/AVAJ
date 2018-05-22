package com.avaj.simulator;

import com.avaj.simulator.vehicles.Flyable;

import java.util.ArrayList;

/**
 * Created by mabanciu on 5/17/18.
 */
public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	private ArrayList<Flyable> landed = new ArrayList<Flyable>();

	public void register(Flyable flyable){
		if (observers.contains(flyable))
			return ;
		observers.add(flyable);
	}

	public void unregister(Flyable flyable){
		observers.remove(flyable);
	}

	protected void conditionsChanged(){
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
			if (observers.get(i).getHeight() <= 0) {
				this.unregister(observers.get(i--));
			}
		}
	}

}
