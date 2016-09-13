package com.aronajones.sentinel.discord;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.DiscordDisconnectedEvent;

public class DisconnectionListener implements IListener<DiscordDisconnectedEvent> {

	@Override
	public void handle(DiscordDisconnectedEvent event) {
		System.out.println("disconnected");
		StorageHandler.writeDataToDisk();
	}

}
