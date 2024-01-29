package api.test;import org.testng.Assert;
import org.testng.annotations.Test;


import api.payLoad.Store;import java.util.Date;
import api.utilities.DataProviders;import api.endPoints.StoreEndPoints;
import io.restassured.response.Response;

public class DDTests1 {

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void createUser(String  orderId,String petId,int quantity,Date shipDate,String status,String complete)
	
	{
	
	Store storePayload=new Store();
	storePayload.setOrderId(Double.parseDouble(orderId));
	storePayload.setPetId(Double.parseDouble(petId));
	
	storePayload.setQuantity(quantity);
	storePayload.setShipDate(shipDate);
	storePayload.setStatus(status);
	storePayload.setComplete(complete);
	
	
	
	Response response=StoreEndPoints.createUser(storePayload);
	response.then().log().all();Assert.assertEquals(response.getStatusCode(),200);
	
}
	@Test(priority=2,dataProvider="orderid",dataProviderClass=DataProviders.class)
	public void getUser(double orderid)
	
	{
Response	response =StoreEndPoints.getUser(orderid);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	
	@Test(priority=3,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void getUser1(double orderid)
	
	{
Response	response =StoreEndPoints.getUser1();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	@Test(priority=4,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void testdeleteUserByOrderid(double orderid)
	
	{
	
	
Response	response =StoreEndPoints.deleteUser(orderid);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
