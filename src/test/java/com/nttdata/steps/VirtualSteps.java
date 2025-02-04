package com.nttdata.steps;

import com.nttdata.page.InicioSeionPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VirtualSteps {

    private WebDriver driver;
    public VirtualSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUs(String user){
        WebElement userInputElement = driver.findElement(InicioSeionPage.emailInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InicioSeionPage.logButton));


    }
    public void typePass(String password){
        this.driver.findElement(InicioSeionPage.passwordInput).sendKeys(password);
    }
    public void Registro(){
        this.driver.findElement(InicioSeionPage.logButton).click();
    }
}
