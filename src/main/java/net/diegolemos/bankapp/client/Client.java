package net.diegolemos.bankapp.client;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;

import java.io.IOException;

/**
 * name of class : Client. description : Clients management
 * 
 * @version : 1.0 
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class Client extends SeleniumTest {

  
  /**
   * Add client.
   * @param nameClient name of client
   * @throws IOException
   *           If an input exception occurred
   * @throws InterruptedException
   *           exception thread sleep.*/
  public final void addNewClient(final String nameClient) 
      throws InterruptedException, IOException {
    final long timeSleep = 2000L;
    find(By.name(Repository.getTxtNameClient())).sendKeys(nameClient);
    find(By.name(Repository.getBtnNameAdd())).click();
    Thread.sleep(timeSleep);
  }

  /** class Repository. */
  public static class Repository {

    /**
     * Path name client.
     * @return the name of text
     */
    public static String getTxtNameClient() {
      return "addClientInput";
    }

    /**
     * Path button add name client.
     * @return the name of button
     */
    public static String getBtnNameAdd() {
      return "addClientBtn";
    }

  }

  @Override
  protected final String getDefaultBaseUrl() {
    // TODO Auto-generated method stub
    return null;
  }

}
