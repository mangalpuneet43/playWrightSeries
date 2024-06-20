package playWrightTest;

import BaseTest.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test
    public void verifyLogin() throws InterruptedException {
     homePage.clickLoginLink();
     loginPage.doLogin("mangalpuneet","1234556");
     Thread.sleep(5000);
}

    @Test
    public void verifyForgotPasswordLink() throws InterruptedException {
        homePage.clickLoginLink();
        Assert.assertTrue(loginPage.isForgotPasswordLinkVisible(),"Forgot password link visible");
        Thread.sleep(5000);
    }



}
