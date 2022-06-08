package com.destinationegalite.backendserver.application.service.character;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.domain.Character;
import com.destinationegalite.backendserver.domain.CharacterRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

	private CharacterRepository characterRepository;
	private CharacterFactory characterFactory;

	public CharacterService(CharacterRepository characterRepository, CharacterFactory characterFactory) {

		this.characterRepository = characterRepository;
		this.characterFactory = characterFactory;
	}

	public synchronized void create(CharacterDto characterDto) {
		Character character = createCharacter(characterDto);
		save(character);
	}

	public synchronized List<CharacterDto> getAllCharacters() {
		List<Character> characters = findAll();
		return convertingCharacterForUI(characters);
	}
	public synchronized CharacterDto getCharacter(String characterName) throws Exception{
		Character character = findCharacterByName(characterName);
		return convertingToDto(character);
	}

	private CharacterDto convertingToDto(Character character) {
		return characterFactory.create(character);
	}

	private Character findCharacterByName(String characterName) throws Exception{
		return characterRepository.findCharacterByName(characterName);
	}

	private void save(Character character) {
		characterRepository.save(character);
	}

	private Character createCharacter(CharacterDto characterDto) {
		return characterFactory.create(characterDto);
	}

	private List<CharacterDto> convertingCharacterForUI(List<Character> characters) {
		return characterFactory.retrieveList(characters);
	}

	private List<Character> findAll() {
		return characterRepository.findAll();
	}
}
