import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    WebDriver driver = new ChromeDriver();
    String page = "https://mokcoffee.be";
    String title = "MOK Specialty Coffee Roastery & Bar.", page2 = "Coffee", page3 = "Subscribe",
            page4 = "Vision", page5 = "Wholesale", page6 = "Account", page7 = "Your Shopping Cart";

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.manage().window().setSize(new Dimension(950, 800));
    }

    @AfterEach
    public void driverOFF() {
        driver.quit();
    }

    @Test
    public void getMetohod() {
        driver.get(page);
        Assertions.assertEquals(title, driver.getTitle());
    }

    @Test
    public void webpages() {
        driver.navigate().to(page);
        driver.findElement(By.linkText("Shop")).click();
        Assertions.assertEquals(page2, driver.getTitle());
        driver.navigate().back();
        Assertions.assertEquals(title, driver.getTitle());
        driver.findElement(By.linkText("Coffee Subscription")).click();
        Assertions.assertEquals(page3, driver.getTitle());
        driver.findElement(By.linkText(page4)).click();
        Assertions.assertEquals(page4, driver.getTitle());
        driver.findElement(By.linkText(page5)).click();
        Assertions.assertEquals(page5, driver.getTitle());
        driver.findElement(By.linkText("Sign in")).click();
        Assertions.assertEquals(page6, driver.getTitle());
        driver.findElement(By.partialLinkText("Cart")).click();
        Assertions.assertEquals(page7, driver.getTitle());
    }

}
