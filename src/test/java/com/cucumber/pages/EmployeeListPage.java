package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empListBtn;
	
	@FindBy(id="empsearch_id")
	public WebElement searchId;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr")
	public List<WebElement> tableRows;
	
	
	@FindBy(id="empsearch_employee_name_empName")
	public WebElement empName;
	
	
	@FindBy(id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='12746']")
	public WebElement Id;
	
	@FindBy(xpath="//ul[@id='sidenav']/li[4]/a")
	public WebElement dependentsBox;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public EmployeeListPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToEmployeeList() {
		jsClick(PIM);
		jsClick(empListBtn);
		
	}

}
