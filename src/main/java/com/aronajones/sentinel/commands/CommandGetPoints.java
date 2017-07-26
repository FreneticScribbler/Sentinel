package com.aronajones.sentinel.commands;

import com.aronajones.sentinel.utils.StorageHandler;

public class CommandGetPoints implements ICommand {

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
		return "User has: " + Integer.parseInt(StorageHandler.points.getProperty(parameters[0])) + " points";
	}

}
