package com.mortiseandmagic.pftool.model;

public enum Class {
	
	SORCERER("Sorcerer", "sor"),
	WIZARD("WIZARD","wiz"),
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
	

	

	private int medium;
	private int mesmerist;
	private int occultist;
	private int spiritualist;
	private int skald;
	private int investigator;
	private int hunter;
	
	private final String displayName;
	private final String shortName;
	Class(String displayName, String shortName) {
		this.displayName = displayName;
		this.shortName = shortName;
	}

}
