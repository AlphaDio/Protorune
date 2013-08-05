package com.elmnt.protorune;

public interface CastRunner {

	boolean isAvailable();

	void slotPower(RuneCast cast);
	
	RuneCast getCast();

	void castFinished();

	void castStarted();
	
	CastManager getManager();

}
