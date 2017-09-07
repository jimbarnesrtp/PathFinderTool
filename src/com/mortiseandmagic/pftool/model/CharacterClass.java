package com.mortiseandmagic.pftool.model;

import com.google.gson.annotations.SerializedName;


public enum CharacterClass {
	
	SORCERER("Sorcerer", "sor"),
	WIZARD("Wizard","wiz"),
	CLERIC("Cleric","cleric"),
	DRUID("Druid", "druid"),
	RANGER("Ranger","ranger"),
	BARD("Bard","bard"),
	PALADIN("Paladin", "paladin"),
	ALCHEMIST("Alchemist", "alchemist"),
	SUMMONER("Summoner", "summoner"),
	WITCH("Witch", "witch"),
	INQUISITOR("Inquisitor", "inquisitor"),
	ORACLE("Oracle", "oracle"),
	ANTIPALADINT("Anti-Paladin", "antipalading"),
	MAGUS("Magus", "magus"),
	ADEPT("Adept", "adept"),
	BLOODRAGER("Bloodrager", "bloodrager"),
	SHAMAN("Shaman", "shaman"),
	PSYCHIC("Psychic", "psychic"),
	MEDIUM("Medium", "medium"),
	MESMERIST("Mesmerist", "mesmerist"),
	OCCULTIST("Occultist", "occultist"),
	SPIRITUALIST("Spiritualist", "spiritualist"),
	SKALD("Skald", "skald"),
	INVESTIGATOR("Investigator", "investigator"),
	HUNTER("Hunter", "hunter");


	private final String displayName;
	private final String shortName;
	CharacterClass(String displayName, String shortName) {
		this.displayName = displayName;
		this.shortName = shortName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public String getShortName() {
		return shortName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"name\":\""+getDisplayName()+",\"shortName\":\""+getShortName()+"\"}";
	}
	
	
	

}
