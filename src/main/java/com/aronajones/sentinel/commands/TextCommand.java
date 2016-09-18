package com.aronajones.sentinel.commands;

public class TextCommand extends BaseCommand {

	String result;

	public TextCommand(String result) {
		super();
		this.result = result;
	}

	@Override
	public EnumCommandType getCommandType() {
		return EnumCommandType.STRING;
	}

	@Override
	public int getNumberOfParameters() {
		return 0;
	}

	@Override
	public Object getCommandResult(String[] parameters) {
		return result;
	}

}
