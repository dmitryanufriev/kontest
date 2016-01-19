package ru.kontur.kontest.web.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.web.controller.exceptions.ResourceNotFoundException;
import ru.kontur.kontest.web.services.StorageService;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

@Controller
@RequestMapping("/api/autocomplete")
public class AutocompleteController {

	@Autowired
	private StorageService storageService;
	
	@RequestMapping(value = "{prefix}", method = RequestMethod.GET)
	public @ResponseBody String[] findWordsByPrefix(@PathVariable String prefix) {
		Storage storage = storageService.getStorage();
		
		Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix(prefix));
		
		if (foundWords.size() < 1) {
			throw new ResourceNotFoundException();
		}
		
		ArrayList<String> words = new ArrayList<>(foundWords.size());
		for (WordWithFrequency word : foundWords) {
			words.add(word.toString());
		}
		
		return words.toArray(new String[0]);
	}
	
}
