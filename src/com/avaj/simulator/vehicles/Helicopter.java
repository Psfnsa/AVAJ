package com.avaj.simulator.vehicles;

import com.avaj.simulator.vehicles.Aircraft;
import com.avaj.simulator.WeatherTower;
import com.avaj.simulator.WriteFile;
import com.avaj.weather.Coordinates;


/**
 * Created by mabanciu on 5/18/18.
 */
public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "RAIN":
				this.coordinates.setLongitude(coordinates.getLongitude() + 5);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): This RAIN thing, is wet.");
				break;
			case "FOG":
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): Engines at full power to disperse this Fog.");
				this.coordinates.setLongitude(coordinates.getLongitude() + 1);
				break;
			case "SUN":
				this.coordinates.setLongitude(coordinates.getLongitude() + 10);
				this.coordinates.setHeight(coordinates.getHeight() + 2);
				if (coordinates.getHeight() > 100)
					coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): The Sun is smiling!");
				break;
			case "SNOW":
				this.coordinates.setHeight(coordinates.getHeight() - 12);
				if (coordinates.getHeight() <= 0) {
					coordinates.setHeight(0);
					WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + ") landing.");
					WriteFile.getWriteFile().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower at Longitude: " + this.coordinates.getLongitude() + ", Latitude: " + this.coordinates.getLatitude() + ", Height: 0.");
				} else {
					WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): This weather is not a problem..2 seconds later... OH Fuck!!");
				}
				break;
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
		this.weatherTower.register(this);
	}
}
