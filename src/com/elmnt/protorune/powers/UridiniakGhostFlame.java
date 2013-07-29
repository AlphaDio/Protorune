package com.elmnt.protorune.powers;

import com.elmnt.protorune.RuneCharacter;
import com.elmnt.protorune.RunePower;
import com.elmnt.protorune.Situation;

public class UridiniakGhostFlame extends RunePower {

	Integer cast_time = 5;
	
	@Override
	public void execute(Situation current_situation, RuneCharacter caster,
			RuneCharacter target) {
		caster.dealsDamage(target, 10);
	}

}
