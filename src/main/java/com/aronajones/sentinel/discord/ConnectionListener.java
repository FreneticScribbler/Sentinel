package com.aronajones.sentinel.discord;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

public class ConnectionListener implements IListener<ReadyEvent> {

	@Override
	public void handle(ReadyEvent event) {
		System.out.println("Ready");
		for(IGuild guild : event.getClient().getGuilds()) {

			IChannel main = guild.getChannels().get(0); // TODO

			// try {

			// FIXME main.sendMessage("Connection initialised. Sentinel " + Sentinel.VERSION + " online.");
			// }
			// catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

}
