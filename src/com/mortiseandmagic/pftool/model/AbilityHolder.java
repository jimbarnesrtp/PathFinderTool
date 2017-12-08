package com.mortiseandmagic.pftool.model;

import java.util.LinkedList;
import java.util.List;

public class AbilityHolder {
	private String name;
	private List<String> abilities;
	private String casterLevel;
	private String concentration;
	
	
	
	
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getCasterLevel() {
		return casterLevel;
	}
	public void setCasterLevel(String casterLevel) {
		this.casterLevel = casterLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	
	public void addAbility(String ability) {
		if(this.abilities == null) {
			this.abilities = new LinkedList<String>();
		}
		this.abilities.add(ability);
	}
	
}
