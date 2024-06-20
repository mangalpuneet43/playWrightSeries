package BaseTest;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import playwrightFactory.Pages.HomePage;
import playwrightFactory.Pages.LoginPage;
import playwrightFactory.playWrightFactory;

import java.util.Properties;

public class TestBase {

    playWrightFactory pf;
    Page page;
    protected HomePage homePage;
    protected Properties prop;
    protected LoginPage loginPage;
    @BeforeTest
    public void setup(){
        pf=new playWrightFactory();
        prop=pf.initProperties();
        page= pf.initBrowser(prop);
        homePage=new HomePage(page);
        loginPage=new LoginPage(page);
    }

    @AfterTest
    public void tearDown(){
        page.close();
    }



}
