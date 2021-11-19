package com.qa.pages;

import org.json.simple.JSONObject;

import com.qa.reports.ExtentLogger;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPromoCode {
	
	
	public String getPromoCode(String mobileNumber) {
		
		
		RestAssured.baseURI = "http://mnkdronawebappdev.azurewebsites.net/api/V1";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		JSONObject DataRequest = new JSONObject();
		requestParams.put("LoginId", mobileNumber);
		DataRequest.put("Data", requestParams);
		request.body(DataRequest.toJSONString());
		Response response = request.post("/FuncForWebAppToGetPromoCodeByLoginId");
		String json = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);
		String promoCode = jsonPath.getJsonObject("data.promoCode");		
		System.out.println(promoCode);
		return promoCode;
	}
    public String getPromoCodeLoadTest(String mobileNumber) {
		
		
		RestAssured.baseURI = "http://mnkdronawebapploadtesting.azurewebsites.net/api/V1";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		JSONObject DataRequest = new JSONObject();
		requestParams.put("LoginId", mobileNumber);
		DataRequest.put("Data", requestParams);
		request.body(DataRequest.toJSONString());
		Response response = request.post("/FuncForWebappToGetPromocodebyloginid");
		String json = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);
		String promoCode = jsonPath.getJsonObject("data.promoCode");		
		System.out.println(promoCode);
		return promoCode;
	}

	public static void main(String[] args) {
		
		GetPromoCode promocode = new GetPromoCode();
		String promoCode = promocode.getPromoCode("8888800000");
	//	String promoCode = promocode.getPromoCodeLoadTest("praveen.singh@yopmail.com");
	}

}


