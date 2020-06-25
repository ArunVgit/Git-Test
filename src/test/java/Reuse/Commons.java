package Reuse;

import Config.StartBrowser;
import Custcommands.ActionDriver;
import objrepo.Homepage;
import objrepo.Partnerpage;
import objrepo.Passwordpage;
import objrepo.Signinpage;

public class Commons  {
   public ActionDriver aDriver;
   
   public Commons()
   {
	   
	   aDriver= new ActionDriver() ;
   }	
	
	
  public void signIn() throws Exception {

	  StartBrowser.childTest= StartBrowser.parentTest.createNode("Sign in to xpo");
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
