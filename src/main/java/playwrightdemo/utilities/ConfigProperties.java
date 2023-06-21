package playwrightdemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	public static FileInputStream file;
	public static Properties props;
	
	public static String readConfigProperties(String filename, String key)
	{
		try {
			file = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		props = new Properties();
		try {
			props.load(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return props.getProperty(key);
	}

}
