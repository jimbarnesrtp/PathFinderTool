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
import com.mortiseandmagic.pftool.model.Spell;
import com.mortiseandmagic.pftool.model.SpellLevel;

@Controller
public class ToolController {
	
	private List<Spell> spells = null;
	
	@RequestMapping(value = "/GetSpells", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
	public ResponseEntity<List<Spell>> getOfferings() {
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
						 sl.setBard(Integer.parseInt(intHolder));
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
	

}
