package utils;

import pageObjects.PageObjectManager;

//Variable inside this class will share all its variables across project -> this is with use of picocontainer
//We need to create a constructor inside all the stepdefs classes and pass the object of this class.
public class TestContextSetup {
//	public WebDriver driver;
	public String homePageProductName, landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils generic;
	
	public TestContextSetup() {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webDriverManager());
		generic = new GenericUtils(testBase.webDriverManager());
	}
}
