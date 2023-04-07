package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {
    ChromeDriver driver;

    public AppTest() {
    }
    @BeforeClass
    @Parameters({"browser", "url"})
    void setupDriver(String browser, String link) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new ChromeDriver();
        }

        this.driver.get("https://www.github.com/");
        this.driver.manage().window().maximize();
    }

    @Test
    void githubLoginPageTest() throws InterruptedException {
        this.driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div[2]/a")).click();
        Thread.sleep(1000L);
        this.driver.findElement(By.cssSelector("input#login_field")).sendKeys(new CharSequence[]{"pradeep02122001@gmail.com"});
        Thread.sleep(1000L);
        this.driver.findElement(By.cssSelector("input#password")).sendKeys(new CharSequence[]{"Pra@183910146"});
        Thread.sleep(3000L);
        this.driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        Thread.sleep(3000L);
    }

    @AfterClass
    void closeDriver() {
        this.driver.close();
    }
}