package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 5.ViewSystemUsersPage - System Users Text, Username Field, User Roll dropDown,
 * Employee Name Field,
 * Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and it's
 * actions
 */
public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(className = "oxd-text oxd-text--h5 oxd-table-filter-title")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement userRoleDropDown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement enterEmployeeName;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement statusDropDown;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement verifyRecordFound;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'rajpatel123')]")
    WebElement  verifyTheResult;

    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space")
    WebElement searchButton;

    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--ghost")
    WebElement resetButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Admin')]")
    WebElement selectAdmin;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin") // pls check if delete selected is ok
    WebElement deleteButton;

    public String verifySystemUsersText(){
        return getTextFromElement(systemUsersText);
    }
    public void setEnterUsername(String username){
        sendTextToElement(enterUsername, username);
    }
    public void setSelectUserRole(){
        clickOnElement(userRoleDropDown);
        clickOnElement(selectAdmin);
    }
    public void setEnterEmployeeName(String employeeName){
        sendTextToElement(enterEmployeeName, employeeName);
    }
    public void setStatusDropDown(){
        clickOnElement(statusDropDown);
    }
    public void clickOnSearch(){
        clickOnElement(searchButton);
    }
    public void setSelectAdmin(){
        selectByContainsTextFromDropDown((By) selectAdmin,"Admin");
    }
    public void setClickOnAddButton(){
        clickOnElement(addButton);
    }
    public String setVerifyTheResult(){
        return getTextFromElement(verifyTheResult);
    }
    public void setClickOnDeleteButton(){
        clickOnElement(deleteButton);
    }
    public void clickOnResetButton(){
        clickOnElement(resetButton);
    }

    public String getSystemUsersText() {
        return getTextFromElement(systemUsersText);
    }

    public String setVerifyRecordFound(){
        return getTextFromElement(verifyRecordFound);
    }
}
