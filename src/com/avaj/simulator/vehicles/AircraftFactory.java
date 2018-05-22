package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;

/**
 * Created by mabanciu on 5/17/18.
 */
public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
		if (height < 0 || longitude < 0 || latitude < 0) {
			throw new Exception("Coordinates can't be negative for aircraft " + name);
		}
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		String str = type.toLowerCase();
		if (str.equals("baloon")) {
			return new Baloon(name, coordinates);
		}
		else if (str.equals("helicopter")) {
			return new Helicopter(name, coordinates);
		}
		else if (str.equals("jetplane")) {
			return new JetPlane(name, coordinates);
		} else {
			throw new Exception("Unknown aircraft type: " + type);
		}
	}
}
