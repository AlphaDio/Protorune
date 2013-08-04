package com.elmnt.protorune;

public abstract class RunePower {
	
	private Integer cast_time = 2000;
	
	public abstract void execute(Situation current_situation, RuneCharacter caster, RuneCharacter target);

	public Integer getCast_time() {
		return cast_time;
	}

	public void setCast_time(Integer cast_time) {
		this.cast_time = cast_time;
	}

	public abstract String getName();

	
}
