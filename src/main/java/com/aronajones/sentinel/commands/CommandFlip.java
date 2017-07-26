package com.aronajones.sentinel.commands;

import com.aronajones.sentinel.Sentinel;

public class CommandFlip implements ICommand {

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
		if(Sentinel.RNG.nextBoolean())
			return "Heads";
		else
			return "Tails";
	}

}
