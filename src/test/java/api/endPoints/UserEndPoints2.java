package api.endPoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	static ResourceBundle getURL()
	{ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
	return routes;}
	public static Response createUser(User payload)
	{String post_url=getURL().getString("post_url");
		Response response=given()
				
				.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);return response;
		
	}
	public static Response createUser1(User ListofUserPayload) {
		String post_url1=getURL().getString("post_url1");
	Response response=given()
	.body(ListofUserPayload)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(ListofUserPayload)
	.when().
	post(Routes.post_url1);
	return response;
	}
	public static Response createUser2(User ListofUserPayload) {
		String post1_url=getURL().getString("post1_url");
	Response response=given()
	.body(ListofUserPayload)
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(ListofUserPayload)
	.when().
	post(post1_url);
	return response;
	}


	public static Response getUser(String userName)

	{String get_url=getURL().getString("get_url");
	Response response=given()

	.pathParam("username" ,userName)
	.when()
	.get(get_url);return response;

	}

	public static Response getUser1()

	{String get_url1=getURL().getString("get_url1");
	Response response=given()

	.queryParam("username","kranthi")
	.queryParam("password","123@#")

	.when()
	.get(get_url1);return response;

	}

	public static Response getUser2()

	{String get_url2=getURL().getString("get_url2");
	Response response=given()


	.when()
	.get(get_url2);return response;

	}



	public static Response updateUser(User payload,String userName)
	{String update_url=getURL().getString("update_url");
		Response response=given()
				
				.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username",userName)
		.when()
		.put(update_url);return response;
		
	}

	public static Response deleteUser(String userName)

	{String delete_url=getURL().getString("delete_url");
	Response response=given()

	.pathParam("username" ,userName)
	.when()
	.get(delete_url);return response;

	}
}
