/*package api.endPoints;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import java.util.List;import java.util.ArrayList;
import io.restassured.http.ContentType;
import io.restassured.response.Response;import api.payLoad.User;

userEndPoints.java
Created for perform Create,Read,Update,Delete requests the user API.
public class UserEndPoints {
public static Response createUser(User payload)
{
	Response response=given()
			
			.contentType(ContentType.JSON)
.accept(ContentType.JSON)
	.body(payload)
	.when()
	.post(Routes.post_url);return response;
	
}
public static Response createUser1(User ListofUserPayload) {
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
Response response=given()
.body(ListofUserPayload)
.contentType(ContentType.JSON)
.accept(ContentType.JSON)
.body(ListofUserPayload)
.when().
post(Routes.post_url2);
return response;
}


public static Response getUser(String userName)

{
Response response=given()

.pathParam("username" ,userName)
.when()
.get(Routes.get_url);return response;

}

public static Response getUser1()

{
Response response=given()

.queryParam("username","kranthi")
.queryParam("password","123@#")

.when()
.get(Routes.get_url1);return response;

}

public static Response getUser2()

{
Response response=given()


.when()
.get(Routes.get_url2);return response;

}



public static Response updateUser(User payload,String userName)
{
	Response response=given()
			
			.contentType(ContentType.JSON)
.accept(ContentType.JSON)
	.body(payload)
	.pathParam("username",userName)
	.when()
	.put(Routes.update_url);return response;
	
}

public static Response deleteUser(String userName)

{
Response response=given()

.pathParam("username" ,userName)
.when()
.get(Routes.delete_url);return response;

}










}*/










//}