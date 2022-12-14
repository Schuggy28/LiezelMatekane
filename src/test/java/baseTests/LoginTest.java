package baseTests;

import Pages.BookAppointmentPage;
import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

public class LoginTest extends baseTest {
    @Test(priority = 1, dataProvider = "LoginData")
    public void loginSuccessful(String Username, String Password) {

        //login functionality
        LoginPage loginPage = homePage.AppointmentBtn("btn-make-appointment");
        loginPage.setUsername(Username);
        loginPage.setPassword(Password);


      MakeAppointmentPage makeAppointmentPage = loginPage.clickLoginBtn();
        extracted(makeAppointmentPage);

    }

    private void extracted(MakeAppointmentPage makeAppointmentPage) {
        BookAppointmentPage loginTest = makeAppointmentPage.clickAppointmentBtn();
    }

    @DataProvider() //is used to provide or bring back data
    public Object[][] LoginData() {  //this is a two-dimensional array which means has a row and column
        Object[][] data = new Object[1][2]; //I want 1 row, Index 2 = columns

        data[0][0] = "John Doe";
        data[0][1] = "ThisIsNotAPassword";

        return data;
    }


    @Test(priority = 2, dataProvider = "BookingData")
    public void BookingSuccessful(String Facility, String reAdmission, String Program1, String Program2, String Program3, Date visitDate, String Comments ){ //,boolean Success

        //Booking My appointment
        MakeAppointmentPage bookAppointment = homePage.MakeAppointment("btn-book-appointment");
        bookAppointment.setFacility(Facility);
        bookAppointment.setReAdmission(reAdmission);
        bookAppointment.setProgram1(Program1);
        bookAppointment.setProgram2(Program2);
        bookAppointment.setProgram3(Program3);
        bookAppointment.setVisitDate(String.valueOf(visitDate));
        bookAppointment.setComments(Comments);


    }
    @DataProvider() //is used to provide or bring back data
    public Object[][] BookingData() {  //this is a two-dimensional array which means has a row and column
        Object[][] data = new Object[1][5]; //I want 2 row, Index 3 = columns

        data[0][0] = "Hongkong CURA Healthcare Center";
        data[0][1] = "Yes";
        data[0][2] = "None";
        data[0][3] = "12/12/2022";
        data[0][4] = "I need to see the doctor urgently";

        return data;

    }
}
