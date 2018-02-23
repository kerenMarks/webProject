package Project_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Project_web.Start.driver;

public class ChosenPage {
    @FindBy(how = How.XPATH, using = "//span[.='סכום']")
    private static WebElement select;//open the list of the values of the voucher
    @FindBy(how = How.CLASS_NAME, using = "active-result")
    public static List<WebElement> chosen;//list of the values of the voucher
    @FindBy(how = How.XPATH, using ="//span[.='אזור']")
    private static WebElement location;//list of the location of the voucher
    @FindBy(how = How.XPATH, using ="//span[.='קטגוריה']")
    private static WebElement category;//open the list of category;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement findme;//search button






    static String value99 = "עד 99 ש\"ח";
    static String valueLocation = "ירושלים";
    static String valueCategory = "גיפט קארד למסעדות";


    public static void choose99() throws InterruptedException {

          WebDriverWait wait = new WebDriverWait(driver, 200);
          wait.until(ExpectedConditions.elementToBeClickable(select)).click();

          Metode.chooseFromList(value99,chosen);

    }

    public static void choosearia() throws InterruptedException {

        location.click();
        Metode.chooseFromList(valueLocation,chosen);


    }

    public static void chooseCategory() throws InterruptedException {

        category.click();
        Metode.chooseFromList(valueCategory,chosen);


    }

    public static void search() throws InterruptedException {

        findme.click();
          }


}
