package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;
import com.cucumber.utils.ConfigsReader;

public class AddEmployeePage extends CommonMethods {
	
	
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
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='photofile']")
	public WebElement uploadPhoto;
	
	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement saveButton;
	
	@FindBy(id="profile-pic")
	public WebElement profilePic;
	
	@FindBy(id="chkLogin")
	public WebElement credentialButton;
	
	@FindBy(id="user_name")
	public WebElement credenUserName;
	
	@FindBy(id="user_password")
	public WebElement credenUserPasswor;
	
	@FindBy(id="re_password")
	public WebElement confirmCredenPassword;
	
	@FindBy(xpath="//span[@for='firstName']")
	public WebElement nameRequiredMsg;
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement lastNameRequiredMsg;
	
	@FindBy(id="employeeId")
	public WebElement employeeId;
	
	
	
	
	
	
	
	public AddEmployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void createEmpLoginCR() {
		sendText(credenUserName, ConfigsReader.getProperty("empUserName"));
		sendText(credenUserPasswor, ConfigsReader.getProperty("empPassword"));
		sendText(confirmCredenPassword, ConfigsReader.getProperty("empPassword"));
		click(saveButton);
	}
	
	
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmp);
	}


}
