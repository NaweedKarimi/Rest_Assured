package day_Three;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	
//	@Test(priority = 1)
	public void testHeader() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Server","gws")
		
		;
		
	}
	
	@Test(priority = 2)
	public void testHeaders() {
		
		Response response=
		given()
		
		.when()
			.get("https://www.google.com/");
		
//		Get single header
		String server_value=response.getHeader("Server");
		System.out.println(server_value);
		
//		Get all header the return type is headers like map
		 Headers all_header_info=response.getHeaders();
		 
		 for(Header k:all_header_info) {
			 
			 System.out.println(k.getName()+  "  "+ k.getValue());
		 }
	}

}
