package com.destinationegalite.backendserver.application.service.character;

import com.destinationegalite.backendserver.api.dto.CharacterDto;
import com.destinationegalite.backendserver.domain.Character;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class CharacterFactoryTest {

	private static final String A_NAME = "jojo";
	private static final String A_COUNTRY = "France";
	private static final int AN_AGE = 18;
	private static final List<String> DIFFICULTIES = new ArrayList<>();
	private static final List<String> OPPORTUNITIES = new ArrayList<>();
	;
	private CharacterFactory characterFactory;

	private CharacterDto characterDto;

	private Character character;

	@Before
	public void setUp()throws Exception{
		setUpCharacter();
		setUpCharacterDto();
		characterFactory = new CharacterFactory();
	}

	private void setUpCharacterDto() {
		characterDto.setName(A_NAME);
		characterDto.setCountry(A_COUNTRY);
		characterDto.setAge(AN_AGE);
		characterDto.setDifficulties(DIFFICULTIES);
		characterDto.setOpportunities(OPPORTUNITIES);
	}

	private void setUpCharacter() {

	}

	@Test
	public void whenCreatingACharacter_thenAllValuesAreEqual()throws Exception{

		Character characterFromFactory = characterFactory.create(characterDto);

		assertEquals(characterFromFactory.getName(),characterDto.getName());
		assertEquals(characterFromFactory.getCountry(),characterDto.getCountry());
		assertEquals(characterFromFactory.getAge(),characterDto.getAge());
		assertEquals(characterFromFactory.getDifficulties().get(0),characterDto.getDifficulties().get(0));
		assertEquals(characterFromFactory.getOpportunities().get(0),characterDto.getOpportunities().get(0));
	}
}
