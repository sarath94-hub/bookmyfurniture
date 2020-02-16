package services;

import org.json.simple.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BasePage;
import utils.CommonData;

public class AuthTokenRequest extends BasePage{
	private static RequestSpecification request = null;
	
	public static void authTokenRequest() {		
		request = setBaseURI("oauth/token", "oauth");
		CommonData.authTokenRequest = constructAuthTokenRequestParams();
	}
	
	public static void authTokenResponse() {
		
		log.info("OAuth Token request :" + CommonData.authTokenRequest );
		Response response = request.when().post();
		CommonData.authTokenResponse = response;
		log.info("OAuth Token response :" + response.prettyPrint());
	}
	
	@SuppressWarnings("unchecked")
	private static JSONObject constructAuthTokenRequestParams() {
		JSONObject obj = new JSONObject();
		obj.put("username", "test4@1test.com");
		obj.put("password", "Test@1234");
		obj.put("grant_type", "password");
		request.formParams(obj);
		return obj;
	}
	
	public static void extractTokenDetails() {
		CommonData.accessToken = CommonData.authTokenResponse.path("access_token");
		CommonData.tokenType = CommonData.authTokenResponse.path("token_type");
		log.info(CommonData.tokenType + " " + CommonData.accessToken);
	}
}
