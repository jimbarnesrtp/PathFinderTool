package com.mortiseandmagic.pftool.model;

public class Spell {
	
	private String name;
	private String school;
	private String subschool;
	private String descriptor;
	//private Map<String, Integer> spell_levels;
	private String casting_time;
	private String[] components;
	private boolean costly_components;
	private String range;
	private String area;
	private String effect;
	private String targets;
	private String duration;
	private boolean dismissible;
	private boolean shapeable;
	private String saving_throw;
	private String spell_resistence;
	private String description;
	//description_formated
	private String source;
	//full_text	
	private boolean verbal;
	private boolean somatic;
	private boolean material;
	private boolean focus;
	private boolean divine_focus;
	//sor	wiz	cleric	druid	ranger	bard	paladin	alchemist	summoner	witch	inquisitor	oracle	antipaladin	magus	adept	
	private SpellLevel spellLevel;
	private String deity;
	private int SLA_Level;
	private String[] domain;
	private String short_description;
	private boolean	acid = false;
	private boolean	air = false;
	private boolean	chaotic = false;
	private boolean	cold = false;
	private boolean	curse = false;
	private boolean	darkness = false;
	private boolean	death = false;
	private boolean	disease = false;
	private boolean	earth = false;
	private boolean	electricity = false;
	private boolean	emotion = false;
	private boolean	evil = false;
	private boolean	fear = false;
	private boolean	fire = false;
	private boolean	force = false;
	private boolean	good = false;
	private boolean	language_dependent = false;
	private boolean	lawful = false;
	private boolean	light = false;
	private boolean	mind_affecting = false;
	private boolean	pain = false;
	private boolean	poison = false;
	private boolean	shadow = false;
	private boolean	sonic = false;
	private boolean	water = false;
	private String linktext;
	private int id;
	private String material_costs;
	private String[] bloodline;
	private String[] patron;
	private String mythic_text;	
	private String augmented;
	private boolean mythic;
	//bloodrager	shaman	psychic	medium	mesmerist	occultist	spiritualist	skald	investigator	hunter goes with SpellLevel
	private String	haunt_statistics;
	private boolean ruse = false;
	private boolean draconic = false;
	private boolean meditative = false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSubschool() {
		return subschool;
	}
	public void setSubschool(String subschool) {
		this.subschool = subschool;
	}
	public String getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	public String getCasting_time() {
		return casting_time;
	}
	public void setCasting_time(String casting_time) {
		this.casting_time = casting_time;
	}
	public String[] getComponents() {
		return components;
	}
	public void setComponents(String[] components) {
		this.components = components;
	}
	public boolean isCostly_components() {
		return costly_components;
	}
	public void setCostly_components(boolean costly_components) {
		this.costly_components = costly_components;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getTargets() {
		return targets;
	}
	public void setTargets(String targets) {
		this.targets = targets;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public boolean isDismissible() {
		return dismissible;
	}
	public void setDismissible(boolean dismissible) {
		this.dismissible = dismissible;
	}
	public boolean isShapeable() {
		return shapeable;
	}
	public void setShapeable(boolean shapeable) {
		this.shapeable = shapeable;
	}
	public String getSaving_throw() {
		return saving_throw;
	}
	public void setSaving_throw(String saving_throw) {
		this.saving_throw = saving_throw;
	}
	public String getSpell_resistence() {
		return spell_resistence;
	}
	public void setSpell_resistence(String spell_resistence) {
		this.spell_resistence = spell_resistence;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public boolean isVerbal() {
		return verbal;
	}
	public void setVerbal(boolean verbal) {
		this.verbal = verbal;
	}
	public boolean isSomatic() {
		return somatic;
	}
	public void setSomatic(boolean somatic) {
		this.somatic = somatic;
	}
	public boolean isMaterial() {
		return material;
	}
	public void setMaterial(boolean material) {
		this.material = material;
	}
	public boolean isFocus() {
		return focus;
	}
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	public boolean isDivine_focus() {
		return divine_focus;
	}
	public void setDivine_focus(boolean divine_focus) {
		this.divine_focus = divine_focus;
	}
	public SpellLevel getSpellLevel() {
		return spellLevel;
	}
	public void setSpellLevel(SpellLevel spellLevel) {
		this.spellLevel = spellLevel;
	}
	public String getDeity() {
		return deity;
	}
	public void setDeity(String deity) {
		this.deity = deity;
	}
	public int getSLA_Level() {
		return SLA_Level;
	}
	public void setSLA_Level(int sLA_Level) {
		SLA_Level = sLA_Level;
	}
	public String[] getDomain() {
		return domain;
	}
	public void setDomain(String[] domain) {
		this.domain = domain;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public boolean isAcid() {
		return acid;
	}
	public void setAcid(boolean acid) {
		this.acid = acid;
	}
	public boolean isAir() {
		return air;
	}
	public void setAir(boolean air) {
		this.air = air;
	}
	public boolean isChaotic() {
		return chaotic;
	}
	public void setChaotic(boolean chaotic) {
		this.chaotic = chaotic;
	}
	public boolean isCold() {
		return cold;
	}
	public void setCold(boolean cold) {
		this.cold = cold;
	}
	public boolean isCurse() {
		return curse;
	}
	public void setCurse(boolean curse) {
		this.curse = curse;
	}
	public boolean isDarkness() {
		return darkness;
	}
	public void setDarkness(boolean darkness) {
		this.darkness = darkness;
	}
	public boolean isDeath() {
		return death;
	}
	public void setDeath(boolean death) {
		this.death = death;
	}
	public boolean isDisease() {
		return disease;
	}
	public void setDisease(boolean disease) {
		this.disease = disease;
	}
	public boolean isEarth() {
		return earth;
	}
	public void setEarth(boolean earth) {
		this.earth = earth;
	}
	public boolean isElectricity() {
		return electricity;
	}
	public void setElectricity(boolean electricity) {
		this.electricity = electricity;
	}
	public boolean isEmotion() {
		return emotion;
	}
	public void setEmotion(boolean emotion) {
		this.emotion = emotion;
	}
	public boolean isEvil() {
		return evil;
	}
	public void setEvil(boolean evil) {
		this.evil = evil;
	}
	public boolean isFear() {
		return fear;
	}
	public void setFear(boolean fear) {
		this.fear = fear;
	}
	public boolean isFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	public boolean isForce() {
		return force;
	}
	public void setForce(boolean force) {
		this.force = force;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public boolean isLanguage_dependent() {
		return language_dependent;
	}
	public void setLanguage_dependent(boolean language_dependent) {
		this.language_dependent = language_dependent;
	}
	public boolean isLawful() {
		return lawful;
	}
	public void setLawful(boolean lawful) {
		this.lawful = lawful;
	}
	public boolean isLight() {
		return light;
	}
	public void setLight(boolean light) {
		this.light = light;
	}
	public boolean isMind_affecting() {
		return mind_affecting;
	}
	public void setMind_affecting(boolean mind_affecting) {
		this.mind_affecting = mind_affecting;
	}
	public boolean isPain() {
		return pain;
	}
	public void setPain(boolean pain) {
		this.pain = pain;
	}
	public boolean isPoison() {
		return poison;
	}
	public void setPoison(boolean poison) {
		this.poison = poison;
	}
	public boolean isShadow() {
		return shadow;
	}
	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}
	public boolean isSonic() {
		return sonic;
	}
	public void setSonic(boolean sonic) {
		this.sonic = sonic;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public String getLinktext() {
		return linktext;
	}
	public void setLinktext(String linktext) {
		this.linktext = linktext;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaterial_costs() {
		return material_costs;
	}
	public void setMaterial_costs(String material_costs) {
		this.material_costs = material_costs;
	}
	public String[] getBloodline() {
		return bloodline;
	}
	public void setBloodline(String[] bloodline) {
		this.bloodline = bloodline;
	}
	public String[] getPatron() {
		return patron;
	}
	public void setPatron(String[] patron) {
		this.patron = patron;
	}
	public String getMythic_text() {
		return mythic_text;
	}
	public void setMythic_text(String mythic_text) {
		this.mythic_text = mythic_text;
	}
	public String getAugmented() {
		return augmented;
	}
	public void setAugmented(String augmented) {
		this.augmented = augmented;
	}
	public boolean isMythic() {
		return mythic;
	}
	public void setMythic(boolean mythic) {
		this.mythic = mythic;
	}
	public String getHaunt_statistics() {
		return haunt_statistics;
	}
	public void setHaunt_statistics(String haunt_statistics) {
		this.haunt_statistics = haunt_statistics;
	}
	public boolean isRuse() {
		return ruse;
	}
	public void setRuse(boolean ruse) {
		this.ruse = ruse;
	}
	public boolean isDraconic() {
		return draconic;
	}
	public void setDraconic(boolean draconic) {
		this.draconic = draconic;
	}
	public boolean isMeditative() {
		return meditative;
	}
	public void setMeditative(boolean meditative) {
		this.meditative = meditative;
	}
	
	

}
