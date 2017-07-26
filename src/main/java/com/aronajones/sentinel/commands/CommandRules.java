package com.aronajones.sentinel.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommandRules implements ICommand {

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
		// TODO Bounds
		try {
			return Files.readAllLines(Paths.get("rules.txt")).get(Integer.parseInt(parameters[0]));
		}
		catch(NumberFormatException | IOException e) {
			e.printStackTrace();
			return "Error: file not found";
		}
	}

	@Override
	public EnumPermissionsLevel getRequiredPermissionLevel() {
		return EnumPermissionsLevel.CREATOR;
	}

}
