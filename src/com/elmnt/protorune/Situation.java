package com.elmnt.protorune;

import com.elmnt.protorune.tasks.CastPowerAsyncTask;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Situation {
	
	private Activity display;

	private RuneCharacter player_character = null;
	private RuneCharacter enemy_character = null;
	
	public void add_player(RuneCharacter player_character) {
		Log.v("PROTORUNE", "Adding Player!");
		
		this.player_character = player_character;
		this.player_character.attach_to_situation(this);
		
		Log.v("PROTORUNE", "Added Player!");
	}
	
	public void add_enemy(RuneCharacter enemy_character) {
		Log.v("PROTORUNE", "Adding Enemy!");
		
		this.enemy_character = enemy_character;
		this.enemy_character.attach_to_situation(this);
		
		Log.v("PROTORUNE", "Added Enemy!");
	}

	public void start(MainActivity mainActivity) {
		Log.v("PROTORUNE", "Starting Default Situation!");
		
		this.display = mainActivity;
		this.enemy_character = new DefaultEnemy();
		
		Log.v("PROTORUNE", "Started Default Situation!");
		
	}

	public void tell_damage(RuneCharacter runeCharacter, final RuneCharacter target,
			int i) {
		// Cannot call Toast from a non-UI thread
		this.display.runOnUiThread(new Runnable() {
		  public void run() {
			  Toast.makeText(display, "Hp: " + target.current_hp, Toast.LENGTH_LONG).show();
		  }
		});
		// EditText t = ((EditText) display.findViewById(R.id.output_log));
		
		// t.append("Hp: " + target.current_hp);
	}

	public void cast(RunePower power) {
		Log.v("PROTORUNE", "Casting!");
		if (power != null) {
			
			Log.v("PROTORUNE", "Sending Power with name:" + power.getName() + " and Cast Time:" + power.getCast_time());
			
			new CastPowerAsyncTask(power, player_character, enemy_character).execute();
		} else {
			Log.v("PROTORUNE", "No power passed!!");
		}
		
		Log.v("PROTORUNE", "Casted!");
		
	}

	public void playerCast(int i) {
		Log.v("PROTORUNE", "Player Casting!");
		RunePower casted_power = null;
		
		if (i == 1) {
			casted_power = this.player_character.power1;
		}
		
		if (casted_power != null) {
			Log.v("PROTORUNE", "Player Cast Starting!");
			new CastPowerAsyncTask(casted_power, player_character, enemy_character).execute();
		}
		
		Log.v("PROTORUNE", "Player Casted!");
	}

}
