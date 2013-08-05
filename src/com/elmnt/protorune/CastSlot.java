package com.elmnt.protorune;

import android.os.AsyncTask;

import com.elmnt.protorune.tasks.CastPowerAsyncTask;

public class CastSlot implements CastRunner {
	
	private RuneCast cast;
	private CastPowerAsyncTask task;
	private CastManager manager;
	
	public CastSlot(CastManager manager) {
		this.manager = manager;
	}

	public boolean isAvailable() {
		return cast == null;
	}

	public void slotPower(RuneCast cast) {
		this.cast = cast;
		
		// Start the cast
		this.task = new CastPowerAsyncTask(cast);
		this.task.execute();
	}

	public RuneCast getCast() {
		return this.cast;
	}

	@Override
	// Empty the slot of all presence of the cast
	public void castFinished() {
		// TODO Auto-generated method stub
		this.cast = null;
	}

	@Override
	// Might want to tell the Cast Manager that the cast is starting
	public void castStarted() {
		
	}

	@Override
	public CastManager getManager() {
		return this.manager; 
	}

}
