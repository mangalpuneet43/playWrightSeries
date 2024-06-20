package playwrightFactory.Pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;

public class HomePage {
    Page page;
//String locators
    private String search="input[name='search']";
    private String searchIcon="div#search button";
    private String searchHeader="div#content h1";
    private String loginLink="a:text('Login')";
    private String myAccountLink="a[title='My Account']";

    // Page constructor

    public HomePage(Page page){
        this.page=page;
    }
    public String getHomePageTitle(){
        return page.title();
    }
    public String getURL(){
        return page.url();
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        return page.textContent(searchHeader);
    }
    public void clickLoginLink(){
        page.click(myAccountLink);
       page.click(loginLink);
    }


}
