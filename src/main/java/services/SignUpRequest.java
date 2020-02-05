package services;

import org.json.simple.JSONObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;

public class SignUpRequest extends BasePage{

	static RequestSpecification request = null;
	
	public static void signupRequest() {		
		request = setBaseURI("signup/");
		SignUpData.signupRequest = constructSignUpRequestParamas();
	}
	
	public static void signupResponse() {
		request.body(SignUpData.signupRequest);
		log.info("Signup request :" + SignUpData.signupRequest);
		Response response = request.when().post();
		SignUpData.signupResponse = response;
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
}
