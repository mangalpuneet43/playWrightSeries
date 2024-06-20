package playwrightFactory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class playWrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    static Page page;
   static ThreadLocal<Browser> tlBrowser=new ThreadLocal<>();
   static ThreadLocal<Page>tlPage=new ThreadLocal<>();
  static  ThreadLocal<BrowserContext> tlBrowserContext=new ThreadLocal<>();
  static  ThreadLocal<Playwright>tlPlayWright=new ThreadLocal<>();
    private static Playwright getPlaywright(){
        return tlPlayWright.get();
    }
    private static Browser getBrowser(){
        return tlBrowser.get();
    }
    private static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }
    private static Page getPage(){
        return tlPage.get();
    }

    public Page initBrowser(Properties prop){
   // playwright=Playwright.create();
        tlPlayWright.set(Playwright.create());
    switch (prop.getProperty("browserName")){
        case "chromium" :
          //  browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
              tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            break;
        case "firefox" :
           // browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            break;
        case "edge" :
          //  browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            break;
        case "chrome" :
            BrowserType.LaunchOptions options=new BrowserType.LaunchOptions();
            options.setChannel("chrome");
            options.setHeadless(false);
            tlBrowser.set(getPlaywright().chromium().launch(options));
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + prop.getProperty("browserName"));
    }
      // browserContext= browser.newContext();
        tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1920,1080)));
       //page=browserContext.newPage();
        tlPage.set(getBrowserContext().newPage());
       getPage().navigate(prop.getProperty("URL"));

        return getPage();
    }


// this method is used to initialise the config file

    public Properties initProperties() {
       Properties properties;
        try {
            FileInputStream is=new FileInputStream("./src/main/java/resources/Config/config.properties");
           properties=new Properties();
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }


    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }


}
