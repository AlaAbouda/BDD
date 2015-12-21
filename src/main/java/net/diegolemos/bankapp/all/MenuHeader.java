package net.diegolemos.bankapp.all;

import net.codestory.simplelenium.SeleniumTest;
import org.openqa.selenium.By;
import java.io.IOException;


/**
 * name of class : MenuHeader.
 * description   : The navigation of the menu
 * @version : 1.0 
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class MenuHeader extends SeleniumTest {

  /** Click Clients. 
   *  @throws IOException  If an input exception occurred */
  public final void clickClients() throws IOException {
		find(By.xpath(Repository.getPathClients())).click();
	}

	/** Click Accounts. 
   *  @throws IOException  If an input exception occurred */
	public final void clickAccounts() throws IOException {
		find(By.xpath(Repository.getPathAccounts())).click();
	}

	/** Click BankApp. 
	 *  @throws IOException  If an input exception occurred */
	public final void clickBankApp()throws IOException {
		find(By.xpath(Repository.getPathBankApp())).click();
	}

	/**class Repository. */
	public static class Repository {

	  /**Path Client. 
    * @return the link of client */
		public static String getPathClients() {
			return ".//*[@href='#/clients']";
		}
		
    /**Path Account. 
    * @return the link of BankAPP */
		public static String getPathAccounts() {
			return ".//*[@href='#/accounts']";
		}
		
		/** Path BankApp. 
		 * @return the link of  BankAPP */
		public static String getPathBankApp() {
			return ".//*[@href='#']";
		}
	}

	@Override
	protected final String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
