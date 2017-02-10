package com.aronajones.sentinel;

import java.util.Random;

import com.aronajones.sentinel.discord.DiscordSentinel;
import com.google.gson.Gson;

public class Sentinel {

	public static final String NAME = "Sentinel";
	public static final String VERSION = "1.0.2";

	public static final Character COMMAND_CHARACTER = '$';
	public static final Random RNG = new Random();
	public static final Gson GSON = new Gson();

	public static void main(String[] args) {
		DiscordSentinel.start(args[0]);
	}
}
