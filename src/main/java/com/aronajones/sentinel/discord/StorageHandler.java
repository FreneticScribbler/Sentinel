package com.aronajones.sentinel.discord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class StorageHandler {

	static Properties points = new Properties();

	public static void writeDataToDisk() {
		System.out.println(points.toString());
		try {
			points.storeToXML(new FileOutputStream("data.xml"), null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void readDataFromDisk() {
		System.out.println("attempting read");
		try {
			points.loadFromXML(new FileInputStream("data.xml"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static String choose(File f) throws FileNotFoundException {
		String result = null;
		Random rand = new Random();
		int n = 0;
		for(Scanner sc = new Scanner(f); sc.hasNext();) {
			++n;
			String line = sc.nextLine();
			if(rand.nextInt(n) == 0)
				result = line;
		}

		return result;
	}
}
