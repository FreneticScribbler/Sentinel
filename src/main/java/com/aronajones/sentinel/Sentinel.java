package com.aronajones.sentinel;

import java.util.Random;

import com.aronajones.sentinel.discord.DiscordSentinel;
import com.google.gson.Gson;
import com.julienvey.trello.Trello;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

public class Sentinel {

	public static final String NAME = "Sentinel";
	public static final String VERSION = "1.0.2";

	public static final Character COMMAND_CHARACTER = '$';
	public static final Random RNG = new Random();
	public static final Gson GSON = new Gson();

	public static Trello trelloAPI;

	public static void main(String[] args) {
		DiscordSentinel.start(args[0]);
		trelloAPI = new TrelloImpl(args[1], args[2], new ApacheHttpClient());
	}
}
