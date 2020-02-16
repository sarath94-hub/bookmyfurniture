package services.search;

import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class SearchRequest extends BasePage {
	static RequestSpecification request = null;
	
	public static void searchRequest() {		
		request = setBaseURI("rest/api/product/search/Sofa", "signin");
	}
	
	public static void searchResponse() {
		log.info("Search Sofa request :" + CommonData.searchRequest);
		Response response = request.when().get();
		CommonData.searchResponse = response;
		log.info("Search Sofa response :" + response.prettyPrint());
	}
	
	public static void verifySearchResponse() {
		int statusCode= CommonData.searchResponse.path("httpStatusCode");
		Assert.assertEquals(statusCode, 302);
	}
	
	public static void extractPidFromSearchResponse() {
		try {
			CommonData.pid = CommonData.searchResponse.path("body[0].pid");
			log.info("Product ID is : " + CommonData.pid);
		} catch (ClassCastException cce) {
			log.error(cce.getStackTrace());
		}
	}
}
