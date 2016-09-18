package com.aronajones.sentinel.discord;

import com.aronajones.sentinel.utils.StorageHandler;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

public class DiscordSentinel {

	public static IDiscordClient INSTANCE;

	public static void start(String token) {
		StorageHandler.readDataFromDisk();
		login(token);
		registerListeners();
	}

	public static void login(String token) { // Returns an instance of the Discord client
		ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
		clientBuilder.withToken(token); // Adds the login info to the builder

		try {
			INSTANCE = clientBuilder.login();
		}
		catch(DiscordException e) {
			e.printStackTrace();
		}
	}

	public static void registerListeners() {
		EventDispatcher dispatcher = INSTANCE.getDispatcher();
		dispatcher.registerListener(new CommandListener());
		// dispatcher.registerListener(new ConnectionListener());
		dispatcher.registerListener(new DisconnectionListener());
	}
}
