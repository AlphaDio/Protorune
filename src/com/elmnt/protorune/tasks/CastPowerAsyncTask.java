package com.elmnt.protorune.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.elmnt.protorune.RuneCast;
import com.elmnt.protorune.RuneCharacter;
import com.elmnt.protorune.RunePower;

public class CastPowerAsyncTask extends AsyncTask<Void, Void, Object> {

	private RuneCast cast;
	private RunePower power;
	private RuneCharacter caster_character;
	private RuneCharacter target_character;

	public CastPowerAsyncTask(RuneCast normalCast, RunePower power, RuneCharacter player_character,
			RuneCharacter enemy_character) {
		this.cast = normalCast;
		this.caster_character = player_character;
		this.target_character = enemy_character;
		this.power = power;
	}

	@Override
	protected Object doInBackground(Void... arg0) {
		int timer = 0;
		int overall = power.getCast_time();
		
		Log.v("PROTO", "CASTING!");
		
		while (overall > 0) {
			timer++;
			
			if (timer > 100) {
				overall = overall - 100;
				timer = 0;
				Log.v("PROTO", "Overall Reduced!");
			}
			
		}
		
		if (this.caster_character != null && this.target_character != null) {
			this.power.execute(caster_character.getCurrent_situation(), caster_character, target_character);
		} else {
			Log.e("PROTO", "Could not cast as player or enemy were absent!");
			if (this.caster_character == null) {
				Log.e("PROTO", "Player Character is null!");
			} else {
				Log.e("PROTO", "Enemy Character is null!");
			}
			
		}
		
		Log.v("PROTO", "CASTED!");
		
		return null;
	}

}
