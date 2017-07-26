package com.aronajones.sentinel.commands;

public enum EnumPermissionsLevel {
	CREATOR(3), ADMIN(2), MOD(1), USER(0);
	int power;

	EnumPermissionsLevel(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}
}
