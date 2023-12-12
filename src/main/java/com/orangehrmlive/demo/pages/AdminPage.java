package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 4.AdminPage - UserManagement, Job, Organization Tabs Locators and it's actions
 */
public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    WebElement userManagementTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Job']")
    WebElement jobTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Organization']")
    WebElement organizationTab;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='profile picture']")
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[4]")
    WebElement mouseHoverOnLogout;

    @CacheLookup
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    WebElement adminTab;


    public void clickOnUserManagementTab(){
        clickOnElement(userManagementTab);
    }

    public void clickOnJobTab(){
        clickOnElement(jobTab);
    }
    public void clickOnOrganizationTab(){
        clickOnElement(organizationTab);
    }

    public void clickOnUserProfileLogo(){
        clickOnElement(userProfileLogo);
    }
    public void setMouseHoverOnLogout(){
        mouseHoverToElementAndClick(mouseHoverOnLogout);
    }
    public void clickOnAdminTab(){
        clickOnElement(adminTab);
    }
}
