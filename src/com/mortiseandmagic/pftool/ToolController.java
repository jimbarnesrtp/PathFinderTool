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

import com.mortiseandmagic.pftool.model.Spell;

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
	
	private void loadSpells() {
		spells = new ArrayList<Spell>();
		InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("spell_full.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream ));
		try {
			String line = br.readLine();
			System.out.println("Line:"+line);
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
					 String name = sc.next();
					 System.out.println(name);
					 //System.out.println("second Desc:"+desc);
					 spell.setName(name);
					 spell.setSchool(sc.next());
					 spell.setSubschool(sc.next());
					 spell.setDescriptor(sc.next());
					 sc.next();
					 spell.setCasting_time(sc.next());
					 String comps = sc.next();
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
					 spell.setArea(sc.next());
					 
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
