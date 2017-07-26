package com.aronajones.sentinel.commands;

public class CommandEcho implements ICommand {
	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.SPECIAL;
	}

	@Override
	public int getNumberOfParameters() {
		return 2;
	}
}
