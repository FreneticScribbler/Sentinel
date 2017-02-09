package com.aronajones.sentinel.commands;

public class CommandEcho extends BaseCommand {
	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.SPECIAL;
	}

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		return null;
	}

}
