package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	
	  WebDriver driver=	TestBase.getDriver();
	  LoginPage loginPage;
	  ProductListPage listPage;
	  CartPage cartPage;
	  CheckoutPage chkoutPage;
	  
	  public OrderStepDef() {
		  
		  
		  loginPage= new LoginPage(driver);
		  listPage=new ProductListPage(driver);
		  cartPage= new CartPage(driver);
		  chkoutPage=new CheckoutPage(driver);
	  }
	  
	  @Given("User is on login page")
	  public void user_is_on_login_page() {
	      TestBase.openUrl("https://www.saucedemo.com/");
	  }
	  @When("user enters {string} and {string}")
	  public void user_enters_and(String strUser, String strPwd) {
	      loginPage.login(strUser, strPwd);
	  }
	  @Then("User should be on Home page")
	  public void user_should_be_on_home_page() {
		  boolean isValid= listPage.isOnProducts();
		     Assert.assertTrue(isValid);
	  }
//	  @Given("User should be on Home page")
//	  public void user_should_be_on_home_page() {
//	      // Write code here that turns the phrase above into concrete actions
//	      throw new io.cucumber.java.PendingException();
//	  }
	  @When("User add item to cart")
	  public void user_add_item_to_cart() {
	      listPage.addToCart();
	  }
	  @Then("Item must be added")
	  public void item_must_be_added() {
	      listPage.viewCart();
	      boolean isItemAvail= cartPage.isItemAdded();
	      System.out.println("boolean ....." +isItemAvail);
		  Assert.assertTrue(isItemAvail);
	  }
	  @Given("User is on Cart page")
	  public void user_is_on_cart_page() {
		  listPage.viewCart();
	  }
	  @When("User do checkout")
	  public void user_do_checkout() {
		  cartPage.checkoutItems();
		  
	  }
	  @Then("Should navigate to checkout page")
	  public void should_navigate_to_checkout_page() {
		  chkoutPage.provideDetails("Shalini", "Laura", "600041");
		  chkoutPage.checkoutOrder();
		  Assert.assertTrue(chkoutPage.isOrderSuccess());
	  }
	  
}
