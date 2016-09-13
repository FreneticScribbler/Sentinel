package com.aronajones.sentinel.discord;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.GuildCreateEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class ConnectionListener implements IListener<GuildCreateEvent> {

	@Override
	public void handle(GuildCreateEvent event) {
		IGuild guild = event.getGuild();
		IChannel main = guild.getChannels().get(0); // TODO

		try {
			main.sendMessage("Connection initialised. Sentinel online.");
		}
		catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
