import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // För GitHub Actions (headless) – ta bort kommentaren när du testar i CI
        // options.addArguments("--headless=new");
        // options.addArguments("--no-sandbox");
        // options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void successfulLoginShouldRedirectToInventoryPage() {
        // Logga in med korrekta uppgifter
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Kontrollera att vi hamnar på rätt sida efter inloggning
        assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Efter lyckad inloggning ska användaren hamna på inventory-sidan");
    }
}