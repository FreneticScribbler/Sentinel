package com.aronajones.sentinel.commands;

public class CommandQuote extends BaseCommand {

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.STRING;
	}

	@Override
	public int getNumberOfParameters() {
		return 1;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		String type = parameters[1];

		return null;
	}

}
