/*package api.endPoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ResourceBundle;

import api.payLoad.Pet1;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints2 {
	
	static ResourceBundle getURL()
	{ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
	return routes;}
	public static Response createPet(Pet1 payload) {
		String post_url=getURL().getString("post_url");
		  Response response=given().log().all()

.contentType(ContentType.JSON) 
.accept(ContentType.XML) 
.body(payload)
.when() 


.post(post_url                               );return response;

} 
	  
	  public static Response createPet1(int petId) {
		  String post_url1=getURL().getString("post_url1");
File myfile=new File("C:\\Users\\yejel\\Pictures\\Screenshots\\Screenshot 2023-05-12 165148.png"); 
Response response= given() .multiPart("file","myfile")
.formParam("Additionalmetadata","uploadimage")
.contentType("multipart/form-data")
.accept(ContentType.JSON)
.pathParam("petId",petId) .log().all()
.when() .post(post_url1);
		  return response; 
		  }
public static Response  postPet1(int petId) 

{String post1_url=getURL().getString("post1_url");
		Response response=given().log().all()
				.contentType("application/x-www-form-urlencoded")
				.formParam("name","julie")
				.formParam("status","available")
				.accept(ContentType.JSON)
		
		.pathParam("petId",petId)
		.when()
		.post(post1_url);return response;
		
	} public static Response getPet(int petId)

{String get_url=getURL().getString("get_url");
		Response response=given().log().all()

.pathParam("petId" ,petId) .when() .get(get_url);return response;

} public static Response getPet1()

{
	String get1_url=getURL().getString("get1_url");
Response response= given().log().all()

.get(get1_url);return response;





}

public static Response updatePet(Pet1  payload) { String update_url=getURL().getString("update_url");Response response=given().log().all()

.contentType(ContentType.JSON) .accept(ContentType.XML) .body(payload)

.when() .put(update_url);return response;

}

public static Response deletePet(int petId)

{ String delete_url=getURL().getString("delete_url");Response response=given().log().all()

.pathParam("petId" ,petId) .when() .delete(delete_url);return response;

}


}*/
