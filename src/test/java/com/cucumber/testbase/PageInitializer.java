package com.cucumber.testbase;

import com.cucumber.pages.AddEmployeePage;
import com.cucumber.pages.AssignedDependentsPage;
import com.cucumber.pages.DashboardPage;
import com.cucumber.pages.EmployeeListPage;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.WorkExperiencePage;

public class PageInitializer extends BaseClass {
	
	
	public static LoginPage login;
	public static DashboardPage dashboard;
	public static EmployeeListPage employeeListPage;
	public static AddEmployeePage  addEmployeePage;
	public static AssignedDependentsPage assignedDependentsPage;
	public static WorkExperiencePage workExperiencepage;
	
	
	
	
	
	
	
	
	
	public static void initialize() {
		
		login=new LoginPage();
		dashboard=new DashboardPage();
		employeeListPage=new EmployeeListPage();
		addEmployeePage=new AddEmployeePage();
		assignedDependentsPage=new AssignedDependentsPage();
		workExperiencepage=new WorkExperiencePage();
		
		
	}

}
