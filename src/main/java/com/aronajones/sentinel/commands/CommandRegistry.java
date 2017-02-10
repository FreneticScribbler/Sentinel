package com.aronajones.sentinel.commands;

import java.util.HashMap;

import com.aronajones.sentinel.Sentinel;

public class CommandRegistry {
	private static HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	static {
		CommandRegistry.registerCommand("help", new CommandHelp());
		CommandRegistry.registerCommand("quote", new CommandQuote());
		CommandRegistry.registerCommand("getpoints", new CommandGetPoints());
		CommandRegistry.registerCommand("setpoints", new CommandSetPoints());
		CommandRegistry.registerCommand("boop", new TextCommand("Beep"));
		CommandRegistry.registerCommand("lenny", new TextCommand("( ͡° ͜ʖ ͡°)"));
		CommandRegistry.registerCommand("disapprove", new TextCommand("ಠ_ಠ"));
		CommandRegistry.registerCommand("evillaugh", new TextCommand("MUAHAHAHAHAHAHAHAHAHAAAAAAAAAAAAAAAAAAAAAAAAA"));
		CommandRegistry.registerCommand("hug", new TextCommand("(>^_^)> <(^.^<)"));
		CommandRegistry.registerCommand("rule", new CommandRules());
		CommandRegistry.registerCommand("roll", new CommandRoll());
		CommandRegistry.registerCommand("flip", new CommandFlip());
		CommandRegistry.registerCommand("version",
				new TextCommand("Running " + Sentinel.NAME + " v" + Sentinel.VERSION));
		CommandRegistry.registerCommand("exterminatus", new TextCommand(
				"Some may question your right to destroy ten billion people. Those who understand know that you have no right to let them live — Exterminatus Extremis http://vignette1.wikia.nocookie.net/warhammer40k/images/e/e9/Exterminatus_Retribution.jpg/revision/latest?cb=20130419190839"));
		CommandRegistry.registerCommand("death",
				new TextCommand("http://static.tvtropes.org/pmwiki/pub/images/deathwithcat_8690.jpg"));
		CommandRegistry.registerCommand("xkcd", new CommandXKCD());
		CommandRegistry.registerCommand("site", new TextCommand("http://aronajones.com"));
		CommandRegistry.registerCommand("blog", new TextCommand("http://blog.aronajones.com"));
		CommandRegistry.registerCommand("mm",
				new TextCommand("http://sd.keepcalm-o-matic.co.uk/i/keep-chrome-and-witness-me.png"));
		CommandRegistry.registerCommand("search", new CommandSearch());
		CommandRegistry.registerCommand("echo", new CommandEcho());
		CommandRegistry.registerCommand("wanderlust", new CommandWanderlust());
	}

	public static void registerCommand(String name, ICommand command) {
		// TODO Duplicate checking
		commands.putIfAbsent(name, command);
	}

	public static ICommand getCommand(String name) {
		return commands.get(name);
	}

	public static HashMap<String, ICommand> getAllCommands() {
		return commands;
	}
}
