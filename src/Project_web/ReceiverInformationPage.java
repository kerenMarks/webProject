package Project_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Project_web.Start.driver;

public class ReceiverInformationPage {
    @FindBy(how = How.XPATH, using = "//span[.='למישהו אחר']")
    private static WebElement sendTOsomeOne;//choose to send the gift to someone else

     @FindBy(how = How.XPATH, using = "//input[@data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")
     private static WebElement receiverNamefild;//choose to send the gift to someone else
    @FindBy(how = How.ID, using ="sender-name")
    private static WebElement senderNamefild;//choose to send the gift to someone else
    @FindBy(how = How.ID, using ="msg")
    private static WebElement msgfild ;//place to txt you msg
    @FindBy(how =How.NAME, using ="fileUpload")
    private static WebElement fileUpload; // upload file
    @FindBy(how =How.CLASS_NAME, using="send-now")
    private static WebElement sendNow; // send the gift now
    @FindBy(how = How.XPATH, using ="//span[@class='btn-text']")
    private static WebElement sendByemail; // send the gift by email
    @FindBy(how = How.XPATH, using ="//input[@placeholder='כתובת המייל של מקבל/ת המתנה']")
    private static WebElement ReceiverEmailfild; // enter receiver email
    @FindBy(how = How.XPATH, using ="//button[.='שמירה']")
    private static WebElement saveEmail; // save receiver email button
    @FindBy(how = How.XPATH, using ="//button[@type='submit']")
    private static WebElement pay; // pay button


    private static String receivername= "Eden"; // receiver name
    private static String sender ="KM"; //sender name
    private  static String msg ="enjoy the voucher";//congratulation msg
    private  static String img ="C:\\SHEFA\\pictuer for shefa\\20.jpg"; //img to upload path
    private  static String receiverEmail = "abc@yahoo.co.il";
    // check option send to someone else
    public static void clickSendToSomeOne (){

        sendTOsomeOne.click();

    }
// enter Receiver name
    public static void receiverName(){

        Metode.enterText(receivername,receiverNamefild);
    }
    // enter sender name
    public static void senderName(){

        Metode.enterText(sender,senderNamefild);
    }
    // enter msg to the receiver
    public static void congratulation (){
        Metode.enterText(msg,msgfild);
    }

    // upload picture to the receiver
    public static void sendImg (){
        WebDriverWait wait=new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) fileUpload));
        //
        Metode.enterText(img,fileUpload);
    }
    // check option send gift now
    public static void sendGiftNow (){

        sendNow.click();
    }

    // check option send gift using email
    public static void sendGiftViaEmail (){

        sendByemail.click();
    }

    // enter receiver email
    public static void ReceiverEmail (){
        Metode.enterText(receiverEmail,senderNamefild);
    }
    // save receiver email
    public static void saveReciverEmail (){

        saveEmail.click();
    }

    // pay for voucher
    public static void pay () {

        pay.click();
    }
}
