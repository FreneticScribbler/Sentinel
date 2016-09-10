package com.aronajones.sentinel.discord;

import java.util.HashMap;
import java.util.Map;

import com.aronajones.sentinel.Sentinel;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class CommandListener implements IListener<MessageReceivedEvent> {

	public static Map<String, String> textCommandsList = new HashMap<String, String>();

	public static void initTextCommands() {
		textCommandsList.put("boop", "Beep");
	}

	@Override
	public void handle(MessageReceivedEvent event) {
		IMessage message = event.getMessage();
		String content = message.getContent();
		IChannel channel = message.getChannel();

		if(content.startsWith(Sentinel.COMMAND_CHARACTER.toString())) {
			String command = content.substring(1);
			String[] args = command.split(" ");
			if(args.length == 1) {
				if(textCommandsList.get(args[0]) != null)
					try {
						channel.sendMessage(textCommandsList.get(args[0]));
					}
					catch(MissingPermissionsException | RateLimitException | DiscordException e) {
						e.printStackTrace();
					}
			}
		}
	}

}
