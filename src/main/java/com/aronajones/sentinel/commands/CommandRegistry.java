package com.aronajones.sentinel.commands;

import java.util.HashMap;

public class CommandRegistry {
	private static HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	public void registerCommand(String name, ICommand command) {
		// TODO Duplicate checking
		commands.putIfAbsent(name, command);
	}

	public ICommand getCommand(String name) {
		return commands.get(name);
	}
}
