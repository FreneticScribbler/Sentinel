package com.aronajones.sentinel;

import com.aronajones.sentinel.discord.DiscordSentinel;

public class Sentinel {

	public static final Character COMMAND_CHARACTER = '$';

	public static void main(String[] args) {
		DiscordSentinel.start(args[0]);
	}
}
