package com.butlerpress.dict;

import junit.framework.TestCase;

public class DictionaryTestCase extends TestCase {
	
	public void testLookup() {
		String word = "shrub";
		boolean exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
		
		word = "puppy";
		exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
		
		word = "fence";
		exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
		
		word = "Luke";
		exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
		
		word = "with";
		exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
		
		word = "zoot suit";
		exists = Dictionary.lookup(word);
		assertTrue(word + " should exist in dictionary", exists);
	}
	
	public void testLookupNotAWord() {
		String word = "fasdfff";
		boolean exists = Dictionary.lookup(word);
		assertFalse(word + " should not exist in dictionary", exists);
	}

	public void testLookupNull() {
		String word = null;
		boolean exists = Dictionary.lookup(word);
		assertFalse(word + " should not exist in dictionary", exists);
	}

	public void testLookupEmpty() {
		String word = "";
		boolean exists = Dictionary.lookup(word);
		assertFalse("Empty string should not exist in dictionary", exists);
	}

	public void testRandomWord() {
		String randomWord = Dictionary.getRandomWord();
		assertNotNull("Random word should return word", randomWord);
		assertTrue("Word should be in word list", Dictionary.words.contains(randomWord));
		
		String randomWord2 = Dictionary.getRandomWord();
		assertNotNull("Random word should return word", randomWord2);
		assertTrue("Next random word should be different than last", !randomWord.equals(randomWord2));
		assertTrue("Word should be in word list", Dictionary.words.contains(randomWord2));
	}

	public void testgetRandomWordTermCommonNameOrConnector() {
		String randomWord = Dictionary.getRandomWordTermCommonNameOrConnector();
		assertNotNull("getRandomWordTermCommonNameOrConnector should return word", randomWord);
		assertTrue("Word should be in word list", Dictionary.allWords.contains(randomWord));

		String randomWord2 = Dictionary.getRandomWordTermCommonNameOrConnector();
		assertNotNull("Random word should return word", randomWord2);
		assertTrue("getRandomWordTermCommonNameOrConnector should be different than last", !randomWord.equals(randomWord2));
		assertTrue("Word should be in word list", Dictionary.allWords.contains(randomWord2));
	}

	public void testGetRandomProperName() {
		String randomWord = Dictionary.getRandomProperName();
		assertNotNull("getRandomProperName should return word", randomWord);
		assertTrue("Word should be in word list", Dictionary.properNames.contains(randomWord));

		String randomWord2 = Dictionary.getRandomProperName();
		assertNotNull("Random word should return word", randomWord2);
		assertTrue("getRandomProperName should be different than last", !randomWord.equals(randomWord2));
		assertTrue("Word should be in word list", Dictionary.properNames.contains(randomWord2));
	}

	
}
