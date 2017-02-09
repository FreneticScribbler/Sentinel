package com.aronajones.sentinel.discord;

import java.util.Arrays;

import com.aronajones.sentinel.Sentinel;
import com.aronajones.sentinel.commands.CommandRegistry;
import com.aronajones.sentinel.commands.EnumCommandType;
import com.aronajones.sentinel.commands.EnumPermissionsLevel;
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

		// TODO allow commands anywhere within text strings

		if(content.startsWith(Sentinel.COMMAND_CHARACTER.toString())) {
			String input = content.substring(1);
			String[] args = input.split(" ");
			String command = args[0];
			String[] parameters = Arrays.copyOfRange(args, 1, args.length);

			if(command == "quit") {
				try {
					event.getClient().logout();
				}
				catch(DiscordException e) {
					e.printStackTrace();
				}
			}

			if(CommandRegistry.getCommand(command) != null) {
				ICommand icommand = CommandRegistry.getCommand(command);
				// TODO There's gotta be a better way
				if(icommand.getRequiredPermissionLevel() == EnumPermissionsLevel.CREATOR) {
					System.out.println(user.getID());
					if(!user.getID().toString().equals("84299205929103360")) {
						permissionDenied(user, channel);
						return;
					}
				}
				// TODO
				// else if(icommand.getRequiredPermissionLevel() == EnumPermissionsLevel.ADMIN) {
				// if(user.getRolesForGuild(message.getGuild()).)
				// }

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
					else if(icommand.getCommandType() == EnumCommandType.SPECIAL) {
						// CommandEcho echoCommand = (CommandEcho) icommand;
						IChannel toSendIn = message.getGuild().getChannelsByName(parameters[0]).get(0);
						try {
							toSendIn.sendMessage(parameters[1], true);
						}
						catch(RateLimitException | DiscordException | MissingPermissionsException e) {
							e.printStackTrace();
						}
					}
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

	private void permissionDenied(IUser user, IChannel channel) {
		try {
			channel.sendMessage("Error: You do not have permission to use this command.");
		}
		catch(MissingPermissionsException | RateLimitException | DiscordException e) {
			e.printStackTrace();
		}
	}
}
