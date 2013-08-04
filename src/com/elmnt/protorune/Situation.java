package com.elmnt.protorune;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.elmnt.protorune.tasks.CastPowerAsyncTask;

public class Situation {
	
	protected Activity display;

	private RuneCharacter player_character = null;
	protected RuneCharacter enemy_character = null;
	
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

	public void start() {
		Log.i("PROTORUNE", "Starting Default Situation!");
		
		Log.i("PROTORUNE", "Started Default Situation!");
		
	}

	public void tell_damage(RuneCharacter runeCharacter, final RuneCharacter target,
			int i) {
		this.updateUi();
		// EditText t = ((EditText) display.findViewById(R.id.output_log));
		
		// t.append("Hp: " + target.current_hp);
	}
	
	public void playerCast(int i) {
		Log.v("PROTORUNE", "Player Casting!");
		RunePower casted_power = null;
		
		if (i == 1) {
			casted_power = this.player_character.power1;
		}
		
		if (casted_power != null) {
			Log.v("PROTORUNE", "Player Cast Starting!");
			// new CastPowerAsyncTask(casted_power, this.player_character, this.enemy_character).execute();
		}
		
		Log.v("PROTORUNE", "Player Casted!");
	}

	public void updateUi() {
		
		// DEBUG
		if (this.player_character != null) {
			Log.i("PROTO", "Show Hp:" + this.player_character.current_hp + " of Character:" + this.player_character.toString());
			// I hate this whole "can't call UI directly"
			this.display.runOnUiThread(new Runnable() {
			  public void run() {
				  TextView player_hp = (TextView) Situation.this.display.findViewById(R.id.player_hp);
				  player_hp.setText(Integer.toString(Situation.this.player_character.current_hp));
			  }
			});
		}
		
		if (this.enemy_character != null) {
			Log.i("PROTO", "Show Hp:" + this.enemy_character.current_hp + " of Character:" + this.enemy_character.toString());
			
			// I hate this whole "can't call UI directly"
			this.display.runOnUiThread(new Runnable() {
				public void run() {
					TextView enemy_hp = (TextView) Situation.this.display.findViewById(R.id.enemy_hp);
					enemy_hp.setText(Integer.toString(Situation.this.enemy_character.current_hp));
				}
			});
		}
	}

}
