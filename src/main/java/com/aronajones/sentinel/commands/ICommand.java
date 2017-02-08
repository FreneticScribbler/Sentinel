package com.aronajones.sentinel.commands;

public interface ICommand {
	public EnumCommandType getCommandType();

	public int getNumberOfParameters();

	Object getCommandResult(String[] parameters);

	public EnumPermissionsLevel getRequiredPermissionLevel();
}
