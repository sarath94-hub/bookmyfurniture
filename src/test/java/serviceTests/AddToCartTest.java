package serviceTests;

import org.testng.annotations.Test;

import services.AuthTokenData;
import services.AuthTokenRequest;
import services.SignInData;
import services.SignInRequest;
import services.cart.AddToCartData;
import services.cart.AddToCartRequest;
import services.product.ProductData;
import services.product.ProductRequest;
import services.search.SearchData;
import services.search.SearchRequest;
import utils.DriverInfo;

public class AddToCartTest extends DriverInfo{
	
	@Test(priority = 0, groups = { "FullServiceScenario" })
	public void oAuthTokenService() throws Exception {
		test = extent.createTest("Oauth Token", "Token");
		AuthTokenRequest.authTokenRequest();
		appendReqAndResToExtentReport("OAuth Request  " + AuthTokenData.authTokenRequest.toJSONString());
		AuthTokenRequest.authTokenResponse();
		appendReqAndResToExtentReport("OAuth Response  " + AuthTokenData.authTokenResponse.prettyPrint());
		AuthTokenRequest.extractTokenDetails();
	}

	@Test(priority = 1, groups = { "FullServiceScenario" })
	public void signInUsingService() throws Exception {
		test = extent.createTest("SignIn Test", "Login");
		SignInRequest.signinRequest();
		appendReqAndResToExtentReport("SignIn Request  " + SignInData.signinRequest.toJSONString());
		SignInRequest.signinResponse();
		appendReqAndResToExtentReport("SignIn Response  " + SignInData.signinResponse.prettyPrint());
		SignInRequest.verifySigninResponse();
	}
	
	@Test(priority=2, groups = { "FullServiceScenario" })
	public void searchSofaService() throws Exception {
		test = extent.createTest("Search Sofa", "Search");
		SearchRequest.searchRequest();
		appendReqAndResToExtentReport("Search Request  " + SearchData.searchRequest.toJSONString());
		SearchRequest.searchResponse();
		appendReqAndResToExtentReport("Search Response  " + SearchData.searchResponse.prettyPrint());
		SearchRequest.verifySearchResponse();
		SearchRequest.extractPidFromSearchResponse();
	}
	
	@Test(priority=3,groups = { "FullServiceScenario" })
	public void getProductDetailsService() throws Exception {
		test = extent.createTest("Get product details", "Product details");
		ProductRequest.productRequest();
		appendReqAndResToExtentReport("Product Request  " + ProductData.productRequest.toJSONString());
		ProductRequest.productResponse();
		appendReqAndResToExtentReport("Product Response  " + ProductData.productResponse.prettyPrint());
		ProductRequest.verifyProductResponse();
		ProductRequest.extractProductDetails();
	}
	
	@Test(priority=4, groups = { "FullServiceScenario" })
	public void addProductToCart() throws Exception {
		test = extent.createTest("Add product to cart", "Adding product to cart");
		AddToCartRequest.addToCartRequest();
		appendReqAndResToExtentReport("Add to Cart Request  " + AddToCartData.addToCartRequest.toJSONString());
		AddToCartRequest.addToCartResponse();
		appendReqAndResToExtentReport("Add to Cart Response  " + AddToCartData.addToCartResponse.prettyPrint());
		AddToCartRequest.verifyaddToCartResponseStatusCode();
	}
}
