package com.design.patterns.singletonUtil;

import com.design.principles.openclose.ConfigProfile;

public class UrlResolver 
{

	private ConfigProfile config;
	static UrlResolver urlResolver;
	
	//private constructor to restrict object creation
	private UrlResolver(ConfigProfile config)
	{
		this.config=config;
	}
		
	public static String getUrl(ConfigProfile config,String key) {
		if (urlResolver==null) 
		{
			urlResolver= new UrlResolver(config);
		}
		return urlResolver.config.getProperty(key);
	}	
}
