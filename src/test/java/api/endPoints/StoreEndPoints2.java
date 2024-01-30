/*package api.endPoints;

import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;
import api.payLoad.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints2 {
	
	static ResourceBundle getURL()
	{ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
	return routes;}
	
	public static Response createUser(Store payload)
	{
		String post_url=getURL().getString("post_url");
		Response response=given()
				
				.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);return response;
		
	}

	public static Response getUser(int id) 

	{
		String get_url=getURL().getString("get_url");
	Response response=given()

	.pathParam("orderId" ,id)
	.when()
	.get(get_url);return response;

	}

public static Response getUser1()
	
	{
		String update_url=getURL().getString("update_url");
	Response response=	given()
		
		.get(update_url);return response;
		
		
	}

	public static Response deleteUser(int  id)

	{String delete_url=getURL().getString("delete_url");
	Response response=given()

	.pathParam("orderId" ,id)
	.when()
	.get(delete_url);return response;

	}
}*/
