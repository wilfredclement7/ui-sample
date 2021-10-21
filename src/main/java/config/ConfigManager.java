package config;

import java.io.FileReader;
import java.util.Properties;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

public class ConfigManager {

	static String env = "qa";
	static Properties prop = new Properties();
	public static boolean initialized = false;

	public static void load() {
		initialized = true;
		try {
			prop.load(new FileReader("src/main/java/config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getConfig(String key) {
		String val = prop.getProperty(key);
		if(val !=null) {
			return val.trim();
		}
		return "";
	}

}
