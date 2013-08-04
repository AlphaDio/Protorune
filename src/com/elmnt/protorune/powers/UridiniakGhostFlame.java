package com.elmnt.protorune.powers;

import com.elmnt.protorune.RuneCharacter;
import com.elmnt.protorune.RunePower;
import com.elmnt.protorune.Situation;

public class UridiniakGhostFlame extends RunePower {

	private Integer cast_time = 5000;
	
	public String getName() {
		return "Uridiniak's Ghost Flame";
	}
	
	@Override
	public void execute(Situation current_situation, RuneCharacter caster,
			RuneCharacter target) {
		caster.dealsDamage(target, 10);
	}

}
