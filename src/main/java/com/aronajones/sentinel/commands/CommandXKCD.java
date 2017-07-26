package com.aronajones.sentinel.commands;

public class CommandXKCD implements ICommand {

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
		// TODO Sanitisation.
		return "http://xkcd.com/" + parameters[0];
	}

}
