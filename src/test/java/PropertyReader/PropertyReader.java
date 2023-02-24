package PropertyReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Base.BaseClass;

public class PropertyReader {

	Properties properties = new Properties();
	
	public PropertyReader() throws IOException {
	try {
	BufferedReader  reader = new BufferedReader(new FileReader("./Config.properties"));
	properties.load(reader);
	reader.close();
	
	}catch(FileNotFoundException e) {
		e.printStackTrace();	
	}
	}
	
	public String getURL() throws Exception {
		String url = properties.getProperty("url");
		if(url!=null)
			return url;
		throw new Exception("Error");
		
	}
	
}
