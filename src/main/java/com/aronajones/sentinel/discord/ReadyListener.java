package com.aronajones.sentinel.discord;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.Status;

public class ReadyListener implements IListener<ReadyEvent> {

	@Override
	public void handle(ReadyEvent event) {
		event.getClient().changeStatus(Status.game("Use $ for commands"));
	}

}
