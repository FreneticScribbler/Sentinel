package com.aronajones.sentinel.commands;

import java.io.File;
import java.io.FileNotFoundException;

import com.aronajones.sentinel.utils.StorageHandler;

public class CommandQuote implements ICommand {

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
		try {
			return StorageHandler.choose(new File(parameters[0] + ".txt"));
		}
		catch(FileNotFoundException e) {
			return "Error: Quote file not found.";
		}
	}

}
