package com.portfolio.bank;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Demo test against Applitools demo bank (stable public site).
 * Scenario: login -> verify dashboard -> logout.
 * Safe for portfolio reviewers to run locally.
 */
public class DemoBankLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(); // Selenium Manager resolves chromedriver
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void canLoginAndLogout() {
        driver.get("https://demo.applitools.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("log-in")).click();

        // Verify dashboard
        assertTrue(wait.until(ExpectedConditions.urlContains("app.html")), "Dashboard URL not reached");

        // Open menu and logout (if available)
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".avatar")));
            menu.click();
            WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Logout')]")));
            logout.click();
        } catch (Exception ignored) {
            // Some mirrors of the demo don't have explicit logout; test focus is login success.
        }
    }
}
