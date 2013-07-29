package com.elmnt.protorune;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Situation current_situation;
	private RuneCharacter player_character;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Create a Default Character, normally should come from the session.
		this.player_character = new DefaultCharacter();
		
		this.current_situation = new DefaultSituation();
		
		// Add the character to the situation
		this.current_situation.add_player(this.player_character);
		
		this.current_situation.start(this);
		
		Button b = ((Button) findViewById(R.id.power_1));
		
		b.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					MainActivity.this.current_situation.cast(MainActivity.this.player_character.power1);
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}