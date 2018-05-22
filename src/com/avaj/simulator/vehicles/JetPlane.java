package com.avaj.simulator.vehicles;


import com.avaj.simulator.WeatherTower;
import com.avaj.simulator.WriteFile;
import com.avaj.weather.Coordinates;

/**
 * Created by mabanciu on 5/17/18.
 */
public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public void updateConditions(){
		String weather = weatherTower.getWeather(coordinates);
		switch (weather){
			case "RAIN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): This water is wet.");
				break;
			case "FOG":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): Am I in the clouds right now?");
				break;
			case "SUN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				if (this.coordinates.getHeight() > 100)
					this.coordinates.setHeight(100);
				WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): It's time for the sunglasses!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 7);
				if (this.coordinates.getHeight() <= 0) {
					this.coordinates.setHeight(0);
					WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + ") landing.");
					WriteFile.getWriteFile().writetofile("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower at Longitude: " + this.coordinates.getLongitude() + ", Latitude: " + this.coordinates.getLatitude() + ", Height: 0.");
				} else {
					WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + "): Is that SANTA?");
				}
				break;
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		WriteFile.getWriteFile().writetofile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
		this.weatherTower.register(this);
	}
}
