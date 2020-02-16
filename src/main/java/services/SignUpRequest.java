package services;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class SignUpRequest extends BasePage{

	static RequestSpecification request = null;
	
	public static void signupRequest() {		
		request = setBaseURI("rest/api/signup/", "base");
		CommonData.signupRequest = constructSignUpRequestParamas();
	}
	
	public static void signupResponse() {
		request.body(CommonData.signupRequest);
		log.info("Signup request :" + CommonData.signupRequest);
		Response response = request.when().post();
		CommonData.signupResponse = response;
		log.info("Signup response :" + response.prettyPrint());
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructSignUpRequestParamas() {
		JSONObject obj = new JSONObject();
		obj.put("name", "John1");
		obj.put("mobileNo", "8768670788");
		obj.put("emailId", "fsfd6@ff.com");
		obj.put("password", "Test@1234");
		return obj;
	}
	
	public static void verifySignUpResponse() {
		int statusCode= CommonData.signupResponse.path("httpStatusCode");
		Assert.assertEquals(statusCode, 200);
	}
}
