package ru.kontur.kontest.web.services;

import java.io.InputStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.storages.Storage;
import ru.kontur.kontest.words.WordWithFrequency;

public class StorageService implements InitializingBean {

	private Storage storage;
	
	public Storage getStorage() {
		HashMapStorage hashMapStorage = new HashMapStorage(10, 10);
		
		hashMapStorage.put(new WordWithFrequency("kare", 10));
		hashMapStorage.put(new WordWithFrequency("kanojo", 20));
		hashMapStorage.put(new WordWithFrequency("karetachi", 10));
		hashMapStorage.put(new WordWithFrequency("korosu", 7));
		hashMapStorage.put(new WordWithFrequency("sakura", 3));
		
		return hashMapStorage;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Resource resource = new ClassPathResource("test.in");
		try(InputStream resourceInputStream = resource.getInputStream()) {
			System.out.println(resourceInputStream.available());
		}
	}

}
