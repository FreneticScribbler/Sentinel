package com.aronajones.sentinel.discord;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class StorageHandler {

	public static Map<Object, Object> points = new HashMap<Object, Object>();
	private static Properties properties = new Properties();

	public static void writeDataToDisk() {
		properties.putAll(points);
		try {
			properties.store(new FileOutputStream("data.properties"), null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void readDataFromDisk() {
		points = new HashMap<Object, Object>(properties);
	}
}
