package com.elmnt.protorune;

public class CastFactory {
	
	static RuneCast makeCast(RunePower power, RuneCharacter caster, RuneCharacter target) {
		RuneCast cast = new NormalCast(power, caster, target);
				
		//RuneCast nullCast = new NullCast(power, caster, target);
		
		return cast;
	}

}
