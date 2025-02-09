package Day_Two;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

/*
 * How many ways to create request body using post Request
 * 1- Using HashMap
 * 2-Using Org.json
 * 3- POJO (Plain old java Object)
 * 4- External Json file
 */

public class Way_To_Create_Post_Request_Body {

	String id;

//	@Test(priority = 1)
	public void Test_Post_Using_HashMap() {

		HashMap data = new HashMap();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "222333444");

		String courseArr[] = { "Java", "Python" };
		data.put("course", courseArr);

		id = given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students").jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.body("name", equalTo("Scott"))
//			.body("location",equalTo("France"))
//			.body("course[0]", equalTo("Java"))
//			.body("course[1]",equalTo("Python"))
//			.log().all();
	}

//	@Test(priority = 4)
	public void testDelete() {

		given()

				.when().delete("http://localhost:3000/students/" + id)

				.then().statusCode(200);

	}

	
//	Using JSON Libaray 
	
//	@Test(priority = 3)
	public void Test_Post_Uing_JSon_Library() {

//		first we need to create JSON Object 
		JSONObject data = new JSONObject();
		
		
		data.put("name", "Bibi");
		data.put("location", "Kent");
		data.put("phone", "2522762222");
		String courseArr[] = { "C", "Java" };
		data.put("course", courseArr);

		id= given()
				.contentType("application/json")
				.body(data.toString())

				.when()
				.post("http://localhost:3000/students")
				.jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	
	
	//Using POJO Class
	
	@Test(priority = 5)
	public void testUsing_POJO_Class() {
		
		POJO_POST_Request data= new POJO_POST_Request();
		data.setName("Bibi");
		data.setLocation("Kent");
		data.setPhone("266772282");
		String courseArr[] = { "C", "Java" };
		data.setCourse(courseArr);
		
		given()
				.contentType("application/json")
				.body(data)

				.when()
				.post("http://localhost:3000/students")
//				.jsonPath().getString("id");
		.then()
			.statusCode(201)
			.log().all();
		
		
	}

}
