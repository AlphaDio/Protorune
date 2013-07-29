package com.elmnt.protorune.tasks;

import com.elmnt.protorune.RuneCharacter;
import com.elmnt.protorune.RunePower;

import android.os.AsyncTask;
import android.util.Log;

public class CastPowerAsyncTask extends AsyncTask<Void, Void, Object> {

	private RunePower power;
	private RuneCharacter caster_character;
	private RuneCharacter target_character;

	public CastPowerAsyncTask(RunePower power, RuneCharacter player_character,
			RuneCharacter enemy_character) {
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
			
			if (timer > 60) {
				overall++;
				timer = 0;
			}
		}
		
		this.power.execute(caster_character.getCurrent_situation(), caster_character, target_character);
		
		Log.v("PROTO", "CASTED!");
		
		return null;
	}

}
