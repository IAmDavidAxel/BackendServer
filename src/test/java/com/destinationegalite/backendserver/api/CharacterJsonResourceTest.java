package com.destinationegalite.backendserver.api;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.application.service.character.CharacterService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CharacterJsonResourceTest {

	private static final String A_NAME = "Paul";
	private CharacterDto characterDto;
	private CharacterJsonResource characterJsonResource;
	@Mock
	private CharacterService characterService;

	@Before
	public  void setUp(){
		characterJsonResource = new CharacterJsonResource(characterService);
	}

	@Test
	public void whenCreatingANewCharacterIsSuccessful_thenDelegateToService() throws Exception{

		characterJsonResource.create(characterDto);

		verify(characterService).create(characterDto);
	}

	@Test
	public void whenFetchingAllCharacters_thenDelegateToService()throws Exception{
		characterJsonResource.getAllCharacters();

		verify(characterService).getAllCharacters();
	}

	@Test
	public void whenFetchingOneCharacter_thenDelegateToService()throws Exception{
		characterJsonResource.getCharacter(A_NAME);

		verify(characterService).getCharacter(A_NAME);

	}

}
