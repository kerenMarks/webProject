package Project_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static Project_web.Start.pass;
import static Project_web.Start.user;

public class LoginPage {
    @FindBy(how = How.CLASS_NAME, using = "seperator-link")
    private static WebElement enter;// login button in the main page
    @FindBy(how = How.CSS, using =("input[placeholder='מייל']"))
    private static WebElement email;// enter email in the main page
    @FindBy(how = How.CSS, using =("input[placeholder='סיסמה']"))
    private static WebElement sisma; // enter password text box
    @FindBy (how = How.XPATH, using = "//*[@id=\"auth-modal\"]/div/span")
    private static WebElement harshama; // sign in  link
    @FindBy(how = How.CSS, using = ("input[placeholder='שם פרטי'"))
    private static WebElement name; // enter name for the first time
    static String fname = "keren";
       @FindBy(how = How.CSS, using = ("input[placeholder='אימות סיסמה']"))
    private static WebElement reEnterpass; // re_enter password sign in page
    @FindBy (how = How.XPATH, using = "//label[.='אני מסכים לתנאי']")
    private static WebElement agree;// agree sign
    @FindBy(how = How.CSS,using =".db.fluid.btn.btn-theme")
    //@FindBy(how = How.CSS,using ="//*[@id=\"ember819\"]/button")
    private static WebElement assign; // assign button




// press the harshame in the main page
    public static void press_Login (){

    //    enter.click();

    }


//first time enter click link
    public static void press_firstEnter() {

        harshama.click();
    }


// enter data in the registration page
    public static void signInFristTime() {
        Metode.enterText(fname,name);// enter firstname
        Metode.enterText(user,email);//enter email
        Metode.enterText(pass,sisma);// enter password
        Metode.enterText(pass,reEnterpass);//re_enter password

    }
// accept registration agreement
    public static void acceptcheckbox() {
        agree.click(); // accept agreement check box
    }

// registration button submit
    public static void signInbutton() {

        assign.submit();
    }
}
