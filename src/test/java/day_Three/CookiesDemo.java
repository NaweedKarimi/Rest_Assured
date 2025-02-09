package day_Three;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
//	@Test(priority = 1)
	public void testCookies() {
	
		given()
			.contentType("application.json")
			.log().body()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.statusCode(200)
			.cookie("AEC","ADD");

	}
	
	
	@Test(priority = 2)
	public void getCookies() {
		
		Response res=
		given()
		
		.when()
			.get("https://www.google.com/");
		
//		get single cookie
		
		String Sing_Cookie_info=res.getCookie("AEC");
		System.out.println(Sing_Cookie_info);

//		get all cookies info
		
		Map<String, String> all_Cookies=res.getCookies();
		
//		System.out.println(all_Cookies.entrySet());
		
		for(String k: all_Cookies.keySet()) {
			String value= res.getCookie(k);
			System.out.println(k+"    "+value);
		}
	
	}


}
