package principles.bicep;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrossCheckTest
{
    private static WebDriver driver;
    private static WebDriver getChromeDriver()
    {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @BeforeClass
    public void driverSetup()
    {
        driver = getChromeDriver();
    }

    @Test
    public void repoCountMatches()
    {
        // Checks on UI Layer
        driver.get("https://github.com/AbdullahMuhammad20?tab=repositories");

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));
        int repoCount = repos.size();

        // Checks on API layer
        RestAssured.get("https://api.github.com/users/AbdullahMuhammad20")
                .then().assertThat()
                .body("public_repos",equalTo(repoCount));
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp()
    {
        driver.close();
    }

}
