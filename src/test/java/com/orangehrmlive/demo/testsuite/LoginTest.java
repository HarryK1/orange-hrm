package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestDataForLoginTest;

/**
 * 2. LoginTest
 * Inside LoginTest class create following testmethods
 * 1. verifyUserShouldLoginSuccessFully()
 * Enter username
 * Enter password
 * Click on Login Button
 * Verify "WelCome" Message
 * 2. verifyThatTheLogoDisplayOnHomePage()
 * Login To The application
 * Verify Logo is Displayed
 * 3. verifyUserShouldLogOutSuccessFully()
 * Login To The application
 * Click on User Profile logo
 * Mouse hover on "Logout" and click
 * Verify the text "Login Panel" is displayed
 * 4. verifyErrorMessageWithInvalidCredentials()
 * Enter username <username>
 * Enter password <password>
 * Click on Login Button
 * Verify Error message <errorMessage>
 * Test Data:
 * <p>
 * username password errorMessage
 * Required
 * test123@gmail.com Required
 * test123 Required
 * test123@gmail.com test123 Invalid credentials
 */
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    AdminPage adminPage;
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        adminPage = new AdminPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity" , "smoke" ,"regression"})
    public void verifyUserShouldLoginSuccessfully() {
        //Enter username
        loginPage.enterUserName("Admin");
        //Enter password
        loginPage.enterPassword("admin123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify "WelCome" Message
    }

    @Test(groups = {"smoke" , "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        //Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //Verify Logo is Displayed
        homePage.setLogoField();
    }
    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        // Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //Click on User Profile logo
        adminPage.clickOnUserProfileLogo();
        //Mouse hover on "Logout" and click
        adminPage.setMouseHoverOnLogout();
        //Verify the text "Login Panel" is displayed
        loginPage.verifyLoginPanelIsDisplayed();

    }
    @Test(dataProvider = "credentials", dataProviderClass = TestDataForLoginTest.class, groups = {"regression"})
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage) {
        //Enter username <username>and password<password>
        loginPage.loginToApplication(username,password);
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify Error message <errorMessage>
        String actualMessage = dashboardPage.getVerifyTheTextDashboard();
        String expectedMessage = errorMessage;
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
