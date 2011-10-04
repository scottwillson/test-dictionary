package com.butlerpress.dict;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	private static boolean isWordListInitialized = false;
	static List words = new ArrayList();
	static List terms = new ArrayList();
	static List connectives = new ArrayList();
	static List properNames = new ArrayList();
	static List allWords = new ArrayList();

	/**
	 * @param word
	 * @return true if word exists in Dictionary
	 */
	public static boolean lookup(String word) {
		init();
		if (allWords.contains(word)) {
			return true;
		}
		return false;
	}

	/**
	 * @return Random word from "standard" one-word list
	 */
	public static String getRandomWord() {
    init();
		int index = (int) (Math.random() * words.size());
		return (String) words.get(index);
	}

	/**
	 * @return Random word. Include all words: term, common names, and connectors
	 */
	public static String getRandomWordTermCommonNameOrConnector() {
    init();
		int index = (int) (Math.random() * allWords.size());
		return (String) allWords.get(index);
	}

	public static String getRandomProperName() {
    init();
		int index = (int) (Math.random() * properNames.size());
		return (String) properNames.get(index);
	}

	/**
	 * Read word list from jar. Does nothing if list already read
	 * @throws  
	 * @throws FileNotFoundException 
	 */
	static void init()  {
		if (!isWordListInitialized) {
			words = read("/web2");
			allWords.addAll(words);
			terms = read("/web2a");
			allWords.addAll(terms);
			connectives = read("/connectives");
			allWords.addAll(connectives);
			properNames = read("/propernames");
			allWords.addAll(properNames);
			isWordListInitialized = true;
		}
	}

	/**
	 * @param filename -- path to word list in jar
	 * @return List of words
	 */
	static List read(String fileName) {
		List list = new ArrayList();
		try {
			InputStream inputStream = Dictionary.class.getResourceAsStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), 100000);
			String line = "";
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not find '" + fileName + "'. " + e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not read '" + fileName + "'. " + e);
		}
	}
}
