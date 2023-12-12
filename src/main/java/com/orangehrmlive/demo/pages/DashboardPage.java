package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Watchable;

/**
 * 3.DashboardPage - Dashboard text Locator
 * and create appropriate methods for it.
 */

public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(className = "oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module")
    Watchable verifyTheTextDashboard;

    public String getVerifyTheTextDashboard(){
        return getTextFromElement((WebElement) verifyTheTextDashboard);
    }
}
