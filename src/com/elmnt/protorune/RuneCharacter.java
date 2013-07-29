package com.elmnt.protorune;

public class RuneCharacter {
	
	private Situation current_situation;
	
	String name;
	
	RunePower power1;
	RunePower power2;
	RunePower power3;
	
	Integer current_hp = 100;
	Integer max_hp = 100;
	
	public void attach_to_situation(Situation situation) {
		this.setCurrent_situation(situation);
	}
	
	public void dealsDamage(RuneCharacter target, int i) {
		this.current_hp -= i;
		
		if (this.current_hp < 0) {
			this.current_hp = 0;
		}
		if (this.current_hp > this.max_hp) {
			this.current_hp = this.max_hp;
		}
		
		// Tell
		this.getCurrent_situation().tell_damage(this, target, i);
	}

	public Situation getCurrent_situation() {
		return current_situation;
	}

	public void setCurrent_situation(Situation current_situation) {
		this.current_situation = current_situation;
	}

}
