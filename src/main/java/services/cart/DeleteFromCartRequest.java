package services.cart;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class DeleteFromCartRequest extends BasePage {
	static RequestSpecification request = null;

	public static void deleteFromCartRequest() {
		request = setBaseURI("rest/api/cart/" + CommonData.cartId, "signin");
	}

	public static void deleteFromCartResponse() {
		try {
			log.info("Delete Product request :" + CommonData.deleteFromCartRequest);
			Response response = request.when().delete();
			CommonData.deleteFromCartResponse = response;
			log.info("Delete Product response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}

	public static void verifyDeleteFromcartResponseStatusCode() {
		try {
			int statusCode = CommonData.deleteFromCartResponse.path("httpStatusCode");
			Assert.assertEquals(statusCode, 200);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
}
