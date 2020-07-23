package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

public class DashboardPage extends CommonMethods {
	

	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath = "//div[@id='branding']/a/img")
	public WebElement logo;
	
	@FindBy(xpath="//b[text()='PIM']")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(xpath="//label[text()='Full Name']")
	public WebElement nameDisplayed;
	
	@FindBy(xpath="//label[text()='Employee Id']")
	public WebElement employIdDisplayed;
	
	@FindBy(xpath="//label[text()='Photograph']")
	public WebElement photoDisplayed;
	
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='photofile']")
	public WebElement uploadPhoto;
	
	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement saveButton;
	
	@FindBy(id="profile-pic")
	public WebElement profilePic;
	
	@FindBy(xpath="//div[@class='menu']/ul/li")
	public List<WebElement> dashMenu;
	
	
	public DashboardPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmp);
	}

}
