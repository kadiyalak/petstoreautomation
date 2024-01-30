/*package api.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import api.endPoints.UserEndPoints2;
import api.payLoad.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UserTests2 {
	public Logger  logger;
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setUpData()
	
	{
	
	faker=new Faker();
	userpayload=new User();
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());	
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPassword(faker.internet().password(5,10));	
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	logger=LogManager.getLogger(this.getClass());
	logger.debug("debugging.....");
	}	
	
	@Test(priority=1)
	public void testPostUser()
	{logger.info("**************creating user ****************************");
	Response response=UserEndPoints2.createUser(userpayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************user created ****************************");
	}
	@Test(priority=2)
	public void createListOfUserWithArray() {
		logger.info("**************creatinglist of  user ****************************");
		Map<String,Object> user1=new HashMap<String,Object>();
		
		 user1.put("id", 100);
		user1.put("username", "user123");
		user1.put("firstname","Md.");
		user1.put("lastname","Rahim");
		user1.put("email", "rahim@gamil.com");
		user1.put("password","123@3");
		user1.put("phone","+1999999999");
		user1.put("userstatus", 1);
		
		Map<String,Object> user2=new HashMap<String,Object>();
		
		user2.put("id", 101);
		user2.put("username","user789");
		user2.put("firstname","mohammad");
		user2.put("email","ranich@gmail.com");
		user2.put("password","gh@#");
		
		user2.put("phone","+1999999999");
		user2.put("userstatus",1);
		
		List<Map<String,Object>> jsonArrayPayLoad=new ArrayList();
		jsonArrayPayLoad.add(user1);
		jsonArrayPayLoad.add(user2);
		Gson gson=new Gson();
		String ListofUserPayload=gson.toJson(jsonArrayPayLoad);
		
		Response response=given().
		body(ListofUserPayload).
		contentType("application/json").
		when().
		post("https://petstore.swagger.io/v2/user/createWithList").
		then().
		assertThat().
		statusCode(200).
		log().body().extract().response();
		JsonPath jsonPathEvaluator=response.jsonPath();
		
		jsonPathEvaluator=response.jsonPath();
		
		int valueOfCode=jsonPathEvaluator.get("code");
		String valueOfType=jsonPathEvaluator.get("type");
		String valueOfMessage=jsonPathEvaluator.get("message");
		System.out.println("the value of code attribute is:"+valueOfCode);
		System.out.println("the value of type attribute is:"+valueOfType);
		System.out.println("the value of message Attribute is:"+valueOfMessage);
	Assert.	assertEquals(valueOfCode,200);
		Assert.assertEquals(valueOfType, "unknown");Assert.assertEquals(valueOfMessage, "ok");
	logger.info("**************list of  user created****************************");}
	@Test(priority=3)
	public void createListOfUserWithList()
	{logger.info("**************creating  array of user ****************************");
		Map<String,Object> user1=new HashMap<String,Object>();
		
		 user1.put("id", faker.idNumber().hashCode());
		user1.put("username", faker.name().username());
		user1.put("firstname",faker.name().firstName());
		user1.put("lastname",faker.name().lastName());
		user1.put("email", faker.internet().safeEmailAddress());
		user1.put("password",faker.internet().password(5,10));
		user1.put("phone",faker.phoneNumber().cellPhone());
		user1.put("userstatus", 1);
		
		Map<String,Object> user2=new HashMap<String,Object>();
		
		user2.put("id", faker.idNumber().hashCode());
		user2.put("username",faker.name().username());
		user2.put("firstname",faker.name().firstName());
		user2.put("lastname",faker.name().lastName());
		user2.put("email",faker.internet().safeEmailAddress());
		user2.put("password",faker.internet().password(5,10));
		
		user2.put("phone",faker.phoneNumber().cellPhone());
		user2.put("userstatus",1);
		
		List<Map<String,Object>> userpayload1=new ArrayList();
		userpayload1.add(user1);
		userpayload1.add(user2);
		Gson gson=new Gson();
		String ListofUserPayload=gson.toJson(userpayload1);
		
		Response response=UserEndPoints2.createUser2(userpayload);
		response.then()
		.assertThat().
		statusCode(200).
		log().body().extract().response();
		JsonPath jsonPathEvaluator=response.jsonPath();
		
		jsonPathEvaluator=response.jsonPath();
		
		int valueOfCode=jsonPathEvaluator.get("code");
		String valueOfType=jsonPathEvaluator.get("type");
		String valueOfMessage=jsonPathEvaluator.get("message");
		System.out.println("the value of code attribute is:"+valueOfCode);
		System.out.println("the value of type attribute is:"+valueOfType);
		System.out.println("the value of message Attribute is:"+valueOfMessage);
	Assert.	assertEquals(valueOfCode,200);
		Assert.assertEquals(valueOfType, "unknown");Assert.assertEquals(valueOfMessage, "ok");
		logger.info("**************Array of user created ****************************");
	}
	@Test(priority=4)
	public void testGetUserByName()	
	
	{logger.info("**************displaying user info****************************");
		Response response=UserEndPoints2.getUser(this.userpayload.getUsername());
	
	response.then()
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userJsonSchema.json"))
	.log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************user info displayed ****************************");
}
	@Test(priority=5)
	public void logUserIntoTheSystem()
	{logger.info("**************log into the system ****************************");
		Response response=UserEndPoints2.getUser1();
		 
	response.then()
		.assertThat().
		statusCode(200).
		log().body().
		extract().response();
		JsonPath jsonPathEvaluator=response.jsonPath();
		ValidatableResponse validatableresponse=response.then();
		validatableresponse.body("$", hasKey("code"));
		validatableresponse.body("$",hasKey("type")); 
		validatableresponse.body("$",hasKey("message" ));
		
		validatableresponse.body("code",is(notNullValue())); 
		validatableresponse.body("type",is(notNullValue()));
		validatableresponse.body("message",is(notNullValue()));
	Assert.assertEquals(jsonPathEvaluator.get("code"),200);
	Assert.assertEquals(jsonPathEvaluator.get("type"),"unknown");
		int valueOfCode=jsonPathEvaluator.get("code");
		String valueOfType=jsonPathEvaluator.get("type");
		String valueOfMessage=jsonPathEvaluator.get("message");
		System.out.println("the value of code attribute is:"+valueOfCode);
		System.out.println("the value of type attribute is:"+valueOfType);
		System.out.println("the value of message Attribute is:"+valueOfMessage);
	Assert.	assertEquals(valueOfCode,200);
		Assert.assertEquals(valueOfType, "unknown");
		
		String messagevalue=jsonPathEvaluator.getString("message");
	Assert.assertEquals(messagevalue.contains("logged in user session:"),true);
	logger.info("**************logged into the system ****************************");
	}
	@Test(priority=6)
	public void logOut()
	{logger.info("**************logging out ****************************");
	Response response=UserEndPoints2.getUser2();
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************logging out of the system ****************************");
	}
	
	@Test(priority=7)
	public void testUpdateUswrByName()
	
	{
		logger.info("**************updating user ****************************");
	//update data using payload
		faker=new Faker();
	
		userpayload.setFirstName(faker.name().firstName());	
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
	
	Response response=UserEndPoints2.updateUser(userpayload,this.userpayload.getUsername());
	
	
	
	
	
	response.then().log().body();
	
	Assert.assertEquals(response.getStatusCode(),200);
	//checking data after update
	
	Response responseafterupdate=UserEndPoints2.getUser(this.userpayload.getUsername());
	
	Assert.assertEquals(response.getStatusCode(),200);
	
	logger.info("**************user info updated*************************");
	
	}	
	@Test(priority=8)
	public void testDeleteUserByName()
	
	{
		logger.info("**************deleting user ****************************");
	Response response=UserEndPoints2.deleteUser(this.userpayload.getUsername());
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************user info deleted ****************************");
	}
	
	
	
	
	
}*/
