package Project_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.NumberFormat;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class Gift {
    @FindBy(how = How.XPATH, using = "//span[.='מבשלת שריגים']")
    private static WebElement mibshelet;//choose gift "mibshelet sherigim"
    @FindBy(how = How.XPATH, using ="//span[.='לקנייה']")
    private static WebElement gift98;//choose picture with value 98
    @FindBy(how = How.CSS, using ="h1[class=page-title]")
    private static WebElement result; //search result text
    private static int resultNumber =24;// expected result value

    // check result of the search ok
    public static void assertResult (){

        // receiving text of the total result
        String getText =result.getText().toString();
        // get the first int in the text

        try {
            int firstNumber=((Number) NumberFormat.getInstance().parse(getText)).intValue();
            // check value is according to expected result
            assertEquals(resultNumber,firstNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

// choose the gift
    public static void firstGifClick() throws InterruptedException {
        mibshelet.click();


    }
    //choose the gift with value 98
    public static void secoundGifClick() throws InterruptedException {
        gift98.click();


    }

}
