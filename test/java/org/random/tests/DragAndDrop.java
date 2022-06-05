package org.random.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDrop {
    @Test
    void DragAndDrop() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dench\\Desktop\\Selenium\\autotests\\libs\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                driver.get("https://demo.guru99.com/test/drag_drop.html");

                WebElement bankblock = driver.findElement(By.cssSelector("#credit2 a"));

                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(bankblock));

                WebElement accountSideBlock = driver.findElement(By.cssSelector("#bank li"));

                Actions actions = new Actions(driver);
                actions.dragAndDrop(bankblock, accountSideBlock).pause(10000).perform();

                WebElement debitTable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("bal3")));

                assert(debitTable.isDisplayed());
                driver.quit();
    }
    @Test
    void DragAndDropSales() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dench\\Desktop\\Selenium\\autotests\\libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/drag_drop.html");
        WebElement salesblock = driver.findElement(By.cssSelector("#credit1 a"));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(salesblock));

        WebElement salesSideBlock = driver.findElement(By.cssSelector("#loan li"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(salesblock, salesSideBlock).pause(10000).perform();

        WebElement salesTable = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("bal3")));

        assert(salesTable.isDisplayed());
        driver.quit();
    }
}

