package Day_One;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
 * 		Given()---> Content Tupe, set cookies, add auth, add param, set header info...
 * 		When()---> methods like get post put and delete
 * 		Then()---> validation point--> valid status code, extract header, cookies and response body
 * 
 */

public class HTTPRequest {
	
	int id;

	 @Test(priority = 1)
	public void getUser() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.body("total", equalTo(12))
				.body("data.id", hasItems(7, 8, 9, 10, 11, 12))
				.body("data.email", hasItem("rachel.howell@reqres.in"))

				.log().all();

	}

	@Test(priority = 2)
	public void createUser() {
		HashMap data = new HashMap();

		data.put("name", "Naweed");
		data.put("Job", "student");

		  id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

		System.out.println(id);

//		.then()
//			.statusCode(201)
//			.log().all();

	}

	@Test(priority = 3, dependsOnMethods = {"createUser"} )
	public void updateUser() {

		HashMap data = new HashMap();

		data.put("name", "Naweed");
		data.put("Job", "Trainer");
	
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users"+id)
			
		.then()
		.statusCode(201)
		.log().all();	
		
		System.out.println(data.entrySet());

	}
	
	
	@Test(priority = 4)
	public void deleteUser() {
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
		
	}
}
