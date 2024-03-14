package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropReader {

	public static String getPropertyByKey(String key) {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"src\\test\\resources\\global.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = prop.getProperty(key);
		if (StringUtils.isEmpty(value)) {
			System.out.println("This " + key + " doesn't have any value.");
		}
		return value;
	}
}
