package com.elmnt.protorune;

public class CastManager {
	
	private RuneCharacter parent;
	
	private RuneCast cast1;
	private RuneCast cast2;
	private RuneCast cast3;
	
	
	public CastManager(RuneCharacter parent) {
		this.parent = parent;
		this.cast1 = null;
		this.cast2 = null;
		this.cast3 = null;
	}


	public void cast(int i, RuneCharacter target) {
		// get the power
		RunePower power = this.parent.getPowerFromInt(i);
		
		if (power != null) {
			RuneCast cast = new NormalCast(power, this.parent, target);
			this.queueCast(cast);
		}
	}

	// Check if the cast can be added to the cast manager, if not discard it
	private void queueCast(RuneCast cast) {
		if (this.cast1 == null) {
			this.cast1 = cast;
		}
		
		checkCasts();
	}


	private void checkCasts() {
		if (this.cast1 != null) {
			this.cast1.activate();
		}
	}

}
