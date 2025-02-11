package day_four;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

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
	public void test_JSON_Path_Body() {
		
		Response respone=
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/books");
		
	/*	int code=respone.getStatusCode();
		Assert.assertEquals(code,200);
		
		String contentTyp=respone.getContentType();
		
		Assert.assertEquals(contentTyp,"application/json");
		
		String name=respone.jsonPath().get("[2].author").toString();
		Assert.assertEquals(name, "Hamid");
		

//		for reading all data in Json we use json Object Class
		
		JSONObject jo= new JSONObject(respone.toString());		//convert response in jsonOnject type
		
		for(int i=0; i<jo.getJSONArray("book").length(); i++) {
			String title =jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		}
		*/
		JsonPath jsonpath=respone.jsonPath();
		
		List<String> titles =jsonpath.getList("title");
		
		for(int i=0; i<titles.size(); i++) {
			if(titles.get(i).equalsIgnoreCase("Saying of the Centry")) {
				System.out.println("Data is found it....");
			}
			else {
				System.out.println("Try again...");
			}
		}
		
		List<Float> prices=jsonpath.getList("price",Float.class);
		
		double totalprice=0;
		
//		for(Float price: prices) {
//			totalprice=price+totalprice;
//		}
		
		for(int i=0; i<prices.size(); i++) {
			totalprice=totalprice+prices.get(i);
					
		}
		System.out.println("Total price :"  +totalprice);
		
	}

}
