package services.cart;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class ReviewCartRequest extends BasePage {
	static RequestSpecification request = null;

	public static void reviewCartRequest() {
		request = setBaseURI("rest/api/cart/360", "signin");
	}

	public static void reviewCartResponse() {
		try {
			log.info("Review Cart request :" + CommonData.reviewCartRequest);
			Response response = request.when().get();
			CommonData.reviewCartResponse = response;
			log.info("Review Cart response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}

	public static void verifyReviewCartResponseStatusCode() {
		try {
			int statusCode = CommonData.reviewCartResponse.path("httpStatusCode");
			Assert.assertEquals(statusCode, 302);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void extractCartIdDetails() {
		try {
			CommonData.cartId = CommonData.reviewCartResponse.path("body[0].cartId");
			CommonData.reviewCartDetails = CommonData.reviewCartResponse.path("body[0]");
			log.info("Body of product " + CommonData.cartId);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
}
