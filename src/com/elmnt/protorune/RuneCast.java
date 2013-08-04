package com.elmnt.protorune;

public interface RuneCast {
	
	public static final int STATE_UNCASTED = 0;
	public static final int STATE_CASTING = 1;
	public static final int STATE_CASTED = 2;

	public CastManager getParent();
	
	public RunePower getPower();

	public void activate();


}
