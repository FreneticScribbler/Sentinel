package com.aronajones.sentinel.commands;

public class CommandTodo implements ICommand {

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.SPECIAL;
	}

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public EnumPermissionsLevel getRequiredPermissionLevel() {
		return EnumPermissionsLevel.ADMIN;
	}
}
