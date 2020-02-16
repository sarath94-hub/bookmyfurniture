package services.cart;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class AddToCartRequest extends BasePage{
static RequestSpecification request = null;
	
	public static void addToCartRequest() {		
		request = setBaseURI("rest/api/cart/user/360", "signin");
		CommonData.addToCartRequest =  constructAddToCartParams();
	}
	
	public static void addToCartResponse() {
		try {
			request.body(CommonData.addToCartRequest);
			log.info("Adding to Cart request :" + CommonData.addToCartRequest);
			Response response = request.when().post();
			CommonData.addToCartResponse = response;
			log.info("Adding to Cart response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void verifyaddToCartResponseStatusCode() {
		int statusCode= CommonData.addToCartResponse.path("httpStatusCode");
		Assert.assertEquals(statusCode, 201);
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructAddToCartParams() {
		JSONObject obj = new JSONObject();
		obj.putAll(CommonData.productDetails);
		return obj;
	}
}
