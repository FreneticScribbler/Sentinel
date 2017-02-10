package com.aronajones.sentinel.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.aronajones.sentinel.Sentinel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CommandWanderlust extends BaseCommand {

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.STRING;
	}

	@Override
	public int getNumberOfParameters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		JsonElement el = null;
		try {
			URL url = new URL("https://www.reddit.com/r/EarthPorn/new/.json?limit=1");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			JsonObject json = Sentinel.GSON.fromJson(in, JsonObject.class);
			// int post = Sentinel.RNG.nextInt(9);
			System.out.println(json.toString());
			el = json.get("url");
			in.close();
		}
		catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "IO Error";
		}

		return el.getAsString();
	}

}
