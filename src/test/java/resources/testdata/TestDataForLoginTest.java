package resources.testdata;

import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.DataProvider;

public class TestDataForLoginTest extends BaseTest {
    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"", "", "Required"},
                {"test123@gmail.com", "","Required"},
                {"", "test123","Required"},
                {"test123@gmail.com", "test123", "Invalid credentials"}
        };
        return data;
    }
}
