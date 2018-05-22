package com.avaj.weather;


/**
 * Created by mabanciu on 5/17/18.
 */
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		setLongitude(longitude);
		setLatitude(latitude);
		setHeight(height);
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public void setHeight(int height) {
		this.height = height;
		if (this.height > 100) {
			this.height = 100;
		}
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}
}