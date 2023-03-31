package com.design.principles.openclose;

public interface ConfigProfile {
	
	public String getProperty(PropertyType propertyKey);
	public String getProperty(String  propertyKey);
	
}
