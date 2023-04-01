package com.design.principles.openclose;

import com.design.patterns.singletonUtil.PropertiesUtil;

public class ConfigProfilePropertyFile implements ConfigProfile{

	@Override
	public String getProperty(PropertyType propertyKey) {
		return PropertiesUtil.getProperty(propertyKey.toString());
	}

	@Override
	public String getProperty(String propertyKey) {
		return PropertiesUtil.getProperty(propertyKey);
	}

}
