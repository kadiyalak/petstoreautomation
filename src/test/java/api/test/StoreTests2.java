/*package api.test;

import static io.restassured.RestAssured.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.StoreEndPoints2;
import api.payLoad.Store;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class StoreTests2 {
	Faker faker;
	Store storepayload;
	public Logger logger;
	@BeforeClass
	public void setUpData() throws ParseException
	
	{
	SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	faker=new Faker();
	storepayload=new Store();
	storepayload.setId(faker.idNumber().hashCode());
	storepayload.setPetId(faker.idNumber().hashCode());
	storepayload.setQuantity(2);
	//Date date= sdf.parse  ("2024-01-07T01:51:06.717Z4");System.out.println(date);
	storepayload.setShipdate( "2024-01-07T01:51:06.717Z");
	storepayload.setStatus("placed");
	storepayload.setComplete("true");
	//storepayload.setShipdate( "2024-01-07T01:51:06.717Z");
	logger=LogManager.getLogger(this.getClass());
	logger.debug("debugging.....");
	}	
	
	
	@Test(priority=1)
	public void testPostStore()
	{
		logger.info("**************creating order ****************************");
	Response response=StoreEndPoints2.createUser(storepayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("**************order is created***********************");
	}
	
	@Test(priority=2)
	public void testGetStoreByName()	
	
	{logger.info("**********************reading order info****************************");
		Response response=StoreEndPoints2.getUser(this.storepayload.getId());
	
	response.then()
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"))
	
	.log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("*******************user order is displayed*************************");
}
	//@Test
	void jsonSchemaValidation()
	{
		logger.info("*********************schema validation*******************");
	given()
	.when()
	   .get("https://petstore.swagger.io/v2/store/order")
	.then()
   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
	logger.info("*********************schema validated*******************");
}
	
	
	
	
	
	@Test(priority=3)
	public void testUpdateStoreByName()
	
	{
		logger.info("*********************updating order info*******************");
		Response response=StoreEndPoints2.getUser1();response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*********************order info updated*******************");
	
	}	
	@Test(priority=4)
	public void testDeleteStoreByName()
	
	{
		
		logger.info("*********************deleting order info*******************");
	Response response=StoreEndPoints2.deleteUser(this.storepayload.getId());
	
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("*********************order info deleted*******************");
	}
}*/
