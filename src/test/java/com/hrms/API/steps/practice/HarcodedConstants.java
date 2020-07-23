package com.hrms.API.steps.practice;

public class HarcodedConstants {
	
	public static String updateCreatedEmpBody() {
		
		
		String updateBody ="{\n" + 
				"  \"employee_id\": \""+ HardcodedExamples.employeeID+"\",\n" + 
				"  \"emp_firstname\": \"AbuIsmoil\",\n" + 
				"  \"emp_lastname\": \"Xojaev\",\n" + 
				"  \"emp_middle_name\": \"Aburahm\",\n" + 
				"  \"emp_gender\": \"M\",\n" + 
				"  \"emp_birthday\": \"2020-11-11\",\n" + 
				"  \"emp_status\": \"Internee\",\n" + 
				"  \"emp_job_title\": \"QA Tester\"\n" + 
				"}";
		
		return updateBody;
		
		
	}

}
