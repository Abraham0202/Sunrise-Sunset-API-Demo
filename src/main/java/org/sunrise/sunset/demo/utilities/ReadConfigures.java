package org.sunrise.sunset.demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigures {

	 private static Properties properties;

	    public ReadConfigures() {
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }

	    static {
	        try {
	            String path = "configure.properties";
	            FileInputStream stream = new FileInputStream(path);
	            properties = new Properties();
	            properties.load(stream);
	            stream.close();
	        } catch (IOException var2) {
	            var2.printStackTrace();
	        }

	    }
}
