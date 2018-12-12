package com.example.demo.utils;



public class Constants {
	
	public static PropertiesLoader PROPERTIES_LOADER = new PropertiesLoader("classpath:/setup.properties");
	
	public static String MODE = PROPERTIES_LOADER.getProperty("mode", "development");
	
	static {
		PROPERTIES_LOADER.setProperties("classpath:/setup.properties", "classpath:/setup." + MODE + ".properties");
		PROPERTIES_LOADER.setReload(true);
	}
	
	public static final Integer CACHE_MEMCACHED_TIMEOUT = PROPERTIES_LOADER.getInteger("cache.memcached.timeout", 300);
	
	public static final Integer MAN = 1;
	
	public static final Integer WOMAN = 2;
	
	public static final String MOBILE_REGISTER = "register";
	
	public static final String MOBILE_UPDATE = "update";
	
	public static final String APP_TT = "1";
	
	public static final String APP_BOSS = "9";
	
	
//	public static final String MESSAGE_ACTIVATE_ADDRESS = propertiesLoader.getProperty("message.activate.url");
	
	public static final Integer MESSAGE_SCHEDULED_DELAY = PROPERTIES_LOADER.getInteger("message.scheduled.delay", 5);
	
	public static final int ENABLE = 1;
	
	public static final int DISABLE = 0;
	
	public static final int ACTIVATED = 1;
	
	public static final int NOT_ACTIVATED = 0;

	public static final String APPID_MSG=PROPERTIES_LOADER.getProperty("message.sender.appid12.msg");
	public static final Integer MESSAGE_THREADNUM = PROPERTIES_LOADER.getInteger("message.sender.threadnum");
	public static final String MESSAGE_SPCODE = PROPERTIES_LOADER.getProperty("message.sender.spcode");
	public static final String MESSAGE_SEND_URL = PROPERTIES_LOADER.getProperty("message.sender.url");
	public static final String MESSAGE_ACCOUNT = PROPERTIES_LOADER.getProperty("message.sender.account");
	public static final String MESSAGE_PASSWORD = PROPERTIES_LOADER.getProperty("message.sender.password");
//	public static final String MESSAGE_MSG = PROPERTIES_LOADER.getProperty("message.sender.msg");
	public static final String MESSAGE_CLAZZ_LOCATION = PROPERTIES_LOADER.getProperty("message.sender.storage");
	
	public static String MESSAGE_SENDER_CLAZZ = PROPERTIES_LOADER.getProperty("message.sender.clazz");

	public static int MASTER_STATUS_FULL = 0xffff;
	public static int MASTER_STATUS_VIP_MASTER = 0x0001;

	
}
