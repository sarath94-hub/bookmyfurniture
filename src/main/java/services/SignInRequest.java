package services;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;

public class SignInRequest extends BasePage{
	
private static RequestSpecification request = null;
	
	public static void signinRequest() {		
		request = setBaseURI("rest/api/login/signin", "signin");
		SignInData.signinRequest = constructSignInRequestParams();
	}
	
	public static void signinResponse() {
		request.body(SignInData.signinRequest);
		log.info("Signin request :" + SignInData.signinRequest);
		Response response = request.when().post();
		SignInData.signinResponse = response;
		log.info("Signin response :" + response.prettyPrint());
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructSignInRequestParams() {
		JSONObject obj = new JSONObject();
		obj.put("emailId", "fsfd6@ff.com");
		obj.put("password", "Test@1234");
		return obj;
	}
	
	public static void verifySigninResponse() {
		int statusCode= SignInData.signinResponse.path("httpStatusCode");
		Assert.assertEquals(statusCode, 200);
	}
}
