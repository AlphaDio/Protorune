package com.elmnt.protorune;


public class NormalCast extends AbstractCast implements RuneCast {

	public NormalCast(RunePower power, RuneCharacter caster, RuneCharacter target) {
		this.castedPower = power;
		this.caster = caster;
		this.target = target;
	}

	@Override
	public void activate() {
		if (this.state == RuneCast.STATE_UNCASTED) {
			
		}
	}

	@Override
	public RunePower getPower() {
		return this.castedPower;
	}

	@Override
	public RuneCharacter getCaster() {
		return this.caster;
	}

	@Override
	public RuneCharacter getTarget() {
		return this.target;
	}

	@Override
	public CastSlot getRunner() {
		return this.parent;
	}

}
