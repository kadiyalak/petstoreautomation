package api.endPoints;
import static io.restassured.RestAssured.given;

import api.payLoad.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StoreEndPoints {
	public static Response createUser(Store payload)
	{
		Response response=given()
				
				.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);return response;
		
	}

	public static Response getUser(int id) 

	{
	Response response=given()

	.pathParam("orderId" ,id)
	.when()
	.get(Routes.get_url);return response;

	}

public static Response getUser1()
	
	{
		
	Response response=	given()
		
		.get(Routes.update_url);return response;
		
		
	}

	public static Response deleteUser(int  id)

	{
	Response response=given()

	.pathParam("orderId" ,id)
	.when()
	.get(Routes.delete_url);return response;

	}
	
	}
