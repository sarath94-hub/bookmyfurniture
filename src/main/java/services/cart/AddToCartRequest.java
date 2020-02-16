package services.cart;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import services.product.ProductData;
import utils.BasePage;

public class AddToCartRequest extends BasePage{
static RequestSpecification request = null;
	
	public static void addToCartRequest() {		
		request = setBaseURI("rest/api/cart/user/360", "signin");
		AddToCartData.addToCartRequest =  constructAddToCartParams();
	}
	
	public static void addToCartResponse() {
		try {
			request.body(AddToCartData.addToCartRequest);
			log.info("Adding to Cart request :" + AddToCartData.addToCartRequest);
			Response response = request.when().post();
			AddToCartData.addToCartResponse = response;
			log.info("Adding to Cart response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void verifyaddToCartResponseStatusCode() {
		int statusCode= AddToCartData.addToCartResponse.path("httpStatusCode");
		Assert.assertEquals(statusCode, 201);
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructAddToCartParams() {
		JSONObject obj = new JSONObject();
		obj.putAll(ProductData.productDetails);
		return obj;
	}
}
