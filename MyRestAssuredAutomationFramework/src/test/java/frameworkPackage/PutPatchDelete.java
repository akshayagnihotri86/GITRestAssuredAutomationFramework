package frameworkPackage;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;

public class PutPatchDelete {

	@Test(priority= 0)
	public void testPost() {
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
		put("/users/2").
	then().
		statusCode(200)
		.log()
		.all();
	
}
	
	
	@Test(priority= 1)
	public void testPatch() {
	JSONObject request = new JSONObject();
	request.put("name","Akshay");
	request.put("job", "QA");
	System.out.println(request.toJSONString());
	baseURI= "https://reqres.in";
	
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		patch("/api/users/2").
	then().
		statusCode(200)
		.log()
		.all();
	
}
		
	
	@Test(priority= 2)
	public void testDelete() {
	
	baseURI= "https://reqres.in";
	

	when().
		delete("/api/users/2").
	then().
		statusCode(204)
		.log()
		.all();
	
}
	
	
}
