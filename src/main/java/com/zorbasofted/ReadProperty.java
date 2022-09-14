package com.zorbasofted;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	public Properties readFile() throws Exception {

		File file = new File(
				"C:\\Users\\dell\\eclipse-workspace\\Automation\\src\\main\\resources\\Webelements.properties");

		FileReader fileReader = new FileReader(file);

		Properties p = new Properties();
		p.load(fileReader);
		// just for example -- System.out.println(p.get("name"));
		return p;
		

	}
}
