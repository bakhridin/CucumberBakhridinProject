package com.cucumber.steps;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

@Before
public void start() {
	BaseClass.setUp();
}

@After
public void end(Scenario scenario) {
	byte[] pict;
	if(scenario.isFailed()) {
		pict = CommonMethods.takeScreenshots("Failed/"+scenario.getName());
	}else {
		pict = CommonMethods.takeScreenshots("Passed/"+scenario.getName());
	}
	
	scenario.attach(pict, "image/png", scenario.getName());
	
	BaseClass.tearDown();
}



}
