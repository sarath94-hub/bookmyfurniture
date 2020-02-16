package services.search;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class SearchData {
	public static JSONObject searchRequest = new JSONObject();
	public static Response searchResponse = null;
	public static int pid = 0;
}
