package com.destinationegalite.backendserver.application.service.character;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.domain.Character;
import com.destinationegalite.backendserver.domain.CharacterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceTest {

	private CharacterService characterService;
	@Mock
	private CharacterRepository characterRepository;
	private CharacterDto characterDto;
	private Character character;
	@Mock
	private CharacterFactory characterFactory;


	@Before
	public void setUp()throws Exception{
		characterService = new CharacterService(characterRepository,characterFactory);
		willReturn(character).given(characterFactory).create(characterDto);
	}

	@Test
	public void whenCreatingANewCharacter_thenDelegateSavingToRepo() throws Exception{
		characterService.create(characterDto);

		verify(characterRepository).save(character);
	}

	@Test
	public void whenCreatingANewCharacter_thenDelegateCreationToFactory()throws Exception{
		characterService.create(characterDto);

		verify(characterFactory).create(characterDto);
	}

}
