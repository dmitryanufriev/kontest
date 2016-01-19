package ru.kontur.kontest.web.services;

import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import ru.kontur.kontest.io.InputReader;
import ru.kontur.kontest.io.listeners.TestDataListener;
import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.words.Prefix;
import ru.kontur.kontest.words.WordWithFrequency;

public class StorageService implements InitializingBean {

	private Storage storage;
	
	public Storage getStorage() {
		return storage;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Resource resource = new ClassPathResource("test.in");
		try(InputStream inputStream = resource.getInputStream()) {
			InputReader inputReader = new InputReader();
			inputReader.readFrom(inputStream, new TestDataListener() {
				
				@Override
				public void wordsCount(int count) {
					storage = new HashMapStorage(count, 10);					
				}
				
				@Override
				public void prefixesCount(int count) {
				}
				
				@Override
				public void nextWord(WordWithFrequency wordWithFrequency) {
					storage.put(wordWithFrequency);
				}
				
				@Override
				public void nextPrefix(Prefix prefix) {
				}
			});
		}
	}

}
