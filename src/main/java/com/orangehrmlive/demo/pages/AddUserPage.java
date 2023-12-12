package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 6.AddUserPage - User Role Drop Down, Employee Name, Username, Status Drop Down,
 * Password, Confirm Password,
     * Save and Cancel Button Locators and it's actions
 */
public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']" )
    WebElement verifyAddUserText;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement userRoleDropDown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']") //employeeName label
    //type for hints....//input[@placeholder='Type for hints...']....//label[normalize-space()='Employee Name']
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Disabled')]")
    WebElement selectDisable;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement statusDropDown;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Admin')]")
    WebElement selectAdmin;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']" )
    WebElement selectStatus;


    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space")
    WebElement saveButton;
    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--ghost")
    WebElement cancelButton;

    public void setSelectAdmin(){
        selectByContainsTextFromDropDown((By) selectAdmin,"Admin");
    }
    public void setSelectDisable(){
        selectByIndexFromDropDown(selectDisable,0);
    }


    public void setSelectUserRole(){
        clickOnElement(userRoleDropDown);
        clickOnElement(selectAdmin);
    }
    public String setVerifyAddUserText() {
        return getTextFromElement(verifyAddUserText);
    }

    public void setSelectStatus(){
        clickOnElement(selectStatus);
    }
    public void setEnterEmployeeName(String name){
        sendTextToElement(employeeName, name);
    }

    public void setStatusDropDown(){
        selectByVisibleTextFromDropDown(statusDropDown, "Disabled");
    }
    public void setUsername(String username){
        sendTextToElement(enterUsername, username);
    }

    public void setEnterPassword(String password){
        sendTextToElement(enterPassword, password);
    }
    public void setConfirmPassword(String password1){
        sendTextToElement(confirmPassword, password1 );
    }
    public void setClickOnSaveButton(){
        clickOnElement(saveButton);
    }
    public void setCancelButton(){
        clickOnElement(cancelButton);
    }
}
