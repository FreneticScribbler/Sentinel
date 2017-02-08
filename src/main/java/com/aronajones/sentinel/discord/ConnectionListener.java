package com.aronajones.sentinel.discord;

import com.aronajones.sentinel.Sentinel;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class ConnectionListener implements IListener<ReadyEvent> {

	@Override
	public void handle(ReadyEvent event) {
		System.out.println("Ready");
		for(IGuild guild : event.getClient().getGuilds()) {

			IChannel main = guild.getChannels().get(0); // TODO

			try {
				main.sendMessage("Connection initialised. Sentinel " + Sentinel.VERSION + " online.");
			}
			catch(MissingPermissionsException | RateLimitException | DiscordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
