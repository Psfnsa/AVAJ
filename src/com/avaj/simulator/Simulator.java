package com.avaj.simulator;

import com.avaj.simulator.vehicles.AircraftFactory;
import com.avaj.simulator.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mabanciu on 5/18/18.
 */
public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] arg) throws  InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line);
				if (simulations < 0 && line.split(" ").length == 1) {
					System.out.println("Invalid simulations count " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
					String[] splitLine = line.split(" ");
					if (splitLine.length != 5) {
						throw new IOException();
					}
					//Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
					Flyable flyable = AircraftFactory.newAircraft(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]));
					flyables.add(flyable);
				}
				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}
				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify simulation file");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			WriteFile.getWriteFile().close();
		}
	}
}
