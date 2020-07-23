package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utils.CommonMethods;

public class LoginPage extends CommonMethods {
	
	
	@FindBy(xpath="//div[@id='divUsername']/input")
	public WebElement username;
	
	
	@FindBy(xpath="//div[@id='divPassword']/input")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public WebElement logo;
	
	@FindBy(id = "spanMessage")
	public WebElement errorMsg;
	
	
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	
	//if we would be keeping elements as private 
		//then we will need to create public getters and setters 
		//so we can access page elements from test classes
		
		//setter
		public void sendUsername(String uid) {
			sendText(username, uid);
		}
		
		//getter
		public WebElement getUsername() {
			return username;
		}
		
	public void login(String uid,String pwd) {
			
			sendText(username,uid);
			sendText(password, pwd);
			click(loginBtn);
			
			
			
		}

}
