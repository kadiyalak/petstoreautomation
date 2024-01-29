package api.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import api.endPoints.PetEndPoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.specification.RequestSpecification;
import api.payLoad.Pet1;import java.util.HashMap;
//import api.payLoad.Tag;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;import org.apache.logging.log4j.Logger;
import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.databind.ObjectMapper;import com.fasterxml.jackson.core.JsonProcessingException;


//import io.restassured.request.Request;
import io.restassured.response.Response;
public class PetTests {
public Logger logger;
	Faker faker;
	Pet1 petpayload;
	//Category category;
	@BeforeClass
	public void setUpData() throws JsonProcessingException
	
	{	faker=new Faker();
	petpayload=new Pet1();
	
	petpayload.setId(faker.idNumber().hashCode());
	 HashMap category=new HashMap();
	category.put("id",faker.idNumber().hashCode());
	category.put("name",faker.name().name());
	System.out.println(category);
	//ObjectMapper objmapper=new ObjectMapper();
	 
	//String category1=objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
	 //System.out.println(category1);
	petpayload.setCategory(category);
	
	petpayload.setName(faker.name().name()); 
	List<String> photoUrls =new ArrayList() ;//{"https://images.app.goo.gl/3Atw5SG94BhBa5qEA,https://images.app.goo.gl/3Atw5SG94BhBa5qEA"};
	photoUrls.add("https://images.app.goo.gl/3Atw5SG94BhBa5qEA");
	photoUrls.add("https://images.app.goo.gl/3Atw5SG94BhBa5qEA");
	System.out.println(photoUrls);
	petpayload.setPhotoUrls(photoUrls);
	Map<String,Object> user1=new HashMap<String,Object>();
	
	 user1.put("id",faker.idNumber().hashCode() );
	user1.put("name",faker.name().name());
	
	
	Map<String,Object> user2=new HashMap<String,Object>();
	
	user2.put("id",faker.idNumber().hashCode());
	user2.put("name",faker.name().name());
	
	
	List<Map<String,Object>> jsonArrayPayLoad=new ArrayList();
	jsonArrayPayLoad.add(user1);
	jsonArrayPayLoad.add(user2);
	//HashMap tags=new HashMap();
	//tags.put("id",faker.idNumber().hashCode());
	//tags.put("name",faker.name().name());
	//System.out.println(tags);
	//ObjectMapper objmapper1=new ObjectMapper();
	 
	// String tags1=objmapper1.writerWithDefaultPrettyPrinter().writeValueAsString(tags);
	 
	// System.out.println(tags1);
	
	petpayload.setTags(jsonArrayPayLoad);
	 petpayload.setStatus("available");
	 logger=LogManager.getLogger(this.getClass());
		logger.debug("debugging.....");
	
	
	
	
	}	
	
	@Test(priority=1)
	public void testPostPet()
	{logger.info("**************creating pet ****************************");
	Response response=PetEndPoints.createPet(petpayload);
	response.then().log().all();//RequestSpecification requestspec=RestAssured.given();
	//System.out.println(response.asPrettyString());//S////ystem.out.println(requestspec.body(petpayload));
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************pet is created ****************************");
	}
	
	
	@Test(priority=2)
	public void testPostPet1()
	{logger.info("**************uploading the image ****************************");
	Response response=PetEndPoints.createPet1(this.petpayload.getId());
	response.then().log().all();
	//System.out.println(response.asPrettyString());
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************image uploaded ****************************");
	}
	
	@Test(priority=3)
	public void testPostPet2()
	{
		logger.info("**************status updating ****************************");
	Response response=PetEndPoints.postPet1(this.petpayload.getId());
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************status updated ****************************");
	}
	
	
	
	
	@Test(priority=4)
	public void testGetStoreByName()	{
	logger.info("**************displaying pet info****************************");
			Response response=PetEndPoints.getPet(this.petpayload.getId());
	 
	response.then()
	//.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("padma.xsd"))
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("subbu.json"))
	.log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************pet info displayed****************************");
}
	
	@Test(priority=5)
	public void testGetStoreByName1()	
	
	{logger.info("**************pets which are pending****************************");
		Response response=PetEndPoints.getPet1();
	
	response.then()
	
	
	.log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************displayed on the basis of status****************************");
}
	
	@Test(priority=6)
	public void testUpdateStoreByName()
	
	{logger.info("**************updating the pet info ****************************");
		petpayload.setName(faker.name().name());petpayload.setStatus("available");
		Response response=PetEndPoints.updatePet(petpayload);response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	
		logger.info("**************updated the pet info ****************************");
	}	
	@Test(priority=7)
	public void testDeleteStoreByName()
	
	{
		logger.info("**************deleting pet info ****************************");
	Response response=PetEndPoints.deletePet(this.petpayload.getId());
	
	Assert.assertEquals(response.getStatusCode(),200);logger.info("**************deleted pet info****************************");
	}
	/*(@Test
	public void postPets() {
	
	String json="{"
			+ "  \"id\": 0,"
			+ "  \"category\": {"
			+ "    \"id\": 0,"
			+ "    \"name\": \"string\""
			+ "  },"
			+ "  \"name\": \"doggie\","
			+ "  \"photoUrls\": ["
			+ "    \"string\"" 
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {"
			+ "      \"id\": 0,"
			+ "      \"name\": \"string\""
			+ "    }"
			+ "  ],"
			+ "  \"status\": \"available\""
			+ "}";
	
	Response response=given().header("accept", "application/json").header("Content-Type", "application/json").body(json).
	log().all().
	when().post("https://petstore.swagger.io/v2/pet");
	System.out.println(response.asPrettyString());
	Assert.assertEquals
	(response.statusCode(),200);
	
	Assert.assertEquals(response.contentType(),"application/json");
	
	}*/
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

