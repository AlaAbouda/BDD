package net.diegolemos.bankapp.steps.account.accountstepdefs;

import org.assertj.core.api.Assertions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.codestory.simplelenium.SeleniumTest;
import net.diegolemos.bankapp.account.Account;
import net.diegolemos.bankapp.all.MenuHeader;
import net.diegolemos.bankapp.bibliotheque.ReadConfFile;
import net.diegolemos.bankapp.client.Client;
//import static  net.codestory.simplelenium.driver.

/**
 * Name of class : WithdrawFromAccount. Description : all action in accounts
 * 
 * @version : 1.0
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class WithdrawFromAccount extends SeleniumTest {

  /**
   * instantiation of the account variable.
   */
  private Account account = new Account();
  
  //public WebDriver webDriver = new   FirefoxDriver();
  
  /**
   * Open browser and go to URL.
   */
  @Before
  public final void initializeSystem() {
    //System.out.println(Browser.FIREFOX);
   // System.setProperty("browser", "firefox");
    System.out.println("2");
    String[] paramServer = ReadConfFile.getInfo("1");
    String url = paramServer[0];
    goTo(url);
  }

  /**
   * Go to client, add client, go to account, find client and add operation.
   * @param nameClient
   *          name of client
   * @param amount
   *          amount of transaction
   * @throws Exception
   *           If any problem.
   * @throws InterruptedException
   *           exception thread sleep.
   */
  public final void initializeUser(final String nameClient, 
      final String amount) throws Exception {
    MenuHeader menu = new MenuHeader();
    menu.clickClients();
    Client client = new Client();
    client.addNewClient(nameClient);
    menu.clickAccounts();
    account.searchClientSimple(nameClient);
    account.addNewTransaction(amount, "DEPOSIT", "1");
  }

  /**
   * Go to client, add client, go to account, find client and add operation.
   * @param nameClient
   *          name of client
   * @param amount
   *          amount of transaction
   * @throws Exception
   *           If any problem.
   * @throws InterruptedException
   *           exception thread sleep.
   */
  @Given("^an existing client named (.*) with (.*) EUR in his account$")
  public final void anExistingClientWithEURInHisAccount(
      final String nameClient, final String amount)
      throws Exception {
    System.out.println("aaa");
    initializeUser(nameClient, amount);
    String totalBalance = account.getBalance();
    Assertions.assertThat(Boolean.TRUE);
    Assertions.assertThat(Float.parseFloat(totalBalance)).isEqualTo(
        Float.parseFloat(amount));

  }

  /**
   * Add operation.
   * @param amount
   *          amount of transaction
   * @throws Exception
   *           If any problem.
   */
  @When("^he withdraws (.*) EUR from his account$")
  public final void heWithdrawsEURFromHisAccount(
      final String amount) throws Exception {
    String amountOperation = "-" + amount;
    int nb = account.getNBTransaction() + 1;
    account.addNewTransaction(amountOperation, "DEPOSIT", Integer.toString(nb));
  }

  /**
   * Go to client, add client, go to account, find client and add operation.
   * 
   * @param amount
   *          amount of transaction
   * @throws Exception
   *           If any problem.
   */
  @When("^he deposit (.*) EUR from his account$")
  public final void heDepositEURFromHisAccount(
      final String amount) throws Exception {
    int nb = account.getNBTransaction() + 1;
    account.addNewTransaction(amount, "DEPOSIT", Integer.toString(nb));
  }

  /**
   * Go to account, verify total of balance.
   * 
   * @param amount
   *          amount of transaction
   * @throws Exception
   *           If any problem.
   * @throws InterruptedException
   *           exception thread sleep.
   */
  @Then("^the new balance is (.*) EUR$")
  public final void theNewBalanceIsEUR(final String amount) throws Exception {
    String totalBalance = account.getBalance();
    Assertions.assertThat(Boolean.TRUE);
    Assertions.assertThat(Float.parseFloat(totalBalance)).
    isEqualTo(Float.parseFloat(amount));
  }

  @Override
  protected final String getDefaultBaseUrl() {
    // TODO Auto-generated method stub
    System.out.println("1");
    return "FIREFOX";
  }
  
  

}
