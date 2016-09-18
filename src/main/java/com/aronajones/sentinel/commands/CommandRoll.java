package com.aronajones.sentinel.commands;

import com.aronajones.sentinel.Sentinel;

public class CommandRoll extends BaseCommand {

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
		return Integer.toString(1 + Sentinel.RNG.nextInt(Integer.parseInt(parameters[0])));
	}

}
