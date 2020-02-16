package services.cart;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class UpdateQuantityInCart extends BasePage {
	static RequestSpecification request = null;

	public static void updateQuantityInCartRequest() {
		request = setBaseURI("rest/api/cart/", "signin");
		CommonData.updateCartRequest = constructUpdateCartParams();
	}
	
	public static void updateCartResponse() {
		try {
			request.body(CommonData.updateCartRequest);
			log.info("Updating quantity in Cart request :" + CommonData.updateCartRequest);
			Response response = request.when().put();
			CommonData.updateCartResponse = response;
			log.info("Updating quantity in Cart response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void verifyUpdateCartResponseStatusCode() {
		try {
			int statusCode = CommonData.updateCartResponse.path("httpStatusCode");
			Assert.assertEquals(statusCode, 200);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructUpdateCartParams() {
		JSONObject obj = new JSONObject();
		obj.putAll(CommonData.reviewCartDetails);
		return obj;
	}
}
