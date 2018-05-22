package com.avaj.simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mabanciu on 5/18/18.
 */
public class WriteFile {
	private static WriteFile writeFile = null;
	private static BufferedWriter bw = null;
	private static File file = null;
	private static FileWriter fw = null;

	private  WriteFile() {}

	public static WriteFile getWriteFile() {
		if (writeFile == null) {
			try {
				writeFile = new WriteFile();
				file = new File("sim.txt");
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
			} catch (IOException ioe) {}
		}
		return writeFile;
	}

	public void writetofile(String str) {
		try {
			bw.write(str);
			bw.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void close(){
		try {
			if (bw != null)
				bw.close();
		} catch (Exception ex) {
			System.out.println("Error in closing BufferedWriter" + ex);
		}
	}
}
