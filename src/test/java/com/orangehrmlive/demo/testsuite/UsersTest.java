package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestDataForUserTest;

/**
 * 1.UsersTest
 * Inside UsersTest class create following test methods
 * 1.adminShouldAddUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * click On "Add" button
 * Verify "Add User" Text
 * Select User Role "Admin"
 * enter Employee Name "Ananya Dash"
 *
 * enter Username
 * Select status "Disable"
 * enter password
 * enter Confirm Password
 * click On "Save" Button
 * verify message "Successfully Saved"
 * 2. searchTheUserCreatedAndVerifyIt().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Status
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * 3. verifyThatAdminShouldDeleteTheUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Status
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * Click on Check box
 * Click on Delete Button
 * Popup will display
 * Click on Ok Button on Popup
 * verify message "Successfully Deleted"
 * 4. searchTheUserAndVerifyTheMessageRecordFound().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username <username>
 * Select User Role <userRole>
 * Enter EmployeeName <employeeName>
 * Select Satatus <status>
 * Click on "Search" Button
 * verify message "(1) Record Found"
 * Verify username <username>
 * Click on Reset Tab
 *
 * Data Set
 * username userrole employeeName Status
 * Admin Admin Paul Collings Enable
 * Cassidy.Hope ESS Cassidy Hope Enable
 * Nina.Patel ESS Nina Patel Enable
 * Odis.Adalwin Admin Odis Adalwin Enable
 */

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }
    @Test(groups={"sanity", "smoke" , "regression"})
    public void adminShouldAddUserSuccessFully(){
        //Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        loginPage.clickOnLoginButton();
        //click On "Admin" Tab
        adminPage.clickOnAdminTab();
        //Verify "System Users" Text
        viewSystemUsersPage.verifySystemUsersText();
        //click On "Add" button
        viewSystemUsersPage.setClickOnAddButton();
        //Verify "Add User" Text
        String actualMessage = addUserPage.setVerifyAddUserText();
        String expectedMessage = "Add User";
        Assert.assertEquals(actualMessage, expectedMessage);
        //Select User Role "Admin"
        addUserPage.setSelectAdmin();
        //enter Employee Name "Ananya Dash"
        addUserPage.setEnterEmployeeName("Ananya Dash");
        //enter Username
        viewSystemUsersPage.setEnterUsername("Ananya.Dash");
        //Select status "Disable"
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();
        //enter password
        addUserPage.setEnterPassword("admin123");
        //enter Confirm Password
        addUserPage.setConfirmPassword("admin123");
        //click On "Save" Button
        addUserPage.setClickOnSaveButton();
        //verify message "Successfully Saved"
    }

    @Test(groups = {"smoke" ,"regression" })
    public void searchTheUserCreatedAndVerifyIt(){
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //click On "Admin" Tab
        adminPage.clickOnAdminTab();
       // Verify "System Users" Text
        viewSystemUsersPage.verifySystemUsersText();
       // Enter Username
        viewSystemUsersPage.setEnterUsername("Andy.Anderson");
       // Select User Role
        addUserPage.setSelectUserRole();
        //Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();
       // Click on "Search" Button
        viewSystemUsersPage.clickOnSearch();
        //Verify the User should be in Result list.
        String actualResult = viewSystemUsersPage.setVerifyTheResult();
        String expectedResult = "Andy.Anderson";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = {"regression" } )
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //click On "Admin" Tab
        adminPage.clickOnAdminTab();
        //Verify "System Users" Text
        viewSystemUsersPage.verifySystemUsersText();
       // Enter Username
        viewSystemUsersPage.setEnterUsername("Ananya.Dash");
        //Select User Role
        addUserPage.setSelectUserRole();
        //Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearch();
        //Verify the User should be in Result list.
        String actualResult = viewSystemUsersPage.setVerifyTheResult();
        String expectedResult = "Ananya.Dash";
        Assert.assertEquals(actualResult, expectedResult);
       // Click on Check box
        // Click on Delete Button
        viewSystemUsersPage.setClickOnDeleteButton();
        //Popup will display
        viewSystemUsersPage.notifyAll();
       // Click on Ok Button on Popup
        viewSystemUsersPage.acceptAlert();
        //verify message "Successfully Deleted"
        String actualMessage = viewSystemUsersPage.getTextFromAlert();
        String expectedMessage = "Successfully Deleted";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(dataProvider = "userDetails", dataProviderClass = TestDataForUserTest.class, groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound(String userName ,String userRole ,String employeeName, String status){
       // Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //click On "Admin" Tab
        adminPage.clickOnAdminTab();
        //Verify "System Users" Text
        viewSystemUsersPage.verifySystemUsersText();
        //Enter Username <username>
        viewSystemUsersPage.setEnterUsername(userName);
        //Select User Role <userRole>
        viewSystemUsersPage.setSelectUserRole();
         //Enter EmployeeName <employeeName>
        viewSystemUsersPage.setEnterEmployeeName(employeeName);
        //Select Status <status>
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();
        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearch();
        //verify message "(1) Record Found"
        viewSystemUsersPage.setVerifyRecordFound();
        //Verify username <username>
        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUsersPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);
        //Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();
    }


}
