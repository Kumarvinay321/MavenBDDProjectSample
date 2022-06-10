package runners;
import java.io.File;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.ParaBank.managers.FileReaderManager;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/features/UpdateContactInfo.feature",
		glue= {"stepDefinitions"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome =true,
		dryRun = true
		)
public class TestRunner {	
	
	  @AfterClass
	  public static void writeExtentReport() {
	  Reporter.loadXMLConfig(new
	  File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())
	  ); }
	 
	 
}


