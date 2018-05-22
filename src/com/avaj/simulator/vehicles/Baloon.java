package com.avaj.simulator.vehicles;

import com.avaj.simulator.WeatherTower;
import com.avaj.simulator.WriteFile;
import com.avaj.weather.Coordinates;

/**
 * Created by mabanciu on 5/18/18.
 */
public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "RAIN":
				this.coordinates.setHeight(coordinates.getHeight() - 5);
				if (coordinates.getHeight() <= 0) {
					coordinates.setHeight(0);
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + ") landing.");
					WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower at Longitude: " + this.coordinates.getLongitude() + ", Latitude: " + this.coordinates.getLatitude() + ", Height: 0.");
				} else {
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): This rain is getting my Baloon wet.");
				}
				break;
			case "FOG":
				this.coordinates.setHeight(coordinates.getHeight() - 3);
				if (coordinates.getHeight() <= 0) {
					coordinates.setHeight(0);
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + ") landing.");
					WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower at Longitude: " + this.coordinates.getLongitude() + ", Latitude: " + this.coordinates.getLatitude() + ", Height: 0.");
				} else {
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Turn on the lights boys!!");
				}
				break;
			case "SUN":
				this.coordinates.setLongitude(coordinates.getLongitude() + 2);
				this.coordinates.setHeight(coordinates.getHeight() + 4);
				if (coordinates.getHeight() > 100) {
					coordinates.setHeight(100);
				} else {
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Now I can dry my clothes!");
				}
				break;
			case "SNOW":
				this.coordinates.setHeight(coordinates.getHeight() - 15);
				if (coordinates.getHeight() <= 0) {
					coordinates.setHeight(0);
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + ") landing.");
					WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower at Longitude: " + this.coordinates.getLongitude() + ", Latitude: " + this.coordinates.getLatitude() + ", Height: 0.");
				} else {
					WriteFile.getWriteFile().writetofile("Baloon#" + this.name + "(" + this.id + "): Does that plane think we are Santa? That's stupid.");
				}
				break;
		}

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
		this.weatherTower.register(this);
	}
}
