package services;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class AuthTokenData {
	public static JSONObject authTokenRequest = new JSONObject();
	public static Response authTokenResponse = null;
	public static String accessToken = "";
	public static String tokenType = "";
}
