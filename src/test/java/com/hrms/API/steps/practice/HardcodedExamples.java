package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

/**
 * import JUnite packages
 */
import org.junit.Assert;
import org.junit.Test;

/**
 * Rest assured static packages
 */
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

//import.org.apache.hc.core5.http.ContentType;

/**
 * This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will execute @Test
 * annotation in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {

	/**
	 * Rest Assured
	 * 
	 * given - prepare your request when - you are making the call to the endpoint
	 * then - validating
	 * 
	 * @param args
	 */

	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg0OTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTY5NywidXNlcklkIjoiNDc3In0.0DSXdzd7O0-g2O8G9ZsU7mn4A8hfzzhIj88z-piG2Jc";
	static String employeeID;

	public void sampleTestNotes() {

		/**
		 * BaseURI for all calls
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**
		 * JWT required for all calls - expires every 12 hours
		 */
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg0OTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTY5NywidXNlcklkIjoiNDc3In0.0DSXdzd7O0-g2O8G9ZsU7mn4A8hfzzhIj88z-piG2Jc";

		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16516A");// .log().all();

		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response prettyPrint() method converts JSON object into
		 * String and prints - no need to SOP (System.out.println())
		 */
		getOneEmployeeResponse.prettyPrint();
		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPOSTcreateEmployee() {

		/**
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\n" + "  \"emp_firstname\": \"IsmoilJON\",\n" + "  \"emp_lastname\": \"Xojaev\",\n"
						+ "  \"emp_middle_name\": \"Aburahm\",\n" + "  \"emp_gender\": \"M\",\n"
						+ "  \"emp_birthday\": \"2011-11-11\",\n" + "  \"emp_status\": \"Employee\",\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\n" + "}")
				.log().all();

		/**
		 * Storing response into createEmployeeResponse -- referance variable
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();

		/**
		 * jsonPath() to view response body which lets us get the employee ID We store
		 * employeee Id as a global variable so that may we use it with our other calls
		 */
		employeeID = createEmployeeResponse.jsonPath().get("Employee[0].employee_id");
		System.out.println(employeeID);

		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/**
		 * Verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("IsmoilJON"));

		/**
		 * Verifying server using then().header();
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		/**
		 * Verifying Content-Type
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");

	}

	@Test
	public void bGETcreateEmployee() {

		/**
		 * Preparing request for /getOneEmployee.php Using log().all() method to see all
		 * information being sent with request
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		/**
		 * making call to retrieve created employe
		 */
		Response getCreatedEmployeeRsponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Printing response using prettyPrint() method ;
		 */
		String response = getCreatedEmployeeRsponse.prettyPrint();

		/**
		 * Storing response employeeID into empID which will be used for verification
		 * against stored global employee ID
		 */
		String empID = getCreatedEmployeeRsponse.body().jsonPath().getString("employee[0].employee_id");

		/**
		 * matching exact employeeID's
		 */
		boolean verifyingEmployeeIDMatch = empID.equalsIgnoreCase(employeeID);

		/**
		 * Asserting employee ID's match
		 */
		Assert.assertTrue(verifyingEmployeeIDMatch);

		/**
		 * Verifying status code is 200
		 */
		getCreatedEmployeeRsponse.then().assertThat().statusCode(200);

		JsonPath js = new JsonPath(response);
		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String emp_bday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID);
		System.out.println(firstName);

		/**
		 * Verifying employee ID 's match
		 */
		Assert.assertTrue(emplID.contentEquals(employeeID));
		// Second way of asserting
		// Assert.assertEquals(employeeID, emplID);

		Assert.assertTrue(firstName.contentEquals("IsmoilJON"));

		Assert.assertTrue(middleName.contentEquals("Aburahm"));

		Assert.assertTrue(lastName.contentEquals("Xojaev"));

		Assert.assertTrue(emp_bday.contentEquals("2011-11-11"));

		Assert.assertTrue(gender.contentEquals("Male"));

		Assert.assertTrue(jobTitle.contentEquals("Cloud Architect"));

		Assert.assertTrue(empStatus.contentEquals("Employee"));

	}

	@Test
	public void cGETallEmployees() {

		/**
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/**
		 * Storing response into getAllEmployeeResponse
		 */
		Response getAllEmployeesRsponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/**
		 * Printing all employees
		 */
		// getAllEmployeesRsponse.prettyPrint();

		String allEmployees = getAllEmployeesRsponse.body().asString();

		/**
		 * The below will pass but incorrect
		 */
		// allEmployees.contains(employeeID);

		/**
		 * ----------------DO RESEARCH-----------------
		 */
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		/**
		 * Retrieving size of Employee list
		 */
		int sizeOfList = js.getInt("Employees.size()");

		System.out.println(sizeOfList);

		/**
		 * Print out all employee ID's
		 */
//		for (int i = 0; i < sizeOfList; i++) {
//              
//			/**
//			 * Printing all employee ID's
//			 */
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//
//			// System.out.println(allEmployeeIDs);
//			
//			
//			/**
//			 * 
//			 */
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				
//				System.out.println("Employee ID : "+ employeeID +" is present in body");
//				String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//				
//				
//				break;
//				
//			}
//			
//			
//
//		}

	}
    
	@Test
	public void dPUTupdateCreatedEmployee() {
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).body(HarcodedConstants.updateCreatedEmpBody());
		
		
		Response updateCreatedEmployeeResponse =updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		
		String response = updateCreatedEmployeeResponse.prettyPrint();
		
		System.out.println(response);
		
		
	}
	
	
	
	
	
	
	
	
}
