package com.aronajones.sentinel.commands;

import java.util.HashMap;

public class CommandRegistry {
	private static HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	static {
		CommandRegistry.registerCommand("quote", new CommandQuote());
		CommandRegistry.registerCommand("getpoints", new CommandGetPoints());
		CommandRegistry.registerCommand("setpoints", new CommandSetPoints());
		CommandRegistry.registerCommand("boop", new TextCommand("Beep"));
		CommandRegistry.registerCommand("lenny", new TextCommand("( ͡° ͜ʖ ͡°)"));
		CommandRegistry.registerCommand("disapprove", new TextCommand("ಠ_ಠ"));
		CommandRegistry.registerCommand("evillaugh", new TextCommand("MUAHAHAHAHAHAHAHAHAHAAAAAAAAAAAAAAAAAAAAAAAAA"));
		CommandRegistry.registerCommand("hug", new TextCommand("(>^_^)> <(^.^<)"));
		CommandRegistry.registerCommand("rule", new CommandRules());
	}

	public static void registerCommand(String name, ICommand command) {
		// TODO Duplicate checking
		commands.putIfAbsent(name, command);
	}

	public static ICommand getCommand(String name) {
		return commands.get(name);
	}
}
