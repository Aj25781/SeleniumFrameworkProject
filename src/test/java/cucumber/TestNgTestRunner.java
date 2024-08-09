package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\Public\\Java Projects\\SeleniumFrameworkDesign\\src\\test\\java\\cucumber\\Standalonetest.feature",glue="stepDefination",monochrome=true,plugin= {"html:reportHtml/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{
	
	

}
