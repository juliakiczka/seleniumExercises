import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Exercises {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
//        use when page is loading for too much time!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //  testy automatyczne muszą być niezależne od siebie!
    @Test
    public void testExercise4a() {
        driver.navigate().to("https://sdacademy.dev");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assertions.assertEquals("Software Development Academy | Give IT a go!", pageTitle);
    }

    @Test
    public void testExercise4b() {
        driver.navigate().to("https://stackoverflow.com");
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Stack Overflow - Where Developers Learn, Share, & Build Careers", driver.getTitle());
    }

    @Test
    public void testExercise6() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        String dashboard = driver.findElement(By.className("oxd-topbar-header-breadcrumb")).getText();
        Assertions.assertEquals("Dashboard", dashboard);
    }

    @AfterAll
    public static void tearDown() {
//        driver.quit();
    }
}
