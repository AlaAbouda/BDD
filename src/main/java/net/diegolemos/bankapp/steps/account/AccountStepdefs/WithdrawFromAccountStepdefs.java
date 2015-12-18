package net.diegolemos.bankapp.steps.account.AccountStepdefs;


import org.assertj.core.api.Assertions;

import bibliotheque.ReadConfFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.codestory.simplelenium.SeleniumTest;
import net.diegolemos.bankapp.account.Account;
import net.diegolemos.bankapp.all.MenuHeader;
import net.diegolemos.bankapp.client.Client;


public class WithdrawFromAccountStepdefs extends SeleniumTest {
	
	private Account account = new Account();
	
	@Before
	  public void initializeSystem() throws Exception {
		String[] paramServer = ReadConfFile.Get_Info("1");	
		String url = paramServer[0];
		goTo(url);
	  }
	
	 public void initializeUser(String nameClient, String amount) throws Exception {
		 	MenuHeader menu = new MenuHeader();
			menu.clickClients();
			Client client = new Client();		
			client.addNewClient(nameClient);	
			menu.clickAccounts();		
			account.searchClientSimple(nameClient);
			account.addNewTransaction( amount, "DEPOSIT", "1");
		  }
	
	
	@Given("^an existing client named (.*) with (.*) EUR in his account$")
	public void an_existing_client_named_pierre_jean_with_EUR_in_his_account(String nameClient, String amount) throws Throwable {
		initializeUser( nameClient,  amount) ;
		String totalBalance = account.getBalance();
		Assertions.assertThat(Boolean.TRUE);
		Assertions.assertThat(Float.parseFloat(totalBalance)).isEqualTo(Float.parseFloat(amount));
	}
	
	
	
	@When("^he withdraws (.*) EUR from his account$")
	public void he_withdraws_EUR_from_his_account(String amount) throws Throwable {
		amount = "-" + amount;
		int nb = account.getNBTransaction() + 1;
		account.addNewTransaction(amount, "DEPOSIT",  Integer.toString(nb));
	}
	
	@When("^he deposit (.*) EUR from his account$")
	public void he_deposit_EUR_from_his_account(String amount) throws Throwable {
		int nb = account.getNBTransaction() + 1;
		account.addNewTransaction(amount, "DEPOSIT",  Integer.toString(nb));
	}
	
	@Then("^the new balance is (.*) EUR$")
	public void the_new_balance_is_EUR(String amount) throws Throwable {
		String totalBalance = account.getBalance();
		Assertions.assertThat(Boolean.TRUE);
		Assertions.assertThat(Float.parseFloat(totalBalance)).isEqualTo(Float.parseFloat(amount));
	}
	 
	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
