package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
 * and create appropriate methods for it.
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']")
    WebElement logoField;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
    WebElement admin;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement pim;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Leave']")
    WebElement leave;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    WebElement dashboard;

    public boolean setLogoField(){
        return logoField.isDisplayed();
    }
    public void setAdmin(){
        clickOnElement(admin);
    }
    public void setPim(){
        clickOnElement(pim);
    }
    public void setLeave(){
        clickOnElement(leave);
    }
    public void setDashboard(){
        clickOnElement(dashboard);
    }


}
