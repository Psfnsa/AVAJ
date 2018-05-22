package com.avaj.simulator;

import com.avaj.weather.Coordinates;
import com.avaj.weather.WeatherProvider;

/**
 * Created by mabanciu on 5/17/18.
 */
public class WeatherTower extends Tower{
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather(){
		conditionsChanged();
	}
}
