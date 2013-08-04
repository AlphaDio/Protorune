package com.elmnt.protorune;

import com.elmnt.protorune.powers.UridiniakGhostFlame;

public class DefaultCharacter extends RuneCharacter {

	String name = "Dante";
	
	public DefaultCharacter() {
		this.power1 = new UridiniakGhostFlame();
	}
	
}
