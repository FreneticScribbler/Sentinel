package com.aronajones.sentinel.commands;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CommandSearch implements ICommand {

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
		String query = null;

		try {
			query = URLEncoder.encode(parameters[0], "UTF-8");
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(query != null) {
			return "http://api.wolframalpha.com/v1/simple?appid=Q7K29Y-9Y7YLGL96V&i=" + query;
		}

		return "Invalid";
	}

}
