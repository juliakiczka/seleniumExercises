import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Exercises {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
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

    @Test
    public void testExercise7() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("WrongUsername");
        driver.findElement(By.name("password")).sendKeys("WrongPassword");
        driver.findElement(By.tagName("button")).click();
        String invalid = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assertions.assertEquals("Invalid credentials", invalid);
    }

    @Test
    public void testExercise8() {
        driver.navigate().to("https://www.bbc.com/");
        List<WebElement> linksOnPage = driver.findElements(By.tagName("a"));
        int imagesOnPage = driver.findElements(By.tagName("img")).size();
        System.out.println("Ilość linków na stronie = " + linksOnPage.size());
        System.out.println("Ilość obrazków na stronie = " + imagesOnPage);
    }

    @Test
    public void testExercise9() {
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement textArea = driver.findElement(By.tagName("textarea"));
        textArea.sendKeys("Software Development Academy");
        textArea.submit();
        driver.findElement(By.className("d8lRkd")).click();
        Assertions.assertEquals("Zapisz się na webinar i poznaj swoje możliwe ścieżki rozwoju w IT!", driver.getTitle());
    }

    @Test
    public void testExercise10() {
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement textArea = driver.findElement(By.tagName("textarea"));
        textArea.sendKeys("Software Development Academy");
        textArea.submit();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.get(0).click();
//        driver.findElement(By.className("d8lRkd")).click();
//        Assertions.assertEquals("Zapisz się na webinar i poznaj swoje możliwe ścieżki rozwoju w IT!", driver.getTitle());
    }

    @Test
    public void testExercise11() {
        driver.navigate().to("https://www.pracuj.pl/");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[7]/div/div/div/div[3]/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[1]/div[2]/div[2]/div/div[1]/div[1]/div/div/div/input")).sendKeys("tester");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(By.xpath("//*[@id=\"relative-wrapper\"]/div[1]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/input")).sendKeys("Warszawa");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[1]/div[2]/div[2]/div/div[2]/button")).click();
//        driver.findElement(By.className("d8lRkd")).click();
//        Assertions.assertEquals("Zapisz się na webinar i poznaj swoje możliwe ścieżki rozwoju w IT!", driver.getTitle());
    }

    @Test
    public void testExercise12() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        driver.findElement(By.name("firstName")).sendKeys("Keanu");
        driver.findElement(By.name("middleName")).sendKeys("Charles");
        driver.findElement(By.name("lastName")).sendKeys("Reeves");
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys("666");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/";
        driverWait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        String actual = actualUrl.substring(0, actualUrl.length() - 2);
        Assertions.assertEquals(expectedUrl, actual);
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
