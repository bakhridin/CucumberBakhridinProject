package com.cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.cucumber.utils.CommonMethods;
import com.cucumber.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Depending_ExperienceSteps extends CommonMethods {

	@Given("user logged in with valid credentials")
	public void user_logged_in_with_valid_credentials() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

	}

	@Given("user navigates to employee list")
	public void user_navigates_to_employee_list() {
		employeeListPage.navigateToEmployeeList();
	}

	@Given("user searches for specific id and clicks on {string}")
	public void user_searches_for_specific_id_and_clicks_on(String Id) {
		sleep(1);
		sendText(employeeListPage.searchId, Id);
		click(employeeListPage.searchBtn);
		findByIdorNameAndClick(employeeListPage.tableRows, Id);

	}

	@Given("user clicks on dependents")
	public void user_clicks_on_dependents() {
		click(employeeListPage.dependentsBox);
	}

	@When("user adds {string},{string} and {string} of dependents")
	public void user_adds_and_of_dependents(String Name, String Relationship, String DateofBirth) {
		sleep(1);
		jsClick(assignedDependentsPage.btnAddDep);
		sendText(assignedDependentsPage.dependentName, Name);
		selectDdvalue(assignedDependentsPage.selectRelationship, Relationship);
		assignedDependentsPage.dependentdateOfBirth.clear();
		assignedDependentsPage.dependentdateOfBirth.sendKeys(DateofBirth, Keys.ENTER);
		click(assignedDependentsPage.btnSaveDependent);
	}

	@Then("user verify that dependent has been added")
	public void user_verify_that_dependent_has_been_added() {
		waitForVisibility(assignedDependentsPage.addSuccessfully);
		String expectedMsg = "Successfully Saved\n" + "Close";
		String actualMsg = assignedDependentsPage.addSuccessfully.getText();
		Assert.assertEquals(expectedMsg, actualMsg);
	}

	@Given("user clicks on qualifications")
	public void user_clicks_on_qualifications() {
		click(workExperiencepage.Qualifications);
	}

	@When("user adds {string},{string},{string},{string},{string} of work experience")
	public void user_adds_of_work_experience(String Company, String Jobtitle, String From, String To, String Comment) {
		sleep(1);
		jsClick(workExperiencepage.addWorkExp);
		sendText(workExperiencepage.CompanyName, Company);
		sendText(workExperiencepage.jobtitle, Jobtitle);
		sendText(workExperiencepage.expFromDate, From);
		sendText(workExperiencepage.expTodate, To);
		sendText(workExperiencepage.expComment, Comment);
		click(workExperiencepage.btnWorkExpSave);
	}

	@Then("user verify that work experience has been added")
	public void user_verify_that_work_experience_has_been_added() {
		waitForVisibility(assignedDependentsPage.addSuccessfully);
		String expectedMsg = "Successfully Saved\n" + "Close";
		String actualMsg = assignedDependentsPage.addSuccessfully.getText();
		Assert.assertEquals(expectedMsg, actualMsg);
	}

}
