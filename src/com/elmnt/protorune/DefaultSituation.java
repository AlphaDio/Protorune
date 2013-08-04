package com.elmnt.protorune;

import android.app.Activity;

public class DefaultSituation extends Situation {
	
	
	public DefaultSituation(Activity activity) {
		this.display = activity;
		this.enemy_character = new DefaultEnemy();
	}

}
