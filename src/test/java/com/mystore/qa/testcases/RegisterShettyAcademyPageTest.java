package com.mystore.qa.testcases;


import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.Old.ContactUsPage;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;


public class RegisterShettyAcademyPageTest {


    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage registerPage;



    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = cp.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void validateLogInFormTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        Assert.assertTrue(registerPage.getLogInForm());
    }

    @Test
    public void validateMyStorePageTitle() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String actRegisterPageTitle = registerPage.getMyStorePageTitle();
        String expRegisterPageTitle = prop.getProperty("expRegisterPageTitle");
        Assert.assertEquals(expRegisterPageTitle, actRegisterPageTitle);
    }

    @Test
    public void validateAmountOfSocialMediaLinksTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        int expAmountOfSocialMediaLinks = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfSocialMedia"));
        int actAmountOfSocialMediaLinks = registerPage.socialMedia();
        Assert.assertEquals(expAmountOfSocialMediaLinks, actAmountOfSocialMediaLinks);
    }

    @Test
    public void validateShettyAcademyEmailTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String expShettyAcademyEmailText = registerPage.shettyAcademyEmail();
        String actShettyAcademyEmailText = prop.getProperty("shettyAcademyEmail");
        Assert.assertEquals(expShettyAcademyEmailText, actShettyAcademyEmailText);
    }

    @Test
    public void doLoginTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerPage = new RegisterShettyAcademyPage(driver);
        registerPage.doLogin(email, password);
    }


//    @Test(dataProvider = "getDataSectionWomen")
//    public void validateSectionWomen(String women, String dresses, String t_shirts) {
//        myStorePage = new RegisterPage(driver);
//        List<String> expList = new ArrayList<>(Arrays.asList(women, dresses, t_shirts));
//        List<String> actList = myStorePage.getNamesOfSection();
//        Assert.assertEquals(expList, actList);
//    }
//
//

//
//    @Test
//    public void validateAmountOfFooterPicsTest() {
//        myStorePage = new RegisterPage(driver);
//        int expAmountOfFooter = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfFooter"));
//        int actAmountOfFooter = myStorePage.footerPictures();
//        Assert.assertEquals(expAmountOfFooter, actAmountOfFooter);
//    }
//
//    @Test
//    public void leftBoxTextTest() {
//        myStorePage = new RegisterPage(driver);
//        String actFacebookLinkText = myStorePage.faceBookFieldText();
//        String expFacebookLinkText = ConfigReader.initProp().getProperty("facebookLinkText");
//        Assert.assertEquals(expFacebookLinkText, actFacebookLinkText);
//    }
//
//    @DataProvider
//    public Iterator<Object[]> getDataMiddleBoxTest() {
//        ArrayList<Object[]> testData = TestUtil.getDataMiddleBoxText();
//        return testData.iterator();
//    }
//
//    @Test(dataProvider = "getDataMiddleBoxTest")
//    public void middleBoxTextTest(String comeVisitUs, String callUs, String howToPayDues) {
//        myStorePage = new RegisterPage(driver);
//        List<String> expList = new ArrayList<>(Arrays.asList(comeVisitUs, callUs, howToPayDues));
//        List<String> actList = myStorePage.middleBox();
//        Assert.assertNotEquals(expList, actList);
//    }
//
//    @Test
//    public void rightBoxTextTest() {
//        myStorePage = new RegisterPage(driver);
//        String actRightBox = myStorePage.rightBox();
//        String expRightBox = ConfigReader.initProp().getProperty("rightBox");
//        Assert.assertEquals(actRightBox, expRightBox);
//    }
//
//    @Test
//    public void middleDescriptionSeleniumTest() {
//        myStorePage = new RegisterPage(driver);
//        String actMiddleDescription = myStorePage.getMiddleDescription();
//        String expMiddleDescription = ConfigReader.initProp().getProperty("middleDescription");
//        Assert.assertEquals(actMiddleDescription, expMiddleDescription);
//    }
//
//    @Test
//    public void validateDescriptionOfWebsiteTest() {
//        myStorePage = new RegisterPage(driver);
//        String actSeleniumArticleText = myStorePage.getSeleniumArticleDescription();
//        String expSeleniumArticleText = ConfigReader.initProp().getProperty("seleniumArticleText");
//        Assert.assertEquals(actSeleniumArticleText, expSeleniumArticleText);
//    }
//
//    @Test
//    public void validateFollowUsSeleniumLinksTest() {
//        myStorePage = new RegisterPage(driver);
//        List<String> actLinksList = myStorePage.getFollowUsSeleniumLinks();
//        List<String> expLinksList = new ArrayList<>(Arrays.asList("https://www.facebook.com/groups/525066904174158/", null, null, null));
//        Assert.assertEquals(actLinksList, expLinksList);
//    }
//
//    @DataProvider
//    public Iterator<Object[]> getFooterMyAccount() {
//        ArrayList<Object[]> testData = TestUtil.getFooterMyAccount();
//        return testData.iterator();
//    }
//
//    @Test(dataProvider = "getFooterMyAccount")
//    public void validateFooterMyAccount(String myOrders, String myCreditSlips, String myAddresses, String myPersonalInfo){
//
//        myStorePage = new RegisterPage(driver);
//        List<String> actFooterMyAccountList = myStorePage.getFooterMyAccount();
//        List<String> expFooterMyAccountList = new ArrayList<>(Arrays.asList(myOrders, myCreditSlips, myAddresses, myPersonalInfo));
//        Assert.assertEquals(actFooterMyAccountList, expFooterMyAccountList);
//    }
//
//    @DataProvider
//    public Iterator<Object[]> getFooterInformation() {
//        ArrayList<Object[]> testData = TestUtil.getFooterInformation();
//        return testData.iterator();
//    }
//
//    @Test(dataProvider = "getFooterInformation")
//    public void validateFooterInformation(String specials, String newProducts, String bestSellers,
//                                          String ourStores, String contactUs, String terms, String aboutUs, String siteMap){
//
//        myStorePage = new RegisterPage(driver);
//        List<String> actFooterInformationList = myStorePage.getFooterInformation();
//        List<String> expFooterInformationList = new ArrayList<>(Arrays.asList(specials, newProducts, bestSellers, ourStores, contactUs, terms, aboutUs, siteMap));
//        Assert.assertEquals(actFooterInformationList, expFooterInformationList);
//    }
//
//    @DataProvider
//    public Iterator<Object[]> getFooterStoreInfo() {
//        ArrayList<Object[]> testData = TestUtil.getFooterStoreInfo();
//        return testData.iterator();
//    }
//
//    @Test(dataProvider = "getFooterStoreInfo")
//    public void validateFooterStoreInfo(String geoLocation, String phone, String email){
//        myStorePage = new RegisterPage(driver);
//        List<String> actFooterStoreInformationList = myStorePage.getStoreInfo();
//        List<String> expFooterStoreInformationList = new ArrayList<>(Arrays.asList(geoLocation, phone, email));
//        Assert.assertEquals(actFooterStoreInformationList, expFooterStoreInformationList);
//    }
}


