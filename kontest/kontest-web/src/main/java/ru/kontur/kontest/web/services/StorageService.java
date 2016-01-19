package ru.kontur.kontest.web.services;

import ru.kontur.kontest.storages.HashMapStorage;
import ru.kontur.kontest.storages.Storage;

public class StorageService {

	public Storage getStorage() {
		return new HashMapStorage(10, 10);
	}

}
