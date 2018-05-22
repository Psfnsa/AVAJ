package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;

/**
 * Created by mabanciu on 5/17/18.
 */
public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates){
		this.id = this.nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId(){
		return ++idCounter;
	}

	public int getHeight(){
		return coordinates.getHeight();
	}
}
