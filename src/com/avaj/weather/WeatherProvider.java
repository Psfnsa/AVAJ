package com.avaj.weather;

/**
 * Created by mabanciu on 5/17/18.
 */
public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates){
		int index = Math.abs(((coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4));
		return weather[index];
	}
}
