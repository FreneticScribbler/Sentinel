package com.aronajones.sentinel.commands;

import com.aronajones.sentinel.utils.StorageHandler;

public class CommandSetPoints implements ICommand {

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.STRING;
	}

	@Override
	public int getNumberOfParameters() {
		return 2;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		try {
			Integer.parseInt(parameters[1]);
		}
		catch(Exception e) {
			return "Error: Value out of bounds";
		}

		StorageHandler.points.setProperty(parameters[0], parameters[1]);

		return "Set user " + parameters[0] + "'s points to " + parameters[1];

	}

	@Override
	public EnumPermissionsLevel getRequiredPermissionLevel() {
		return EnumPermissionsLevel.CREATOR;
	}

}
