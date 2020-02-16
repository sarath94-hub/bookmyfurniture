package services.product;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class ProductData {
	public static JSONObject productRequest = new JSONObject();
	public static Response productResponse = null;
	public static HashMap productDetails = new HashMap();
}
