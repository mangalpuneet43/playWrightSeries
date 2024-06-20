package playWrightTest;

import BaseTest.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import playwrightFactory.AppConstants;


public class HomePageTest extends TestBase {


    @Test
    public void homePageTitleTest(){
        Assert.assertEquals( homePage.getHomePageTitle(), AppConstants.yourStoreTitle);
    }

    @Test
    public void homePageUrlTest(){
        Assert.assertEquals( homePage.getURL(),prop.getProperty("URL"));
    }


    @Test
    public void searchTest(){

        Assert.assertEquals( homePage.doSearch("macbook"),AppConstants.searchHeader);
    }






}
