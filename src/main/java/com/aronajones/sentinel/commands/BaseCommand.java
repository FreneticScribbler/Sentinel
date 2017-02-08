package com.aronajones.sentinel.commands;

public abstract class BaseCommand implements ICommand {
	@Override
	public EnumPermissionsLevel getRequiredPermissionLevel() {
		return EnumPermissionsLevel.USER;
	}
}
