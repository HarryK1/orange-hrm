package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * In Pages package
 * 1.LoginPage - Store username, password, Login Button and LOGIN Panel text Locators
 * and create appropriate methods for it.
 */
public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanel;


        public void enterUserName(String username){
        sendTextToElement(usernameField, username);
        //CustomListeners.test.log(Status.PASS, "Enter Username " +username);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
        //CustomListeners
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        //CustomListeners
    }
    public void loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public boolean verifyLoginPanelIsDisplayed(){
                return loginPanel.isDisplayed();
            }
    }

