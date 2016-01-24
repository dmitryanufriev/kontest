package ru.kontur.kontest.web.controller;

import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.web.services.StorageService;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/api/autocomplete")
public class AutocompleteController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  @ResponseBody
  public String[] noPrefix() {
    return new String[0];
  }

  @RequestMapping(value = "{prefix}", method = RequestMethod.GET)
  @ResponseBody
  public String[] findWordsByPrefix(@PathVariable String prefix) {
    Storage storage = storageService.getStorage();

    Collection<WordWithFrequency> foundWords = storage.searchWordsBy(new Prefix(prefix));

    ArrayList<String> words = new ArrayList<>(foundWords.size());
    for (WordWithFrequency word : foundWords) {
      words.add(word.toString());
    }

    return words.toArray(new String[0]);
  }

  @Autowired private StorageService storageService;
}
