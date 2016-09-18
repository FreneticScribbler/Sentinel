package com.aronajones.sentinel.discord;

import java.util.Arrays;

import com.aronajones.sentinel.Sentinel;
import com.aronajones.sentinel.commands.CommandRegistry;
import com.aronajones.sentinel.commands.EnumCommandType;
import com.aronajones.sentinel.commands.ICommand;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class CommandListener implements IListener<MessageReceivedEvent> {
	// TODO Cleanup try/catch
	@Override
	public void handle(MessageReceivedEvent event) {
		IMessage message = event.getMessage();
		String content = message.getContent();
		IChannel channel = message.getChannel();
		IUser user = message.getAuthor();

		if(content.startsWith(Sentinel.COMMAND_CHARACTER.toString())) {
			String input = content.substring(1);
			String[] args = input.split(" ");
			String command = args[0];
			String[] parameters = Arrays.copyOfRange(args, 1, args.length);

			if(command == "quit") {
				try {
					event.getClient().logout();
				}
				catch(RateLimitException | DiscordException e) {
					e.printStackTrace();
				}
			}

			if(CommandRegistry.getCommand(command) != null) {
				ICommand icommand = CommandRegistry.getCommand(command);
				if(parameters.length == icommand.getNumberOfParameters()) {
					if(icommand.getCommandType() == EnumCommandType.STRING) {
						try {
							channel.sendMessage((String) icommand.getCommandResult(parameters));
						}
						catch(MissingPermissionsException | RateLimitException | DiscordException e) {
							e.printStackTrace();
						}
					}
					// TODO
					else
						commandUnrecognised(user, channel);
				}
				else
					incorrectParameters(user, channel);
			}
		}
	}

	// TODO

	private void commandUnrecognised(IUser user, IChannel channel) {
		try {
			channel.sendMessage("Error: Command not found.");
		}
		catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			e.printStackTrace();
		}
	}

	private void incorrectParameters(IUser user, IChannel channel) {
		try {
			channel.sendMessage("Error: Command parameters incorrect.");
		}
		catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			e.printStackTrace();
		}
	}
}
