package com.mortiseandmagic.pftool.model;

import java.util.List;

public class Monster {
	
	private String name;
	private String cr;
	private String xp;
	private String race;
	private String className;
	//monsterSource
	private String alignment;
	private String size;
	private String type;
	private String subType;
	private String init;
	private String senses;
	private String aura;
	private List<String> ac;
	private String acMods;
	private int hp;
	private String hd;
	private String hpMods;
	//private String saves;
	private String fort;
	private String ref;
	private String will;
	private String saveMods;
	private String defenseAbilities;
	private String dr;
	private String immune;
	private String resist;
	private String sr;
	private String weaknesses;
	private String speed;
	private String speedMod;
	private String melee;
	private String ranged;
	private String space;
	private String reach;
	private String SpecialAttacks;
	private List<AbilityHolder> spellLikeAbilities;
	private List<AbilityHolder> spellsKnown;
	private List<AbilityHolder> spellsPrepared;
	private String spellDomains;
	private List<String> abilitiyScores;
	private String abilityScoreMods;
	private String baseAtk;
	private String cmb;
	private String cmd;
	private List<String> feats;
	private List<String> skills;
	private List<String> racialMods;
	private List<String> languages;
	private String sq;
	private String environment;
	private String org;
	private String treasure;
	private String visualDescription;
	private String group;
	private String source;
	private boolean isTemplate;
	private String specialAbilities;
	private String description;
	//fullText
	private String gender;
	private String bloodline;
	//prohibitedSchools
	private String beforeCombat;
	private String duringCombat;
	private String morale;
	private String gear;
	private String otherGear;
	private String vulnerability;
	private String note;
	private boolean character;
	private boolean companion;
	private boolean fly;
	private boolean climb;
	private boolean burrow;
	private boolean swim;
	private boolean land;
	private String templatesApplied;
	private String offenseNote;
	private String baseStatistics;
	private String extractsPrepared;
	private String ageCategory;
	private boolean useRacialHD;
	private String variantParent;
	private String mystery;
	private String classArchetypes;
	private String patron;
	private String companionFamiliarLink;
	private String traits;
	private String alternateNameForm;
	private String statisticsNote;
	//linkText
	//id
	private boolean uniqueMonster;
	private boolean mr;
	private boolean mythic;
	private boolean mt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getXp() {
		return xp;
	}
	public void setXp(String xp) {
		this.xp = xp;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	public String getSenses() {
		return senses;
	}
	public void setSenses(String senses) {
		this.senses = senses;
	}
	public String getAura() {
		return aura;
	}
	public void setAura(String aura) {
		this.aura = aura;
	}
	public List<String> getAc() {
		return ac;
	}
	public void setAc(List<String> ac) {
		this.ac = ac;
	}
	public String getAcMods() {
		return acMods;
	}
	public void setAcMods(String acMods) {
		this.acMods = acMods;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getHpMods() {
		return hpMods;
	}
	public void setHpMods(String hpMods) {
		this.hpMods = hpMods;
	}
	public String getFort() {
		return fort;
	}
	public void setFort(String fort) {
		this.fort = fort;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getWill() {
		return will;
	}
	public void setWill(String will) {
		this.will = will;
	}
	public String getSaveMods() {
		return saveMods;
	}
	public void setSaveMods(String saveMods) {
		this.saveMods = saveMods;
	}
	public String getDefenseAbilities() {
		return defenseAbilities;
	}
	public void setDefenseAbilities(String defenseAbilities) {
		this.defenseAbilities = defenseAbilities;
	}
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public String getImmune() {
		return immune;
	}
	public void setImmune(String immune) {
		this.immune = immune;
	}
	public String getResist() {
		return resist;
	}
	public void setResist(String resist) {
		this.resist = resist;
	}
	public String getSr() {
		return sr;
	}
	public void setSr(String sr) {
		this.sr = sr;
	}
	public String getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getSpeedMod() {
		return speedMod;
	}
	public void setSpeedMod(String speedMod) {
		this.speedMod = speedMod;
	}
	public String getMelee() {
		return melee;
	}
	public void setMelee(String melee) {
		this.melee = melee;
	}
	public String getRanged() {
		return ranged;
	}
	public void setRanged(String ranged) {
		this.ranged = ranged;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getReach() {
		return reach;
	}
	public void setReach(String reach) {
		this.reach = reach;
	}
	public String getSpecialAttacks() {
		return SpecialAttacks;
	}
	public void setSpecialAttacks(String specialAttacks) {
		SpecialAttacks = specialAttacks;
	}	
	
	public List<AbilityHolder> getSpellLikeAbilities() {
		return spellLikeAbilities;
	}
	public void setSpellLikeAbilities(List<AbilityHolder> spellLikeAbilities) {
		this.spellLikeAbilities = spellLikeAbilities;
	}
	
	
	public List<AbilityHolder> getSpellsKnown() {
		return spellsKnown;
	}
	public void setSpellsKnown(List<AbilityHolder> spellsKnown) {
		this.spellsKnown = spellsKnown;
	}
	public List<AbilityHolder> getSpellsPrepared() {
		return spellsPrepared;
	}
	public void setSpellsPrepared(List<AbilityHolder> spellsPrepared) {
		this.spellsPrepared = spellsPrepared;
	}
	public String getSpellDomains() {
		return spellDomains;
	}
	public void setSpellDomains(String spellDomains) {
		this.spellDomains = spellDomains;
	}
	public List<String> getAbilitiyScores() {
		return abilitiyScores;
	}
	public void setAbilitiyScores(List<String> abilitiyScores) {
		this.abilitiyScores = abilitiyScores;
	}
	public String getAbilityScoreMods() {
		return abilityScoreMods;
	}
	public void setAbilityScoreMods(String abilityScoreMods) {
		this.abilityScoreMods = abilityScoreMods;
	}
	public String getBaseAtk() {
		return baseAtk;
	}
	public void setBaseAtk(String baseAtk) {
		this.baseAtk = baseAtk;
	}
	public String getCmb() {
		return cmb;
	}
	public void setCmb(String cmb) {
		this.cmb = cmb;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public List<String> getFeats() {
		return feats;
	}
	public void setFeats(List<String> feats) {
		this.feats = feats;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getRacialMods() {
		return racialMods;
	}
	public void setRacialMods(List<String> racialMods) {
		this.racialMods = racialMods;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public String getSq() {
		return sq;
	}
	public void setSq(String sq) {
		this.sq = sq;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getTreasure() {
		return treasure;
	}
	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}
	public String getVisualDescription() {
		return visualDescription;
	}
	public void setVisualDescription(String visualDescription) {
		this.visualDescription = visualDescription;
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
	public boolean isTemplate() {
		return isTemplate;
	}
	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}
	public String getSpecialAbilities() {
		return specialAbilities;
	}
	public void setSpecialAbilities(String specialAbilities) {
		this.specialAbilities = specialAbilities;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodline() {
		return bloodline;
	}
	public void setBloodline(String bloodline) {
		this.bloodline = bloodline;
	}
	public String getBeforeCombat() {
		return beforeCombat;
	}
	public void setBeforeCombat(String beforeCombat) {
		this.beforeCombat = beforeCombat;
	}
	public String getDuringCombat() {
		return duringCombat;
	}
	public void setDuringCombat(String duringCombat) {
		this.duringCombat = duringCombat;
	}
	public String getMorale() {
		return morale;
	}
	public void setMorale(String morale) {
		this.morale = morale;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public String getOtherGear() {
		return otherGear;
	}
	public void setOtherGear(String otherGear) {
		this.otherGear = otherGear;
	}
	public String getVulnerability() {
		return vulnerability;
	}
	public void setVulnerability(String vulnerability) {
		this.vulnerability = vulnerability;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isCharacter() {
		return character;
	}
	public void setCharacter(boolean character) {
		this.character = character;
	}
	public boolean isCompanion() {
		return companion;
	}
	public void setCompanion(boolean companion) {
		this.companion = companion;
	}
	public boolean isFly() {
		return fly;
	}
	public void setFly(boolean fly) {
		this.fly = fly;
	}
	public boolean isClimb() {
		return climb;
	}
	public void setClimb(boolean climb) {
		this.climb = climb;
	}
	public boolean isBurrow() {
		return burrow;
	}
	public void setBurrow(boolean burrow) {
		this.burrow = burrow;
	}
	public boolean isSwim() {
		return swim;
	}
	public void setSwim(boolean swim) {
		this.swim = swim;
	}
	public boolean isLand() {
		return land;
	}
	public void setLand(boolean land) {
		this.land = land;
	}
	public String getTemplatesApplied() {
		return templatesApplied;
	}
	public void setTemplatesApplied(String templatesApplied) {
		this.templatesApplied = templatesApplied;
	}
	public String getOffenseNote() {
		return offenseNote;
	}
	public void setOffenseNote(String offenseNote) {
		this.offenseNote = offenseNote;
	}
	public String getBaseStatistics() {
		return baseStatistics;
	}
	public void setBaseStatistics(String baseStatistics) {
		this.baseStatistics = baseStatistics;
	}
	public String getExtractsPrepared() {
		return extractsPrepared;
	}
	public void setExtractsPrepared(String extractsPrepared) {
		this.extractsPrepared = extractsPrepared;
	}
	public String getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}
	public boolean isUseRacialHD() {
		return useRacialHD;
	}
	public void setUseRacialHD(boolean useRacialHD) {
		this.useRacialHD = useRacialHD;
	}
	public String getVariantParent() {
		return variantParent;
	}
	public void setVariantParent(String variantParent) {
		this.variantParent = variantParent;
	}
	public String getMystery() {
		return mystery;
	}
	public void setMystery(String mystery) {
		this.mystery = mystery;
	}
	public String getClassArchetypes() {
		return classArchetypes;
	}
	public void setClassArchetypes(String classArchetypes) {
		this.classArchetypes = classArchetypes;
	}
	public String getPatron() {
		return patron;
	}
	public void setPatron(String patron) {
		this.patron = patron;
	}
	public String getCompanionFamiliarLink() {
		return companionFamiliarLink;
	}
	public void setCompanionFamiliarLink(String companionFamiliarLink) {
		this.companionFamiliarLink = companionFamiliarLink;
	}
	public String getTraits() {
		return traits;
	}
	public void setTraits(String traits) {
		this.traits = traits;
	}
	public String getAlternateNameForm() {
		return alternateNameForm;
	}
	public void setAlternateNameForm(String alternateNameForm) {
		this.alternateNameForm = alternateNameForm;
	}
	public String getStatisticsNote() {
		return statisticsNote;
	}
	public void setStatisticsNote(String statisticsNote) {
		this.statisticsNote = statisticsNote;
	}
	public boolean isUniqueMonster() {
		return uniqueMonster;
	}
	public void setUniqueMonster(boolean uniqueMonster) {
		this.uniqueMonster = uniqueMonster;
	}
	public boolean isMr() {
		return mr;
	}
	public void setMr(boolean mr) {
		this.mr = mr;
	}
	public boolean isMythic() {
		return mythic;
	}
	public void setMythic(boolean mythic) {
		this.mythic = mythic;
	}
	public boolean isMt() {
		return mt;
	}
	public void setMt(boolean mt) {
		this.mt = mt;
	}
	
	

}
