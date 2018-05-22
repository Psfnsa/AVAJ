package com.avaj.simulator.vehicles;

import com.avaj.simulator.WeatherTower;
import com.avaj.weather.Coordinates;

/**
 * Created by mabanciu on 5/17/18.
 */
public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
	public int getHeight();
}
