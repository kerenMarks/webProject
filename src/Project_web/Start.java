package Project_web;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class Start {
    @Rule
    public TestName name = new TestName();
    public String imgpath = "C:\\Automation\\Report\\";

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;

    public static WebDriver driver;
    public static String user ="1124@hotmail.com"; //email for login
    public static String pass ="asd123asd"; // password for login

@BeforeClass

public static void main() throws ParserConfigurationException, IOException, SAXException {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Automation//Report//extent.html");


    // choose to append each test
    htmlReporter.setAppendExisting(true);
    // attach reporter
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    // name your test and add description
    test = extent.createTest("MyProject", "web buyme.co.il");

    // add custom system info

    extent.setSystemInfo("Tester", "Keren");

    // log results
    test.log(Status.INFO, "@Before class");

    boolean driverOK = false;

    // set the browser by xml file that exist Metode class
        try {
            String webtype;
            webtype = Metode.getData("browserType");
            if (webtype.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (webtype.equals("IE")) {
                System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            driver.manage().window().maximize();
            driver.get("https://www.buyme.co.il");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Project_web.LoginPage page = PageFactory.initElements(driver, Project_web.LoginPage.class);
            Project_web.ChosenPage page1 = PageFactory.initElements(driver, Project_web.ChosenPage.class);
            Project_web.Gift page2 = PageFactory.initElements(driver, Project_web.Gift.class);
            Project_web.ReceiverInformationPage page3 = PageFactory.initElements(driver, Project_web.ReceiverInformationPage.class);
            Project_web.Metode page4 = PageFactory.initElements(driver, Project_web.Metode.class);

            driverOK =true;
        }
    catch (Exception e) {
             e.printStackTrace();
             fail("Cant connect chromeDriver");

              test.log(Status.FATAL, "Failed to get driver" + e.getMessage());
            driverOK = false;
        } finally {
           if (driverOK) {
              test.log(Status.PASS, "Driver established successfully");

            }
        }

    }

   @Test // press the sign in link
    public void Test011_pressSignIn() throws IOException {
  // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
       boolean pressed = false;
        try {
                Project_web.LoginPage.press_Login();
                pressed =true;
       } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Test011_pressSignIn Fail to press login " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "Test011_pressSignIn " + "login was clicked successfully");
                        }
                  }

    }
@Test // press not sing in yet
   public void Test012_harshame() throws IOException {
    // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
        boolean pressed = false;
        try {
        Project_web.LoginPage.press_firstEnter();
          pressed =true;
       } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Test012_harshame Fail to press not sign in yet " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "Test012_harshame " + " press sign in yet  clicked successfully");
                     }
                }


    }
   @Test // send name email and pass
    public void Test013_EnterDataSignin(){
          boolean sendkey = false;
        try {
            Project_web.LoginPage.signInFristTime();
             sendkey =true;
       } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Test013_EnterDataSignin Fail to send key to register page " + e.getMessage());
            sendkey= false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "Test013_EnterDataSignin " + "  send key to register page successfully");
                     }
                }


    }
    @Test // check accept agreement
    public void Test014_Accept(){
         boolean pressed = false;
        try {
            Project_web.LoginPage.acceptcheckbox();
            pressed =true;
       } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " Test014_Accept Fail to check accept agreement " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, " Test014_Accept " + "check accept agreement clicked successfully");
                     }
                }


    }

    @Test //assign button
    public void Test015_assignButton(){
        boolean pressed = false;
        try {
            Project_web.LoginPage.signInbutton();
            pressed =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " Test015_assignButton Fail to click assign button " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  Test015_assignButton " + " assign button clicked successfully");
            }
        }

    }







    @Test // choose 99 shekel for voucher
    public void test020_choose99() throws InterruptedException {
        // add screenshot
        try {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
        } catch (IOException e) {
            e.printStackTrace();
        }



        boolean chooseValue = false;
        try {
            Project_web.ChosenPage.choose99();
            chooseValue =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test020_choose99  fail choose 99 shekel value for voucher " + e.getMessage());
            chooseValue= false;
        } finally {
            if (chooseValue) {
                test.log(Status.PASS, "  test020_choose99 " + " choose 99 shekel value for voucher success");
            }
        }

    }
    @Test
    public void test021_location() throws InterruptedException {
        boolean chooseValue = false;
        try {
            Project_web.ChosenPage.choosearia();
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test021_location  fail choose location for voucher " + e.getMessage());
            chooseValue= false;
        } finally {
            if (chooseValue) {
                test.log(Status.PASS, "  test021_location " + " choose location value for voucher successe");
            }
        }

    }
    @Test
    public void test022_category() throws InterruptedException {
        boolean chooseValue = false;
        try {
            Project_web.ChosenPage.chooseCategory();
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test022_category  fail choose category for voucher " + e.getMessage());
            chooseValue= false;
        } finally {
            if (chooseValue) {
                test.log(Status.PASS, "  test022_category " + " choose category value for voucher successe");
            }
        }
    }
    @Test
    public void test023_search() throws InterruptedException {


        boolean pressed = false;
        try {
            // press the search button
            Project_web.ChosenPage.search();
            pressed =true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test023_search Fail to click search button " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  test023_search " + " search button clicked successfully");
            }
        }
    }
    @Test
    public void test030_validateResult() throws InterruptedException {
        // add screenshot
        try {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean pressed = false;
        try {
            // validate the total result
            Gift.assertResult();
            pressed =true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test030_validateResult  Fail validate result " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  test030_validateResult " + " result  valiadate successfully");
            }
        }


    }
    @Test
    public void test031_chooseThegift() throws InterruptedException {


        boolean pressed = false;
        try {
            // choose resterunt name
            Gift.firstGifClick();
            pressed =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test031_chooseThegift  Fail choose gift Mibshelt " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  test031_chooseThegift " + " choose gift Mibshelt successfully");
            }
        }


    }
