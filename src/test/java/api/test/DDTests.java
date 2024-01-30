/*package api.test;import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
 
import api.endPoints.UserEndPoints;
import api.payLoad.User;import api.utilities.DataProviders;
public class DDTests {

	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	
	{
	
	User userPayload=new User();
	userPayload.setId(Integer.parseInt(userID));
	userPayload.setUsername(userName);
	userPayload.setFirstName(fname);
	userPayload.setLastName(lname);
	userPayload.setEmail(useremail);
	userPayload.setPassword(pwd);
	
	userPayload.setPhone(ph);;
	
	
	Response response=UserEndPoints.createUser(userPayload);
	response.then().log().all();Assert.assertEquals(response.getStatusCode(),200);
	
}
	@Test(priority=2,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	
	{
Response	response =UserEndPoints.deleteUser(userName);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	
	@Test(priority=2,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void testgetUserByName(String userName)
	
	{
Response	response =UserEndPoints.getUser(userName);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	@Test(priority=2,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void testUpdateUserByName(String userName,String userID,String fname,String lname,String useremail,String pwd,String ph)
	
	{User userPayload=new User();
	
	userPayload.setFirstName(fname);
	userPayload.setLastName(lname);
	
	
Response	response =UserEndPoints.updateUser(userPayload,userName);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}*/