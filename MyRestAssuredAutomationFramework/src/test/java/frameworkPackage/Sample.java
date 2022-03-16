package frameworkPackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Static Import
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Sample {


	//@Test(priority= 1)
	public void sampleTest1() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.header("content-type"));

		int statuscode =response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	
	//@Test (priority= 2)
	public void sampleTest2() {

		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].id",equalTo(9));
	}
	
	
	//@Test(priority= 3)
	public void SampleTest3() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8)).
			body("data[3].first_name",equalTo("Byron")).
			body("data.first_name",hasItems("Byron","Rachel"));
	}
	
	
	
	@Test(priority= 4)
	public void SampleTest4() {
		
		//Map<String,Object> map = new HashMap<String,Object>();
//		map.put("name","Akshay");
//		map.put("job", "QA");		
//		System.out.println(map);
//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name","Akshay");
		request.put("job", "QA");
		System.out.println(request.toJSONString());
		baseURI= "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log()
			.all();
		
	}
}

