import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Zadanie4 {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testZadanie4a() {
        driver.navigate().to("https://sdacademy.dev");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assertions.assertEquals("Software Development Academy | Give IT a go!", pageTitle);
    }

    @Test
    public void testZadanie4b() {
        driver.navigate().to("https://stackoverflow.com");
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", driver.getTitle());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
