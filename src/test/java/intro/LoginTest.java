/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author CarlosPC
 */
public class LoginTest {
    
    private WebDriver driver;
    
    private By login_link_locator = By.linkText("Log In");
    private By login_page_locator = By.className("card-header");
    private By login_email_locator = By.id("email");
    private By login_password_locator = By.name("password");
    private By login_submit_locator = By.xpath("//button[@type='submit']");
    
    
    public LoginTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "./src/test/"
                            + "resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void loginGetMCSS() throws InterruptedException {
        
        driver.get("https://getmcss.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(login_link_locator).click();
        Thread.sleep(2000);
        if (driver.findElement(login_page_locator).isDisplayed()) {
            
            driver.findElement(login_email_locator).sendKeys("email_test"
                                                            + "@email.com");
            driver.findElement(login_password_locator).sendKeys("password_test");
            driver.findElement(login_submit_locator).click();
        }
        assertEquals("MCSS Admin User", driver.getTitle());
    
        
    }
}
