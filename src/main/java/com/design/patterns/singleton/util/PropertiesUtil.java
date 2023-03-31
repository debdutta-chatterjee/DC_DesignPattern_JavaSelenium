package com.design.patterns.singleton.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil 
{

	private static Properties prop;
	
	//private constructor to restrict object creation
	private PropertiesUtil()
	{
		prop= new Properties();
		this.loadProperty();
	}
	
	private void loadProperty()
	{
		try (FileInputStream fis=  new FileInputStream(new File("./Config.properties"))){
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//properties can be retrieved using this method
	public static String getProperty(String key) {
		if (prop==null) 
		{
			new PropertiesUtil();
		}
		return prop.getProperty(key);
	}	
}
