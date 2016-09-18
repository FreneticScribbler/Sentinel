package com.aronajones.sentinel.commands;

import java.util.ArrayList;

public class CommandHelp extends BaseCommand {

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.STRING;
	}

	@Override
	public int getNumberOfParameters() {
		// TODO Optional param for help on certain command
		return 0;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		// TODO
		ArrayList<String> result = new ArrayList<String>();
		for(String key : CommandRegistry.getAllCommands().keySet()) {
			result.add(key);
			result.add(", ");
		}
		return result;
	}

}
