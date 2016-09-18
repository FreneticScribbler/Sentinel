package com.aronajones.sentinel.discord;

import com.aronajones.sentinel.utils.StorageHandler;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.DiscordDisconnectedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class DisconnectionListener implements IListener<DiscordDisconnectedEvent> {

	@Override
	public void handle(DiscordDisconnectedEvent event) {
		for(IGuild guild : event.getClient().getGuilds()) {

			IChannel main = guild.getChannels().get(0); // TODO

			try {
				main.sendMessage("Sentinel deactivating...");
			}
			catch(MissingPermissionsException | RateLimitException | DiscordException e) {
				e.printStackTrace();
			}
		}

		StorageHandler.writeDataToDisk();
	}

}
