package com.destinationegalite.backendserver.application.service.character;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.domain.Character;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterFactory {
	public Character create(CharacterDto characterDto) {

		String name = characterDto.getName();
		String country = characterDto.getCountry();
		int age = characterDto.getAge();
		List<String> difficulties = characterDto.getDifficulties();
		List<String> opportunities = characterDto.getOpportunities();

		return new Character(name,country,age,difficulties,opportunities);
	}

	public CharacterDto create(Character character){
		CharacterDto characterDto = new CharacterDto();

		characterDto.setName(character.getName());
		characterDto.setAge(character.getAge());
		characterDto.setCountry(character.getCountry());
		characterDto.setDifficulties(character.getDifficulties());
		characterDto.setOpportunities(character.getOpportunities());

		return characterDto;
	}


	public List<CharacterDto> retrieveList(List<Character> characters){

		return characters.stream().map(this::create).collect(Collectors.toList());
	}


}
