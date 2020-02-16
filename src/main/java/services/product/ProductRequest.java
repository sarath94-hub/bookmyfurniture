package services.product;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class ProductRequest extends BasePage{
static RequestSpecification request = null;
	
	public static void productRequest() {
		try {
			request = setBaseURI("rest/api/product/" + CommonData.pid, "signin");
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void productResponse() {
		try {
			log.info("Product Sofa request :" + CommonData.productRequest);
			Response response = request.when().get();
			CommonData.productResponse = response;
			log.info("Product Sofa response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void verifyProductResponse() {
		try {
			int statusCode = CommonData.productResponse.path("httpStatusCode");
			Assert.assertEquals(statusCode, 302);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void extractProductDetails() {
		try {
			CommonData.productDetails = CommonData.productResponse.path("body");
			log.info("Body of product " + CommonData.productDetails);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
}
