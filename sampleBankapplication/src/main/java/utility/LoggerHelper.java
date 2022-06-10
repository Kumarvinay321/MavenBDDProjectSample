package utility;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.ParaBank.managers.WebDriverManager;

//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

public class LoggerHelper {
	static WebDriverManager webDriverManager;
	static WebDriver driver;

	private static boolean root=false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("configs//log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}

	/*
	 * public static void main(String[] args) { Logger log =
	 * LoggerHelper.getLogger(LoggerHelper.class); log.info("I am test");
	 * log.info("I am test"); log.info("I am test");
	 * 
	 * }
	 */
	/*
	 * public static WebDriver initialzeDriver() {
	 * 
	 * webDriverManager = new WebDriverManager(); driver =
	 * webDriverManager.getDriver();
	 * 
	 * return driver;
	 * 
	 * }
	 */
}
