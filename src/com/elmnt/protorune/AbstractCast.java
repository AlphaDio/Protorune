package com.elmnt.protorune;

public abstract class AbstractCast implements RuneCast {
	
	protected CastManager parent;
	protected RunePower castedPower;
	protected int state;
	protected RuneCharacter caster;
	protected RuneCharacter target;

}
