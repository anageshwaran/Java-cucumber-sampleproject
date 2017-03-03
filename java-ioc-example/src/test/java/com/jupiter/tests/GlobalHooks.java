package com.jupiter.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.planittesting.ioc.ObjectContainer;

import cucumber.api.java.Before;

public class GlobalHooks {
	
    private static boolean globalInit = false;
    private static ObjectContainer globalContainer;
    private static WebDriver globalDriver;
    
    public GlobalHooks(ObjectContainer container) {
    	globalContainer = container;
    }
    
    /*
	 * this thread is used to quit the driver before the jvm shuts down
	 */
	private static final Thread shutdownThread = new Thread() {
		@Override
		public void run() {
			globalDriver.quit();
		}
	};
	
    @Before
    public void beforeAll() {
        if(!globalInit) {
        	initializeDriver();
    		Runtime.getRuntime().addShutdownHook(shutdownThread);
        	globalInit = true;
        }
        globalDriver.manage().deleteAllCookies();
        
    }

	private void initializeDriver() {
		globalDriver = new ChromeDriver(); //command line property
		globalDriver.manage().window().maximize();
		globalDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		globalDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		globalDriver.get("http://jupiter.cloud.planittesting.com/");
		globalContainer.registerAs(globalDriver, WebDriver.class);
	}

}

