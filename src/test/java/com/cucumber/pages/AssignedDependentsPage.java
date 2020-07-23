package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

public class AssignedDependentsPage extends CommonMethods {
	
	@FindBy(id="btnAddDependent")
	public WebElement btnAddDep;
	
	@FindBy(id="dependent_name")
	public WebElement dependentName;
	
	@FindBy(id="dependent_relationshipType")
	public WebElement selectRelationship;
	
	@FindBy(id="dependent_dateOfBirth")
	public WebElement dependentdateOfBirth;
	
	@FindBy(id="btnSaveDependent")
	public WebElement btnSaveDependent;
	
	@FindBy(xpath="//div[@class='message success fadable']")
	public WebElement addSuccessfully;
	
	public AssignedDependentsPage() {
		PageFactory.initElements(BaseClass.driver,this);
	}

}
