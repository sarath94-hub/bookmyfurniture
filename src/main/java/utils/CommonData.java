package utils;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class CommonData {
	public static JSONObject addToCartRequest = new JSONObject();
	public static Response addToCartResponse = null;
	public static JSONObject deleteFromCartRequest = new JSONObject();
	public static Response deleteFromCartResponse = null;
	public static JSONObject authTokenRequest = new JSONObject();
	public static Response authTokenResponse = null;
	public static String accessToken = "";
	public static String tokenType = "";
	public static JSONObject signinRequest = new JSONObject();
	public static Response signinResponse = null;
	public static JSONObject signupRequest = new JSONObject();
	public static Response signupResponse = null;
	public static JSONObject productRequest = new JSONObject();
	public static Response productResponse = null;
	public static HashMap productDetails = new HashMap();
	public static HashMap reviewCartDetails = new HashMap();
	public static JSONObject searchRequest = new JSONObject();
	public static Response searchResponse = null;
	public static int pid = 0;
	public static int cartId = 0;
	public static JSONObject reviewCartRequest = new JSONObject();
	public static Response reviewCartResponse = null;
	public static JSONObject updateCartRequest = new JSONObject();
	public static Response updateCartResponse = null;
}
