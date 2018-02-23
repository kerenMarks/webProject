package Project_web;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static Project_web.Start.driver;

public class Metode {
   static final String confFile ="C:\\Automation\\chrome.xml";


    public static String getData(String tagName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory A = DocumentBuilderFactory.newInstance();
        DocumentBuilder B = A.newDocumentBuilder();
        Document xml= B.parse(new File(confFile));
        xml.normalizeDocument();
        return xml.getElementsByTagName(tagName).item(0).getTextContent();

    }


//send text
    public static void enterText(String key, WebElement given)  {

      given.click();//in ovder to avoid problem with windows 10 and crome driver
      given.sendKeys(key);

    }

// chose from list
    public static void chooseFromList(String lookFor, List <WebElement> list){
       List<WebElement> dropDowns = list;

        for (int i =0 ;i < dropDowns.size() ;i++) {
            WebElement choose = dropDowns.get(i);

            if (choose.getText().equals(lookFor))
            {
                choose.click();
            }
        }

    }
// take img for report
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}
