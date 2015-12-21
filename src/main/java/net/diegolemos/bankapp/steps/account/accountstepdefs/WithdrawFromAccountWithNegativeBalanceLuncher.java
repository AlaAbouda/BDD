
package net.diegolemos.bankapp.steps.account.accountstepdefs;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Run action.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = 
  { "src/specs/features/withdrawFromAccountWithNegativeBalance.feature" },
		format = {
    "html:target/cucumber-report/withdrawFromAccountWithNegativeBalance" })
public class WithdrawFromAccountWithNegativeBalanceLuncher {

}

