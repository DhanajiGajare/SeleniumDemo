package testNGTFramework;


import io.github.bonigarcia.wdm.WebDriverManager;
import testNGFramework.AbstractComponent.AbstractComponent;
import testNGFramework.pageobject.CartPage;
import testNGFramework.pageobject.CheckOutPage;
import testNGFramework.pageobject.ConfirmationPage;
import testNGFramework.pageobject.LandingPage;
import testNGFramework.pageobject.OrderPage;
import testNGFramework.pageobject.ProductCatelogue;
import testNGFramework.testComponents.BaseTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;



public class SubmitOrderTest  extends BaseTest{


    @Test(groups="purchaseOrder",dataProvider="getData")
   //if we have short data then we can use this way but if we have 1000 fields then we can not use this way
    // public void SubmitOrderTest(String email,String password,String productName) 
    public void SubmitOrderTest(HashMap<String,String>input) {
    			  	 
		  ProductCatelogue productCatelogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		  List<WebElement> products=productCatelogue.getProductList();
		  productCatelogue.addproductToCart(input.get("product"));
		  CartPage cartPage=productCatelogue.goToCartPage(); 
		  Boolean match=cartPage.verifyProductName(input.get("product")); 
		  Assert.assertTrue(match);
		  CheckOutPage checkOutPage =cartPage.goToCheckOut();
		  checkOutPage.selectCountry("india");
		  ConfirmationPage confirmationPage=checkOutPage.submitOrder(); 
		  String message=confirmationPage.confirmationPage();
		  Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order.")); 
		
	}
    
    
    @Test(dependsOnMethods="SubmitOrderTest",dataProvider="getData")
    public void orderHistoryConfirmation(HashMap<String,String>input)
    {
    	
    	 ProductCatelogue productCatelogue =landingPage.loginApplication(input.get("email"),input.get("password"));
    	 OrderPage orderPage=new OrderPage(driver);
    	 orderPage.orderConfirmation();
		 boolean match1=orderPage.historyCheck(input.get("product"));
    	
    }
    
    
    @DataProvider
    public Object[][] getData()
    {
    	
		
		  HashMap<Object,Object> map=new HashMap<Object,Object>();
		 
		  map.put("email", "dhanaji@gmail.com");
		  map.put("password", "Dhanaji@123");
		  map.put("product", "ZARA COAT 3");
		 
    	  return new Object[][]{{map}};
    	
    	//1 return new Object[][]{{"dhanaji@gmail.com","Dhanaji@123","ZARA COAT 3"}};
    }
    

}
