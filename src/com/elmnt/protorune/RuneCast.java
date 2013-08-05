package com.elmnt.protorune;

public interface RuneCast {
	
	public static final int STATE_UNCASTED = 0;
	public static final int STATE_CASTING = 1;
	public static final int STATE_CASTED = 2;

	// Return the object charged with running and watching this cast
	public CastRunner getRunner();
	
	public RunePower getPower();

	public void activate();

	public RuneCharacter getCaster();
	
	public RuneCharacter getTarget();

}
