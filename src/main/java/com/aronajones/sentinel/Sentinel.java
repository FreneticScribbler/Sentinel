package com.aronajones.sentinel;

import java.util.Random;

import com.aronajones.sentinel.discord.DiscordSentinel;

public class Sentinel {

	public static final String NAME = "Sentinel";
	public static final String VERSION = "1.0.0";

	public static final Character COMMAND_CHARACTER = '$';
	public static final Random RNG = new Random();

	public static void main(String[] args) {
		DiscordSentinel.start(args[0]);
	}
}
