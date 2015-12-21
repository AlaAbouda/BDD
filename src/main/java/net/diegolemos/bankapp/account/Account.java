package net.diegolemos.bankapp.account;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;

import java.io.IOException;

/**
 * Name of class : Account. 
 * Description : Accounts management 
 * @version : 1.0 
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class Account extends SeleniumTest {

  /**
   * Search client.
   * @param nameClient name of client
   * @throws Exception
   *           exception thread sleep.*/
  public final void searchClientSimple(final String nameClient) 
      throws Exception {
    final long timeSleep = 2000L;
    find(Repository.getTxtIdClient()).sendKeys(nameClient);
    find(By.name(Repository.getBtnNameSearch())).click();
    Thread.sleep(timeSleep);
  }

  /**
   * Add an account.
   * @param amount amount of transaction
   * @param type type operation
   * @param position number of transaction
   * @throws IOException
   *           If an input exception occurred.
   * @throws InterruptedException exception thread sleep.
   */
  
  public final void addNewTransaction(final String amount, 
      final String type, 
      final String position)
      throws InterruptedException, IOException {
    final long timeSleep = 2000L;
    find(By.name(Repository.getBtnNameAddTransaction())).click();
    find(By.xpath(Repository.getTxtNameAmount(position))).fill(amount);
    find(By.xpath(Repository.getCmbNameType(position))).selectByValue(type);
    find(By.name(Repository.getBtnNameSave())).click();
    Thread.sleep(timeSleep);
  }

  /**
   * Get the number of rows of transactions .
   * 
   * @throws IOException
   *           If an input exception occurred
   * @return number of rows of transactions
   */
  public final int getNBTransaction() {
    int xpathCount = find(By.xpath(Repository.getTxtNameAmountAll())).driver()
        .findElements(By.xpath(Repository.getTxtNameAmountAll())).size();
    return (xpathCount);
  }

  /**
   * Get value of balance.
   * 
   * @throws IOException
   *           If an input exception occurred
   * @return value of balance
   */
  public final String getBalance() {
    String element = Repository.getLblClassAmountAll();
    String resultat = find(By.xpath(element)).driver().
        findElement(By.xpath(element)).getText();
    resultat = resultat.replace(" EUR", "");
    return (resultat);
  }

  /** class Repository. */
  public static class Repository {

    /**
     * Id text of client.
     * @return the id of text
     */
    public static String getTxtIdClient() {
      return "#input-username";
    }

    /**
     * name button search.
     * @return the name of button
     */
    public static String getBtnNameSearch() {
      return "searchUserBtn";
    }

    /**
     * name button add transaction.
     * @return the name of button
     */
    public static String getBtnNameAddTransaction() {
      return "addTransactionBtn";
    }

    /**
     * Path text of amount.
     * @param position number of lines 
     * @return the path of text amount
     */
    public static String getTxtNameAmount(final String position) {
      return "(//*[@name='amount'])[" + position + "]";
    }

    /**
     * Path type operation.
     * @param position number of lines
     * @return the path of type operation
     */
    public static String getCmbNameType(final String position) {
      return "(//*[@name='type'])[" + position + "]";
    }

    /**
     * name button save.
     * @return the name of button
     */
    public static String getBtnNameSave() {
      return "saveNewTransactionBtn";
    }

    /**
     * Path result balance.
     * @return the label of total amount
     */
    public static String getTxtNameAmountAll() {
      return ".//*[@name='amount']";
    }

    /**
     * Path name client.
     * @return the name of text
     */
    public static String getLblClassAmountAll() {
      return ".//*[@class='ng-binding']";
    }
  }

  @Override
  protected final String getDefaultBaseUrl() {
    // TODO Auto-generated method stub
    return null;
  }

}
