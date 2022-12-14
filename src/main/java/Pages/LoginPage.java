package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By AppointmentMessage = By.xpath("//*[@id=\"appointment\"]/div/div/div/h2");
    //Login page fields
    public WebDriver driver;
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginBtn = By.id("btn-login");

    //calls the Login driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Input Username method
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);

    }

    //Input Password method
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

//Click the Login Button
    public MakeAppointmentPage clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new MakeAppointmentPage(driver); //
    }
    public String getAppointmentMessage() {
        return driver.findElement(AppointmentMessage).getText();
    }
}

