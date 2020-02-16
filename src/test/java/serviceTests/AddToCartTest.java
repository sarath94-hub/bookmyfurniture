package serviceTests;

import org.testng.annotations.Test;

import services.AuthTokenRequest;
import services.SignInRequest;
import services.cart.AddToCartRequest;
import services.cart.DeleteFromCartRequest;
import services.cart.ReviewCartRequest;
import services.cart.UpdateQuantityInCart;
import services.product.ProductRequest;
import services.search.SearchRequest;
import utils.CommonData;
import utils.DriverInfo;

public class AddToCartTest extends DriverInfo{
	
	@Test(priority = 0, groups = { "FullServiceScenario" })
	public void oAuthTokenService() throws Exception {
		test = extent.createTest("Oauth Token", "Token");
		AuthTokenRequest.authTokenRequest();
		appendReqAndResToExtentReport("OAuth Request  " + CommonData.authTokenRequest.toJSONString());
		AuthTokenRequest.authTokenResponse();
		appendReqAndResToExtentReport("OAuth Response  " + CommonData.authTokenResponse.prettyPrint());
		AuthTokenRequest.extractTokenDetails();
	}

	@Test(priority = 1, groups = { "FullServiceScenario" })
	public void signInUsingService() throws Exception {
		test = extent.createTest("SignIn Test", "Login");
		SignInRequest.signinRequest();
		appendReqAndResToExtentReport("SignIn Request  " + CommonData.signinRequest.toJSONString());
		SignInRequest.signinResponse();
		appendReqAndResToExtentReport("SignIn Response  " + CommonData.signinResponse.prettyPrint());
		SignInRequest.verifySigninResponse();
	}
	
	@Test(priority=2, groups = { "FullServiceScenario" })
	public void searchSofaService() throws Exception {
		test = extent.createTest("Search Sofa", "Search");
		SearchRequest.searchRequest();
		appendReqAndResToExtentReport("Search Request  " + CommonData.searchRequest.toJSONString());
		SearchRequest.searchResponse();
		appendReqAndResToExtentReport("Search Response  " + CommonData.searchResponse.prettyPrint());
		SearchRequest.verifySearchResponse();
		SearchRequest.extractPidFromSearchResponse();
	}
	
	@Test(priority=3,groups = { "FullServiceScenario" })
	public void getProductDetailsService() throws Exception {
		test = extent.createTest("Get product details", "Product details");
		ProductRequest.productRequest();
		appendReqAndResToExtentReport("Product Request  " + CommonData.productRequest.toJSONString());
		ProductRequest.productResponse();
		appendReqAndResToExtentReport("Product Response  " + CommonData.productResponse.prettyPrint());
		ProductRequest.verifyProductResponse();
		ProductRequest.extractProductDetails();
	}
	
	@Test(priority=4, groups = { "FullServiceScenario" })
	public void addProductToCart() throws Exception {
		test = extent.createTest("Add product to cart", "Adding product to cart");
		AddToCartRequest.addToCartRequest();
		appendReqAndResToExtentReport("Add to Cart Request  " + CommonData.addToCartRequest.toJSONString());
		AddToCartRequest.addToCartResponse();
		appendReqAndResToExtentReport("Add to Cart Response  " + CommonData.addToCartResponse.prettyPrint());
		AddToCartRequest.verifyaddToCartResponseStatusCode();
	}
	
	@Test(priority=5, groups = { "FullServiceScenario" })
	public void reviewCart() throws Exception {
		test = extent.createTest("Review cart", "review cart");
		ReviewCartRequest.reviewCartRequest();
		appendReqAndResToExtentReport("Review cart Request  " + CommonData.reviewCartRequest.toJSONString());
		ReviewCartRequest.reviewCartResponse();
		appendReqAndResToExtentReport("Review cart Response  " + CommonData.reviewCartResponse.prettyPrint());
		ReviewCartRequest.verifyReviewCartResponseStatusCode();
		ReviewCartRequest.extractCartIdDetails();
	}
	
	@Test(priority=6, groups = { "FullServiceScenario" })
	public void updateCart() throws Exception {
		test = extent.createTest("Update cart", "update cart");
		UpdateQuantityInCart.updateQuantityInCartRequest();
		appendReqAndResToExtentReport("update cart Request  " + CommonData.updateCartRequest.toJSONString());
		UpdateQuantityInCart.updateCartResponse();
		appendReqAndResToExtentReport("update cart Response  " + CommonData.updateCartResponse.prettyPrint());
		UpdateQuantityInCart.verifyUpdateCartResponseStatusCode();
	}
	
	@Test(priority=7, groups = { "FullServiceScenario" })
	public void deleteFromCart() throws Exception {
		test = extent.createTest("Delete product cart", "Delete product cart");
		DeleteFromCartRequest.deleteFromCartRequest();
		appendReqAndResToExtentReport("Delete product Request  " + CommonData.deleteFromCartRequest.toJSONString());
		DeleteFromCartRequest.deleteFromCartResponse();
		appendReqAndResToExtentReport("Delete product Response  " + CommonData.deleteFromCartResponse.prettyPrint());
		DeleteFromCartRequest.verifyDeleteFromcartResponseStatusCode();
	}
}
