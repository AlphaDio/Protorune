package com.elmnt.protorune;

import com.elmnt.protorune.tasks.CastPowerAsyncTask;

public class NormalCast extends AbstractCast implements RuneCast {

	public NormalCast(RunePower power, RuneCharacter caster, RuneCharacter target) {
		this.castedPower = power;
		this.caster = caster;
		this.target = target;
	}

	@Override
	public CastManager getParent() {
		return this.parent;
	}

	@Override
	public void activate() {
		if (this.state == RuneCast.STATE_UNCASTED) {
			new CastPowerAsyncTask( this, this.castedPower, this.caster, this.target).execute();
		}
	}

	@Override
	public RunePower getPower() {
		return this.castedPower;
	}

}
