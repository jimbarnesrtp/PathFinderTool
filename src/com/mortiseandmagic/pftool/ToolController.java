package com.mortiseandmagic.pftool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mortiseandmagic.pftool.model.CharacterClass;
import com.mortiseandmagic.pftool.model.ClassHolder;
import com.mortiseandmagic.pftool.model.Feat;
import com.mortiseandmagic.pftool.model.MagicItem;
import com.mortiseandmagic.pftool.model.Spell;
import com.mortiseandmagic.pftool.model.SpellLevel;

@Controller
public class ToolController {
	
	private List<Spell> spells = null;
	private List<Feat> feats = null;
	private List<MagicItem> magicItems = null;
	
	@RequestMapping(value = "/GetSpells", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
	public ResponseEntity<List<Spell>> getSpells() {
		if(spells == null) {
			loadSpells();
		}
		return new ResponseEntity<List<Spell>>(spells, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/GetClasses",
		produces = { MediaType.APPLICATION_JSON_VALUE }, 
		method = RequestMethod.GET)
	public ResponseEntity<List<ClassHolder>> getClasses() {
		List<ClassHolder> classes = new ArrayList<ClassHolder>();
		for(CharacterClass c : CharacterClass.values()) {
			ClassHolder ch = new ClassHolder();
			ch.setDisplayName(c.getDisplayName());
			ch.setShortName(c.getShortName());
			classes.add(ch);
		}
		return new ResponseEntity<List<ClassHolder>>(classes, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/GetFeats", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
	public ResponseEntity<List<Feat>> getFeats() {
		if(spells == null) {
			loadFeats();
		}
		return new ResponseEntity<List<Feat>>(feats, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/GetMagicItems", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
	public ResponseEntity<List<MagicItem>> getMagicItems() {
		if(magicItems == null) {
			loadMagicItems();
		}
		return new ResponseEntity<List<MagicItem>>(magicItems, HttpStatus.OK);
	}
	
	private void loadSpells() {
		spells = new ArrayList<Spell>();
		InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("spell_full.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream ));
		try {
			String line = br.readLine();
			//System.out.println("Line:"+line);
			Pattern patt = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			while(line != null) {
				Scanner sc = new Scanner(line).useDelimiter(patt);
				//StringBuffer sb = new StringBuffer();
				Spell spell = new Spell();
				 while (sc.hasNext()) {
					 /*name	school	subschool	descriptor	spell_level	casting_time  components
					  * 	costly_components	range	area	effect	targets	duration	dismissible	shapeable	
					  * saving_throw	spell_resistence	description	description_formated	source	full_text	
					  * verbal	somatic	material	focus	divine_focus	sor	wiz	cleric	druid	ranger	bard	
					  * paladin	alchemist	summoner	witch	inquisitor	oracle	antipaladin	magus	adept	deity	
					  * SLA_Level	domain	short_description	acid	air	chaotic	cold	curse	darkness	
					  * death	disease	earth	electricity	emotion	evil	fear	fire	force	good	
					  * language_dependent	lawful	light	mind_affecting	pain	poison	shadow	sonic	water	linktext	
					  * id	material_costs	bloodline	patron	mythic_text	augmented	mythic	bloodrager	shaman	
					  * psychic	medium	mesmerist	occultist	spiritualist	skald	investigator	hunter	
					  * haunt_statistics	ruse	draconic	meditative
					 */
					 String name = sc.next().replace("\"", "");
					 //System.out.println(name);
					 //System.out.println("second Desc:"+desc);
					 spell.setName(name);
					 spell.setSchool(sc.next());
					 spell.setSubschool(sc.next());
					 spell.setDescriptor(sc.next().replace("\"", ""));
					 sc.next();
					 spell.setCasting_time(sc.next());
					 String comps = sc.next();
					 comps = comps.replace("\"", "");
					 Scanner compSc = new Scanner(comps).useDelimiter(",");
					 ArrayList<String> components = new ArrayList<String>();
					 while (compSc.hasNext()) {
						 components.add(compSc.next());
					 }
					 spell.setComponents(components.toArray(new String[components.size()]));
					 String booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setCostly_components(false);
					 } else {
						 spell.setCostly_components(true);
					 }
					 spell.setRange(sc.next());
					 spell.setArea(sc.next().replace("\"", ""));
					 spell.setEffect(sc.next().replace("\"", ""));
					 spell.setTargets(sc.next().replace("\"", ""));
					 spell.setDuration(sc.next().replace("\"", ""));
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setDismissible(false);
					 } else {
						 spell.setDismissible(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setShapeable(false);
					 } else {
						 spell.setShapeable(true);
					 }
					 spell.setSaving_throw(sc.next().replace("\"", ""));
					 spell.setSpell_resistence(sc.next().replace("\"", ""));
					 spell.setDescription(sc.next().replace("\"", ""));
					 sc.next();//skip formated description
					 spell.setSource(sc.next());
					 sc.next();//skip full text
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setVerbal(false);
					 } else {
						 spell.setVerbal(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setSomatic(false);
					 } else {
						 spell.setSomatic(true);
					 }
					 
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setMaterial(false);
					 } else {
						 spell.setMaterial(true);
					 }
					 
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setFocus(false);
					 } else {
						 spell.setFocus(true);
					 }
					 
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 spell.setDivine_focus(false);
					 } else {
						 spell.setDivine_focus(true);
					 }
					 
					 SpellLevel sl = new SpellLevel();
					 //sor	wiz	cleric	druid	ranger	bard	paladin	alchemist	summoner	witch	inquisitor	oracle	antipaladin	magus	adept
					 String intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setSor(-1);
					 } else {
						 sl.setSor(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setWiz(-1);
					 } else {
						 sl.setWiz(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setCleric(-1);
					 } else {
						 sl.setCleric(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setDruid(-1);
					 } else {
						 sl.setDruid(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setRanger(-1);
					 } else {
						 sl.setRanger(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setBard(-1);
					 } else {
						 sl.setBard(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setPaladin(-1);
					 } else {
						 sl.setPaladin(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setAlchemist(-1);
					 } else {
						 sl.setAlchemist(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setSummoner(-1);
					 } else {
						 sl.setSummoner(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setWitch(-1);
					 } else {
						 sl.setWitch(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setInquisitor(-1);
					 } else {
						 sl.setInquisitor(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setOracle(-1);
					 } else {
						 sl.setOracle(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setAntipaladin(-1);
					 } else {
						 sl.setAntipaladin(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setMagus(-1);
					 } else {
						 sl.setMagus(Integer.parseInt(intHolder));
					 }
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setAdept(-1);
					 } else {
						 sl.setAdept(Integer.parseInt(intHolder));
					 }
					 
					 spell.setDeity(sc.next());
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 spell.setSLA_Level(-1);
					 } else {
						 spell.setSLA_Level(Integer.parseInt(intHolder));
					 }
					 spell.setDomain(sc.next().replace("\"", "").split(","));
					 spell.setShort_description(sc.next().replace("\"", ""));
					 //acid	air	chaotic	cold	curse	darkness	death	disease	earth	electricity	emotion	evil	fear	fire	
					 //force	good	language_dependent	lawful	light	mind_affecting	pain	poison	shadow	sonic	water
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setAcid(true);
					 } 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setAir(true);
					 } 	 
					 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setChaotic(true);
					 } 
					 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setCold(true);
					 } 

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setCurse(true);
					 } 

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setDarkness(true);
					 } 

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setDeath(true);
					 } 

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setDisease(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setEarth(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setElectricity(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setEmotion(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setEvil(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setFear(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setFire(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setForce(true);
					 }
				 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setGood(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setLanguage_dependent(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setLawful(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setLight(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setMind_affecting(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setPain(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setPoison(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setShadow(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setSonic(true);
					 }

					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setWater(true);
					 }

					 spell.setLinktext(sc.next().replace("\"", ""));
					 spell.setId(Integer.parseInt(sc.next()));
					 
					 spell.setMaterial_costs(sc.next());
					 spell.setBloodline(sc.next().replace("\"", "").split(","));
					 spell.setPatron(sc.next().replace("\"", "").split(","));
					 spell.setMythic_text(sc.next().replace("\"", ""));
					 spell.setAugmented(sc.next().replace("\"", ""));
					 spell.setMythic(Boolean.parseBoolean(sc.next()));
					 
					 //bloodrager	shaman	psychic	medium	mesmerist	occultist	spiritualist	skald	investigator	hunter
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setBloodrager(-1);
					 } else {
						 sl.setBloodrager(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setShaman(-1);
					 } else {
						 sl.setShaman(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setPsychic(-1);
					 } else {
						 sl.setPsychic(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setMedium(-1);
					 } else {
						 sl.setMedium(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setMesmerist(-1);
					 } else {
						 sl.setMesmerist(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setOccultist(-1);
					 } else {
						 sl.setOccultist(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setSpiritualist(-1);
					 } else {
						 sl.setSpiritualist(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setSkald(-1);
					 } else {
						 sl.setSkald(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setInvestigator(-1);
					 } else {
						 sl.setInvestigator(Integer.parseInt(intHolder));
					 }
					 
					 intHolder = sc.next();
					 if(intHolder == null || intHolder.equals("NULL")) {
						 sl.setHunter(-1);
					 } else {
						 sl.setHunter(Integer.parseInt(intHolder));
					 }
					 spell.setSpellLevel(sl);
					 
					 spell.setHaunt_statistics(sc.next());
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setRuse(true);
					 }
					 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setDraconic(true);
					 }
					 
					 booleanHolder = sc.next();
					 if(!booleanHolder.equals("0")) {
						 spell.setMeditative(true);
					 }
					 break;
					 
				 }
				 spells.add(spell);
				 //System.out.println(sb.toString());
				 line = br.readLine();
				 sc.close();
				 
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	private void loadFeats() {
		feats = new ArrayList<Feat>();
		InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("Feats.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream ));
		try {
			String line = br.readLine();
			//System.out.println("Line:"+line);
			Pattern patt = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			while(line != null) {
				Scanner sc = new Scanner(line).useDelimiter(patt);
				//StringBuffer sb = new StringBuffer();
				Feat feat = new Feat();
				 while (sc.hasNext()) {
					 
					 /*id	name	type	description	prerequisites	prerequisite_feats	benefit	normal	
						 * special	source	fulltext	teamwork	critical	grit	style	performance	racial	
						 * companion_familiar	race_name	note	goal	completion_benefit	multiples	suggested_traits	
						 * prerequisite_skills	panache	betrayal	targeting	esoteric	stare	weapon_mastery	
						 * item_mastery	armor_mastery	shield_mastery	blood_hex	trick
						 */
					 sc.next();
					 String name = sc.next().replace("\"", "");
					 //System.out.println(name);
					 //System.out.println("second Desc:"+desc);
					 feat.setName(name);
					 feat.setType(sc.next().replaceAll("\"", ""));
					 feat.setDescription(sc.next().replaceAll("\"", ""));
					 feat.setPrereq(sc.next().replace("\"", ""));
					 feat.setPrerequisiteFeats(sc.next().replaceAll("\"", ""));
					 feat.setBenefit(sc.next().replaceAll("\"", ""));
					 feat.setNormal(sc.next().replaceAll("\"", ""));
					 feat.setSpecial(sc.next().replaceAll("\"", ""));
					 feat.setSource(sc.next());
					 sc.next();
					 String booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setTeamwork(false);
					 } else {
						 feat.setTeamwork(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setCritical(false);
					 } else {
						 feat.setCritical(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setGrit(false);
					 } else {
						 feat.setGrit(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setStyle(false);
					 } else {
						 feat.setStyle(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setPerformance(false);
					 } else {
						 feat.setPerformance(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setRacial(false);
					 } else {
						 feat.setRacial(true);
					 }
					 sc.next();
					 feat.setRaceName(sc.next());
					 sc.next();
					 feat.setGoal(sc.next());
					 feat.setCompletionBonus(sc.next());
					 
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setMultiples(false);
					 } else {
						 feat.setMultiples(true);
					 }
					 sc.next();
					 feat.setPrerequisiteSkills(sc.next());
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setPanache(false);
					 } else {
						 feat.setPanache(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setBetrayal(false);
					 } else {
						 feat.setBetrayal(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 feat.setTargeting(false);
					 } else {
						 feat.setTargeting(true);
					 }
					 
					 break;
					 
				 }
				 feats.add(feat);
				 //System.out.println(sb.toString());
				 line = br.readLine();
				 sc.close();
				 
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void loadMagicItems() {
		magicItems = new ArrayList<MagicItem>();
		InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("magic_items_full.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream ));
		try {
			String line = br.readLine();
			//System.out.println("Line:"+line);
			line = br.readLine();
			Pattern patt = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			while(line != null) {
				Scanner sc = new Scanner(line).useDelimiter(patt);
				//StringBuffer sb = new StringBuffer();
				MagicItem item = new MagicItem();
				 while (sc.hasNext()) {
					 
					 /* Name	Aura	CL	Slot	Price	Weight	Description	Requirements	Cost	Group	Source	AL	
						 * Int	Wis	Cha	Ego	Communication	Senses	Powers	MagicItems	FullText	
						 * Destruction	MinorArtifactFlag	MajorArtifactFlag	Abjuration	Conjuration	Divination	Enchantment	
						 * Evocation	Necromancy	Transmutation	AuraStrength	WeightValue	PriceValue	CostValue	Languages	
						 * BaseItem	LinkText	id	Mythic	LegendaryWeapon	Illusion	Universal	Scaling*/
					 item.setName(sc.next().replace("\"", ""));
					 System.out.println("Name: "+ item.getName());
					 item.setAura(sc.next().replace("\"", ""));
					 item.setCl(sc.next().replace("\"", ""));
					 item.setSlot(sc.next().replace("\"", ""));
					 item.setPrice(sc.next().replace("\"", ""));
					 item.setWeight(sc.next().replace("\"", ""));
					 item.setDescription(sc.next().replace("\"", ""));
					 item.setRequirements(sc.next().replace("\"", ""));
					 item.setCost(sc.next().replace("\"", ""));
					 item.setGroup(sc.next().replace("\"", ""));
					 item.setSource(sc.next().replace("\"", ""));
					 item.setAlignment(sc.next().replace("\"", ""));
					 item.setIntel(sc.next().replace("\"", ""));
					 item.setWis(sc.next().replace("\"", ""));
					 item.setCha(sc.next().replace("\"", ""));
					 item.setEgo(sc.next().replace("\"", ""));
					 item.setCommunication(sc.next().replace("\"", ""));
					 item.setSenses(sc.next().replace("\"", ""));
					 item.setPowers(sc.next().replace("\"", ""));
					 item.setMagicItems(sc.next().replace("\"", ""));					 
					 sc.next();
					 item.setDestruction(sc.next().replace("\"", ""));
					 
					 String booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setMinorArtifact(false);
					 } else {
						 item.setMinorArtifact(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setMajorArtifact(false);
					 } else {
						 item.setMajorArtifact(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setAbjuration(false);
					 } else {
						 item.setAbjuration(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setConjuration(false);
					 } else {
						 item.setConjuration(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setDivination(false);
					 } else {
						 item.setDivination(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setEnchantment(false);
					 } else {
						 item.setEnchantment(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setEvocation(false);
					 } else {
						 item.setEvocation(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setNecromancy(false);
					 } else {
						 item.setNecromancy(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setTransmutation(false);
					 } else {
						 item.setTransmutation(true);
					 }
					 item.setAuraStrength(sc.next().replace("\"", ""));
					 String stringHolder = sc.next();
					 if(stringHolder.equals("NULL")) {
						 item.setWeightValue(0.0d);
					 } else {
						 item.setWeightValue(Double.parseDouble(stringHolder));
					 }
					 
					 item.setPriceValue(Double.parseDouble(sc.next()));
					 item.setCostValue(Double.parseDouble(sc.next()));
					 item.setLanguages(sc.next().replace("\"", ""));
					 item.setBaseItem(sc.next().replace("\"", ""));
					 sc.next();
					 sc.next();
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setMythic(false);
					 } else {
						 item.setMythic(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setLegendary(false);
					 } else {
						 item.setLegendary(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setIllusion(false);
					 } else {
						 item.setIllusion(true);
					 }
					 booleanHolder = sc.next();
					 if(booleanHolder.equals("0")) {
						 item.setUniversal(false);
					 } else {
						 item.setUniversal(true);
					 }
					 
					 break;
					 
				 }
				 magicItems.add(item);
				 //System.out.println(sb.toString());
				 line = br.readLine();
				 sc.close();
				 
				}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