@Test
    public void test041_chooseGift98() throws InterruptedException {
    // take screenshot
    try {
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
    } catch (IOException e) {
        e.printStackTrace();
    }
    boolean pressed = false;
    try {
        // choose the 98 value gift for mivshelt
        Gift.secoundGifClick();
        pressed = true;
    } catch (Exception e) {
        e.printStackTrace();
        test.log(Status.FAIL, " test041_chooseGift98  Fail choose gift Mibshelt value 98 " + e.getMessage());
        pressed = false;
    } finally {
        if (pressed) {
            test.log(Status.PASS, "  test041_chooseGift98 " + " choose gift value 98 Mibshelt successfully");
                 }
            }
    }
    @Test
    // check option send to someone else
    public void test051_forSomeOne() throws InterruptedException {
        // take screenshot
        try {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean pressed = false;
        try {
            // choose gift for someone else
            ReceiverInformationPage.clickSendToSomeOne();
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test051_forSomeOne  Fail choose for someone else " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  test051_forSomeOne " + " for someone else chosen sucssefuly successfully");
            }
        }

    }

    // enter receiver name in information page
    @Test
        public void test052_receiverName() throws InterruptedException {
        boolean sendkey = false;
        try {
            //enter receiver name
            ReceiverInformationPage.receiverName();
            sendkey =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test052_receiverName Fail to enter receiver name " + e.getMessage());
            sendkey= false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "test052_receiverName " + "  enter receiver name done successfully");
            }
        }
    }
    @Test
    //enter the name of the person the send the gift
    public void test053_senderName() throws InterruptedException {
        boolean sendkey = false;
        try {
            // enter sender name
            ReceiverInformationPage.senderName();
            sendkey =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "test053_senderName  Fail to enter sender name  " + e.getMessage());
            sendkey= false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "test053_senderName " + "  enter sender name done successfully");
            }
        }
    }
    @Test // write msg to the receiver
    public void test054_enterCongrats() throws InterruptedException {
        boolean sendkey = false;
        try {
            // enter congratulation
            ReceiverInformationPage.congratulation();
            sendkey =true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "test054_enterCongrats  Fail to enter congratulation  " + e.getMessage());
            sendkey= false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "test054_enterCongrats " + "  enter congratulation done successfully");
            }
        }
    }
    @Test
    //// upload picture to the receiver
    public void test055_picture() throws InterruptedException {
        boolean sendkey = false;
        try {
            // upload img
            ReceiverInformationPage.sendImg();
            sendkey = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "test055_picture  Fail to upload picture  " + e.getMessage());
            sendkey = false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "test055_picture " + "  upload picture done successfully");
            }
        }
    }
    @Test
    // chose send the gift now on when to send option
    public void test056_whenToSend () throws InterruptedException {
        boolean pressed = false;
        try {
            // send the gift now
            ReceiverInformationPage.sendGiftNow();
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test056_whenToSend  Fail choose send now " + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "  test056_whenToSend " + " send now chosen sucssefuly successfully");
            }
        }
    }

        @Test
        // send gift choose email
    public void test057_HowToSendBymail () throws InterruptedException {
            boolean pressed = false;
            try {
                // send the gift via email
                ReceiverInformationPage.sendGiftViaEmail();
                pressed = true;
            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, " test057_HowToSendBymail  Fail choose send gift via email " + e.getMessage());
                pressed = false;
            } finally {
                if (pressed) {
                    test.log(Status.PASS, "test057_HowToSendBymail" + " send gift via email chosen  successfully");
                }
            }
    }
    @Test
    // enter receiver email
   public void test058_enterReciverEmail () throws InterruptedException {
// add screenshot
        try {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Metode.takeScreenShot(imgpath + name.getMethodName())).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean sendkey = false;
        try {
            // enter receiver email
            ReceiverInformationPage.ReceiverEmail();
            sendkey = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "test058_enterReciverEmail  Fail to enter receiver email  " + e.getMessage());
            sendkey = false;
        } finally {
            if (sendkey) {
                test.log(Status.PASS, "test058_enterReciverEmail " + "  enter receiver email done successfully");
            }
        }    }
    @Test
    //save receiver email button
    public void test059_saveEmail () throws InterruptedException {
        boolean pressed = false;
        try {
            //click save receiver email button
            ReceiverInformationPage.saveReciverEmail();
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test059_saveEmail  Fail click save receiver email button" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "test059_saveEmail" + " click save receiver email button successfully");
            }

        }
    }
    @Test
    //// pay for voucher
    public void test060_pay () throws InterruptedException {
        boolean pressed = false;
        try {
            //click save receiver email button
            ReceiverInformationPage.pay();
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, " test060_pay  Fail click pay for voucher button" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "test060_pay" + " click pay for voucher button done successfully");
            }
        }


        }



    @AfterClass
    public static void close() throws InterruptedException {

        driver.quit();

        test.log(Status.INFO, "@After test " + "All tests done");
        // build and flush report
        extent.flush();
    }



  }
