package com.mortiseandmagic.pftool.model;

public class Feat {
	
	/*id	name	type	description	prerequisites	prerequisite_feats	benefit	normal	
	 * special	source	fulltext	teamwork	critical	grit	style	performance	racial	
	 * companion_familiar	race_name	note	goal	completion_benefit	multiples	suggested_traits	
	 * prerequisite_skills	panache	betrayal	targeting	esoteric	stare	weapon_mastery	
	 * item_mastery	armor_mastery	shield_mastery	blood_hex	trick
	 */
	
	private String name;
	private String type;
	private String description;
	private String prereq;
	private String prerequisiteFeats;
	private String benefit;
	private String normal;
	private String special;
	private String source;
	private boolean teamwork;
	private boolean critical;
	private boolean grit;
	private boolean style;
	private boolean performance;
	private boolean racial;
	private String raceName;
	private String goal;
	private String completionBonus;
	private boolean multiples;
	private String prerequisiteSkills;
	private boolean panache;
	private boolean betrayal;
	private boolean targeting;
	
	
	public boolean isMultiples() {
		return multiples;
	}
	public void setMultiples(boolean multiples) {
		this.multiples = multiples;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrereq() {
		return prereq;
	}
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
	public String getPrerequisiteFeats() {
		return prerequisiteFeats;
	}
	public void setPrerequisiteFeats(String prerequisiteFeats) {
		this.prerequisiteFeats = prerequisiteFeats;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public String getNormal() {
		return normal;
	}
	public void setNormal(String normal) {
		this.normal = normal;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public boolean isTeamwork() {
		return teamwork;
	}
	public void setTeamwork(boolean teamwork) {
		this.teamwork = teamwork;
	}
	public boolean isCritical() {
		return critical;
	}
	public void setCritical(boolean critical) {
		this.critical = critical;
	}
	public boolean isGrit() {
		return grit;
	}
	public void setGrit(boolean grit) {
		this.grit = grit;
	}
	public boolean isStyle() {
		return style;
	}
	public void setStyle(boolean style) {
		this.style = style;
	}
	public boolean isPerformance() {
		return performance;
	}
	public void setPerformance(boolean performance) {
		this.performance = performance;
	}
	public boolean isRacial() {
		return racial;
	}
	public void setRacial(boolean racial) {
		this.racial = racial;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getCompletionBonus() {
		return completionBonus;
	}
	public void setCompletionBonus(String completionBonus) {
		this.completionBonus = completionBonus;
	}
	public String getPrerequisiteSkills() {
		return prerequisiteSkills;
	}
	public void setPrerequisiteSkills(String prerequisiteSkills) {
		this.prerequisiteSkills = prerequisiteSkills;
	}
	public boolean isPanache() {
		return panache;
	}
	public void setPanache(boolean panache) {
		this.panache = panache;
	}
	public boolean isBetrayal() {
		return betrayal;
	}
	public void setBetrayal(boolean betrayal) {
		this.betrayal = betrayal;
	}
	public boolean isTargeting() {
		return targeting;
	}
	public void setTargeting(boolean targeting) {
		this.targeting = targeting;
	}
	
	
	
	

}
