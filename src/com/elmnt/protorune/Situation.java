package com.elmnt.protorune;

import com.elmnt.protorune.tasks.CastPowerAsyncTask;

import android.app.Activity;
import android.widget.EditText;

public class Situation {
	
	private Activity display;

	private RuneCharacter player_character = null;
	private RuneCharacter enemy_character = null;
	
	public void add_player(RuneCharacter player_character) {
		this.player_character = player_character;
		this.player_character.attach_to_situation(this);
	}

	public void start(MainActivity mainActivity) {
		this.display = mainActivity;
		this.enemy_character = new DefaultEnemy();
		
	}

	public void tell_damage(RuneCharacter runeCharacter, RuneCharacter target,
			int i) {
		EditText t = ((EditText) display.findViewById(R.id.output_log));
		
		t.append("Hp: " + target.current_hp);
	}

	public void cast(RunePower power) {
		new CastPowerAsyncTask(power, player_character, enemy_character);
		
	}

}
