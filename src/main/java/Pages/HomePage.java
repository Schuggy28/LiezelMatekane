package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

public WebDriver driver;

private By AppointmentBtn = By.id("btn-make-appointment");
private By MakeAppointment = By.id("btn-book-appointment");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //click the form appointment button
    public LoginPage AppointmentBtn(String id){
    clickAppointmentBtn(id);
    return new LoginPage(driver);
    }
    public void clickAppointmentBtn(String id) {
        driver.findElement(By.id(id)).click();
    }

        public MakeAppointmentPage MakeAppointment(String id){
    clickMakeBookingBtn(id);
    return new MakeAppointmentPage(driver);
    }
    public void clickMakeBookingBtn(String id) {
        driver.findElement(By.id(id)).click();
    }
}

