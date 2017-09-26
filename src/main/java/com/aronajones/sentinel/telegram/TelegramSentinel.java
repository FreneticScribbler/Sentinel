package com.aronajones.sentinel.telegram;

import java.util.Arrays;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.aronajones.sentinel.Sentinel;
import com.aronajones.sentinel.commands.CommandRegistry;
import com.aronajones.sentinel.commands.EnumCommandType;
import com.aronajones.sentinel.commands.ICommand;

public class TelegramSentinel extends TelegramLongPollingBot {

	private String apiToken;

	public TelegramSentinel(String apiToken) {
		this.apiToken = apiToken;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage()) {
			Message message = update.getMessage();
			String text = message.getText();
			User user = message.getFrom();

			if(message.isCommand()) { // Prefer platform spec to consistency
				String input = text.substring(1);
				String[] args = input.split(" ");
				String command = args[0];
				String[] parameters = Arrays.copyOfRange(args, 1, args.length);

				if(CommandRegistry.getCommand(command) != null) {
					ICommand icommand = CommandRegistry.getCommand(command);

					int userPowerLevel = 0;
					// if(user.getId()) {
					// userPowerLevel = EnumPermissionsLevel.CREATOR.getPower();
					// }

					if(userPowerLevel >= icommand.getRequiredPermissionLevel().getPower()) {
						if(parameters.length == icommand.getNumberOfParameters()) {
							if(icommand.getCommandType() == EnumCommandType.STRING) {

								try {
									this.sendApiMethod(new SendMessage(message.getChatId(),
											(String) icommand.getCommandResult(parameters)));
								}
								catch(TelegramApiException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String getBotUsername() {
		return Sentinel.NAME;
	}

	@Override
	public String getBotToken() {
		return apiToken;
	}

}
