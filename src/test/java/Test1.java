import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

    @Test
    public void demoTestu() {
        System.out.println("Teste start");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension( 800, 600));
        driver.navigate().to("https://google.pl");
        driver.findElement(By.xpath(".//*[text()='I agree']")).click();
        WebElement searchField = driver.findElement(By.cssSelector("[title='Search']"));
        String searchEntry = "wszechświaty równoległe";
        String title = "Wieloświat – Wikipedia, wolna encyklopedia";
        searchField.sendKeys(searchEntry);
        searchField.submit();
        driver.findElement(By.xpath(".//*[text()='"+ title +"']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.titleIs(title));
        String entryURL = "https://pl.wikipedia.org/wiki/Wielo%C5%9Bwiat";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");
        String adress = driver.getCurrentUrl();
        System.out.println(adress +"\nTest end");

        //driver.quit();
    }

}

