package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

public class WorkExperiencePage extends CommonMethods {
	
	@FindBy(xpath="//ul[@id='sidenav']/li[10]/a")
	public WebElement Qualifications;
	
	@FindBy(id="addWorkExperience")
	public WebElement addWorkExp;
	
	@FindBy(id="experience_employer")
	public WebElement CompanyName;
	
	@FindBy(id="experience_jobtitle")
	public WebElement jobtitle;
	
	@FindBy(id="experience_from_date")
	public WebElement expFromDate;
	
	@FindBy(id="experience_to_date")
	public WebElement expTodate;
	
	@FindBy(id="experience_comments")
	public WebElement expComment;
	
	@FindBy(id="btnWorkExpSave")
	public WebElement btnWorkExpSave;
	
	
	
	public WorkExperiencePage() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
