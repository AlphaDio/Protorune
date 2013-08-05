package com.elmnt.protorune.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.elmnt.protorune.CastRunner;
import com.elmnt.protorune.RuneCast;

public class CastPowerAsyncTask extends AsyncTask<Void, Void, Object> {

	private RuneCast cast;

	public CastPowerAsyncTask(RuneCast cast) {
		this.cast = cast;
	}

	@Override
	protected Object doInBackground(Void... arg0) {
		int timer = 0;
		int overall = this.cast.getPower().getCast_time();
		
		this.cast.getRunner().castStarted();
		
		Log.v("PROTO", "CASTING!");
		
		while (overall > 0) {
			timer++;
			
			if (timer > 100) {
				overall = overall - 100;
				timer = 0;
				Log.v("PROTO", "Overall Reduced!");
			}
			
		}
		
		if (this.cast.getCaster() != null && this.cast.getTarget() != null) {
			this.cast.getPower().execute(this.cast.getCaster().getCurrent_situation(), this.cast.getCaster(), this.cast.getTarget());
		} else {
			Log.e("PROTO", "Could not cast as player or enemy were absent!");
			if (this.cast.getCaster() == null) {
				Log.e("PROTO", "Caster Character is null!");
			} else {
				Log.e("PROTO", "Target Character is null!");
			}
			
		}
		
		this.cast.getRunner().castFinished();
		
		Log.v("PROTO", "CASTED!");
		
		return null;
	}

}
