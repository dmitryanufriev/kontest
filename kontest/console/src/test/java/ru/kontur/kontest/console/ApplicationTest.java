package ru.kontur.kontest.console;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.*;
import org.junit.rules.Timeout;

public class ApplicationTest {

	@Rule
	public Timeout tenSeconds = new Timeout(10000);
	
	private static final String FILE_NAME = "test.in";
	private InputStream in;

	@Before
	public void setUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		in = classLoader.getResourceAsStream(FILE_NAME);
	}
	
	@After
	public void tearDown() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void acceptanceTest() {
		Application application = new Application();
		
		try {
			application.execute(in, new ByteArrayOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
