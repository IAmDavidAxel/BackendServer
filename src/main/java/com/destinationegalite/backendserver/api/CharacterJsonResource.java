package com.destinationegalite.backendserver.api;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.application.service.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterJsonResource {


	private CharacterService characterService;

	public CharacterJsonResource(CharacterService characterService) {

		this.characterService = characterService;
	}


	@PostMapping("/characters")
	public ResponseEntity<Object> create(@RequestBody CharacterDto characterDto) throws Exception{

		characterService.create(characterDto);

		return new ResponseEntity<>("Character is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("/find-all")
	public ResponseEntity<List<CharacterDto>> getAllCharacters() throws Exception{

		List<CharacterDto> characters = characterService.getAllCharacters();

		return new ResponseEntity<>(characters, HttpStatus.OK);
	}


	@GetMapping("/find/{aName}")
	public ResponseEntity<CharacterDto> getCharacter(@PathVariable String aName) throws Exception{

		CharacterDto characterDto = characterService.getCharacter(aName);

		return new ResponseEntity<>(characterDto,HttpStatus.OK);
	}
}
