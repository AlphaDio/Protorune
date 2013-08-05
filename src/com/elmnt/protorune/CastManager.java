package com.elmnt.protorune;


public class CastManager {
	
	private RuneCharacter parent;
	
	private CastRunner firstCastSlot;
	private CastRunner secondCastSlot;
	
	
	public CastManager(RuneCharacter parent) {
		this.parent = parent;
		
		this.firstCastSlot = new CastSlot(this);
		this.secondCastSlot = new CastSlot(this);
	}


	public void cast(int i, RuneCharacter target) {
		// get the power
		RunePower power = this.parent.getPowerFromInt(i);
		
		// Make a Cast out of it
		RuneCast cast = CastFactory.makeCast(power, this.parent, target);
		
		if (power != null) {
			this.queueCast(cast);
		}
	}

	// Check if the cast can be added to the cast manager, if not discard it
	private void queueCast(RuneCast cast) {
		if (firstCastSlot.isAvailable()) {
			firstCastSlot.slotPower(cast);
		}
		if (this.secondCastSlot.isAvailable()) {
			this.secondCastSlot.slotPower(cast);
		}
	}


}
