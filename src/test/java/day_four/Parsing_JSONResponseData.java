package day_four;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Parsing_JSONResponseData {
	
	
//	@Test(priority = 1)
	public void test_Json_Path() {
//		Response respone=
		given()
			.contentType("application.json")
			
		
		.when()
			.get("http://localhost:3000/books")
		
		.then()
			.statusCode(200)
			.header("Connection","keep-alive")
			.body("[2].author", equalTo("Hamid"))
			.log().body();
			
	}
	
	@Test(priority = 2)
	public void test_JSON_Path() {
		
		Response respone=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/books");
		
		int code=respone.getStatusCode();
		Assert.assertEquals(code,200);
		
		String contentTyp=respone.getContentType();
		Assert.assertEquals(contentTyp,"application/json");
		
		String name=respone.jsonPath().get("[2].author").toString();
		Assert.assertEquals(name, "Hamid");
		
		
		for(int i=0; i<)
		
	
		
		
		
	}

}
