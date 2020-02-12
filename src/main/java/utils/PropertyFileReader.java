package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

	public static Properties getProperty(String path, String filename) {
		Properties prop = null;
		InputStream in;
		try {
			prop = new Properties();
			in = new FileInputStream(System.getProperty("user.dir") + path + filename);
			prop.load(in);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}