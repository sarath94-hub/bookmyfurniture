package services.product;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import services.search.SearchData;
import utils.BasePage;

public class ProductRequest extends BasePage{
static RequestSpecification request = null;
	
	public static void productRequest() {
		try {
			request = setBaseURI("rest/api/product/" + SearchData.pid, "signin");
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void productResponse() {
		try {
			log.info("Product Sofa request :" + ProductData.productRequest);
			Response response = request.when().get();
			ProductData.productResponse = response;
			log.info("Product Sofa response :" + response.prettyPrint());
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void verifyProductResponse() {
		try {
			int statusCode = ProductData.productResponse.path("httpStatusCode");
			Assert.assertEquals(statusCode, 302);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
	
	public static void extractProductDetails() {
		try {
			ProductData.productDetails = ProductData.productResponse.path("body");
			log.info("Body of product " + ProductData.productDetails);
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}
}
