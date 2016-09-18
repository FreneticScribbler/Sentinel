package com.aronajones.sentinel.discord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.aronajones.sentinel.Sentinel;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class CommandListener implements IListener<MessageReceivedEvent> {

	public static Map<String, String> textCommandsList = new HashMap<String, String>();

	public static void initTextCommands() {
		textCommandsList.put("boop", "Beep");
		textCommandsList.put("lenny", "( ͡° ͜ʖ ͡°)");
		textCommandsList.put("disapprove", "ಠ_ಠ");
		textCommandsList.put("evillaugh", "MUAHAHAHAHAHAHAHAHAHAAAAAAAAAAAAAAAAAAAAAAAAA");
		textCommandsList.put("hug", "(>^_^)> <(^.^<)");
	}

	// TODO Cleanup try/catch
	@Override
	public void handle(MessageReceivedEvent event) {
		IMessage message = event.getMessage();
		String content = message.getContent();
		IChannel channel = message.getChannel();
		IUser user = message.getAuthor();

		if(content.startsWith(Sentinel.COMMAND_CHARACTER.toString())) {
			String command = content.substring(1);
			String[] args = command.split(" ");
			if(args.length == 1) {
				if(textCommandsList.get(args[0]) != null) {
					try {
						channel.sendMessage(textCommandsList.get(args[0]));
					}
					catch(MissingPermissionsException | RateLimitException | DiscordException e) {
						e.printStackTrace();
					}
				}
				else if(args[0].equalsIgnoreCase("quit")) {
					try {
						event.getClient().logout();
					}
					catch(RateLimitException | DiscordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					commandUnrecognised(user, channel);
			}
			else if(args.length == 2) {
				// TODO User validation
				if(args[0].equalsIgnoreCase("getpoints")) {
					String username = args[1];
					int points = Integer.parseInt(StorageHandler.points.getProperty(username));

					try {
						channel.sendMessage("User has: " + points + " points");
					}
					catch(MissingPermissionsException | RateLimitException | DiscordException e) {
						e.printStackTrace();
					}
				}
				else if(args[0].equalsIgnoreCase("quote")) {
					try {
						channel.sendMessage(StorageHandler.choose(new File(args[1] + ".txt")));
					}
					catch(MissingPermissionsException | RateLimitException | DiscordException e) {
						e.printStackTrace();
					}
					catch(FileNotFoundException e) {
						try {
							channel.sendMessage("Error: Quote file not found.");
						}
						catch(MissingPermissionsException | RateLimitException | DiscordException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
				}
				else
					commandUnrecognised(user, channel);
			}
			else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("setpoints")) {
					StorageHandler.points.setProperty(args[1], args[2]);
				}
				else
					commandUnrecognised(user, channel);
			}

		}
	}

	private void commandUnrecognised(IUser user, IChannel channel) {
		try {
			channel.sendMessage("Error: Command not found.");
		}
		catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			e.printStackTrace();
		}
	}
}
