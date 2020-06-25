package scripts;

import org.testng.annotations.Test;

import Config.StartBrowser;
import Custcommands.ActionDriver;
import objrepo.Homepage;
import objrepo.Partnerpage;
import objrepo.Passwordpage;
import objrepo.Signinpage;


public class  TC1 extends StartBrowser {
  @Test
  public void testgSign_out () throws Exception {
  
  ActionDriver aDriver = new ActionDriver();
  aDriver.launchApplication("http://xpoconnecteuuat.xpo.com");
  aDriver.click(Homepage.btnLogin, "Loginbutton");
  aDriver.type(Signinpage.txtusername, "ltluser@gmail.com"); 
  aDriver.click(Signinpage.btnNext, "Next button");
  aDriver.type(Passwordpage.txtpwd, "Password");
  aDriver.click(Passwordpage.btnSignin, "Signinbtn");
  aDriver.click(Partnerpage.radiobtn, "Radiobtn");
  aDriver.click(Partnerpage.btnSelect, "Selectbtn");

  }
}
