package com.mortiseandmagic.pftool.model;

public class MagicItem {
	
	/* Name	Aura	CL	Slot	Price	Weight	Description	Requirements	Cost	Group	Source	AL	
	 * Int	Wis	Cha	Ego	Communication	Senses	Powers	MagicItems	FullText	
	 * Destruction	MinorArtifactFlag	MajorArtifactFlag	Abjuration	Conjuration	Divination	Enchantment	
	 * Evocation	Necromancy	Transmutation	AuraStrength	WeightValue	PriceValue	CostValue	Languages	
	 * BaseItem	LinkText	id	Mythic	LegendaryWeapon	Illusion	Universal	Scaling*/
	
	private String name;
	private String aura;
	private String cl;
	private String slot;
	private String price;
	private String weight;
	private String description;
	private String requirements;
	private String cost;
	private String group;
	private String source;
	private String alignment;
	private String intel;
	private String wis;
	private String cha;
	private String ego;
	private String communication;
	private String senses;
	private String powers;
	private String magicItems;
	private String destruction;
	private boolean minorArtifact;
	private boolean majorArtifact;
	private boolean abjuration;
	private boolean conjuration;
	private boolean divination;
	private boolean enchantment;
	private boolean evocation;
	private boolean necromancy;
	private boolean transmutation;
	private String auraStrength;
	private double weightValue;
	private double priceValue;
	private double costValue;
	private String languages;
	private String baseItem;
	private boolean mythic;
	private boolean legendary;
	private boolean illusion;
	private boolean universal;
	private String scaling;
	
	
	
	public String getAuraStrength() {
		return auraStrength;
	}
	public void setAuraStrength(String auraStrength) {
		this.auraStrength = auraStrength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAura() {
		return aura;
	}
	public void setAura(String aura) {
		this.aura = aura;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public String getIntel() {
		return intel;
	}
	public void setIntel(String intel) {
		this.intel = intel;
	}
	public String getWis() {
		return wis;
	}
	public void setWis(String wis) {
		this.wis = wis;
	}
	public String getCha() {
		return cha;
	}
	public void setCha(String cha) {
		this.cha = cha;
	}
	public String getEgo() {
		return ego;
	}
	public void setEgo(String ego) {
		this.ego = ego;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public String getSenses() {
		return senses;
	}
	public void setSenses(String senses) {
		this.senses = senses;
	}
	public String getPowers() {
		return powers;
	}
	public void setPowers(String powers) {
		this.powers = powers;
	}
	public String getMagicItems() {
		return magicItems;
	}
	public void setMagicItems(String magicItems) {
		this.magicItems = magicItems;
	}
	public String getDestruction() {
		return destruction;
	}
	public void setDestruction(String destruction) {
		this.destruction = destruction;
	}
	public boolean isMinorArtifact() {
		return minorArtifact;
	}
	public void setMinorArtifact(boolean minorArtifact) {
		this.minorArtifact = minorArtifact;
	}
	public boolean isMajorArtifact() {
		return majorArtifact;
	}
	public void setMajorArtifact(boolean majorArtifact) {
		this.majorArtifact = majorArtifact;
	}
	public boolean isAbjuration() {
		return abjuration;
	}
	public void setAbjuration(boolean abjuration) {
		this.abjuration = abjuration;
	}
	public boolean isConjuration() {
		return conjuration;
	}
	public void setConjuration(boolean conjuration) {
		this.conjuration = conjuration;
	}
	public boolean isDivination() {
		return divination;
	}
	public void setDivination(boolean divination) {
		this.divination = divination;
	}
	public boolean isEnchantment() {
		return enchantment;
	}
	public void setEnchantment(boolean enchantment) {
		this.enchantment = enchantment;
	}
	public boolean isEvocation() {
		return evocation;
	}
	public void setEvocation(boolean evocation) {
		this.evocation = evocation;
	}
	public boolean isNecromancy() {
		return necromancy;
	}
	public void setNecromancy(boolean necromancy) {
		this.necromancy = necromancy;
	}
	public boolean isTransmutation() {
		return transmutation;
	}
	public void setTransmutation(boolean transmutation) {
		this.transmutation = transmutation;
	}
	
	public double getWeightValue() {
		return weightValue;
	}
	public void setWeightValue(double weightValue) {
		this.weightValue = weightValue;
	}
	public double getPriceValue() {
		return priceValue;
	}
	public void setPriceValue(double priceValue) {
		this.priceValue = priceValue;
	}
	public double getCostValue() {
		return costValue;
	}
	public void setCostValue(double costValue) {
		this.costValue = costValue;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getBaseItem() {
		return baseItem;
	}
	public void setBaseItem(String baseItem) {
		this.baseItem = baseItem;
	}
	public boolean isMythic() {
		return mythic;
	}
	public void setMythic(boolean mythic) {
		this.mythic = mythic;
	}
	public boolean isLegendary() {
		return legendary;
	}
	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}
	public boolean isIllusion() {
		return illusion;
	}
	public void setIllusion(boolean illusion) {
		this.illusion = illusion;
	}
	public boolean isUniversal() {
		return universal;
	}
	public void setUniversal(boolean universal) {
		this.universal = universal;
	}
	public String getScaling() {
		return scaling;
	}
	public void setScaling(String scaling) {
		this.scaling = scaling;
	}
	
	

}
