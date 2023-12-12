package resources.testdata;

import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.DataProvider;

public class TestDataForUserTest extends BaseTest {
    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Admin", "Admin", "Paul Collings", "Enable"},
                {"Cassidy Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enable"}
        };
        return data;
    }
}
