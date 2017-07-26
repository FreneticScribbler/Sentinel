package com.aronajones.sentinel.commands;

public interface ICommand {
	public EnumCommandType getCommandType();

	public int getNumberOfParameters();

	default Object getCommandResult(String[] parameters) {
		return null;
	}

	default public EnumPermissionsLevel getRequiredPermissionLevel() {
		return EnumPermissionsLevel.USER;
	}
}
