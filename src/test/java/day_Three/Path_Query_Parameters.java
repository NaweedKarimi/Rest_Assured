package day_Three;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

/*
 * Path and Query Parameter 
 * --> Path url befor question Mark
 * -->Query parameter filter data in server
 */

public class Path_Query_Parameters {
	
	@Test
	public void testQueryPathParameters() {
		
		//https://reqres.in/api/users?page=2
		given()
			.pathParam("mypath","users")	//path parameter
			.queryParam("page", 2)			//Query paramter
			.queryParam("id",5)				// query param
		
		.when()
//			.get("https://reqres.in/api/users?page=2")
			.get("https://reqres.in/api/{mypath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
