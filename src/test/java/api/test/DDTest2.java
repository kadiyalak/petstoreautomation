package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;


import api.payLoad.Pet;import java.util.Date;
import api.utilities.DataProviders;import api.endPoints.PetEndPoints;
import io.restassured.response.Response;
public class DDTest2 {

	
	
	

		@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
		public void createUser( String id,String id1,
	    String name,
		 
	  String name1,String photourls,
	 
	      String id2,
	      String name2)
		
		{
		
		Pet petpayload=new Pet();
		petpayload.setId(Double.parseDouble(id));
		petpayload.setId1(Double.parseDouble(id1));
	    
	  
	  
		
		petpayload.setName(name);
		petpayload.setName1(name1);
		petpayload.setPhotourls(photourls);		petpayload.setId2(Double.parseDouble(id2));
		
		petpayload.setName2(name2);
		
		Response response=PetEndPoints.createPet(petpayload);
		response.then().log().all();Assert.assertEquals(response.getStatusCode(),200);
		
	}
		@Test(priority=2,dataProvider="petid",dataProviderClass=DataProviders.class)
		public void getPet(double petId)
		
		{
	Response	response =PetEndPoints.getPet(petId);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
		
		}	
		
		
		@Test(priority=3,dataProvider="petid",dataProviderClass=DataProviders.class)
		public void updatePet(String id,String id1,
			    String name,
				 
				  String name1,String photourls,
				 
				      String id2,
				      String name2)
					
					{
					
					Pet petpayload=new Pet();
					petpayload.setId(Double.parseDouble(id));
					petpayload.setId1(Double.parseDouble(id1));
				    
				  
				  
					
					petpayload.setName(name);
					petpayload.setName1(name1);
					petpayload.setPhotourls(photourls);		petpayload.setId2(Double.parseDouble(id2));
					
					petpayload.setName2(name2);
					
					Response response=PetEndPoints.updatePet(petpayload);
					response.then().log().all();Assert.assertEquals(response.getStatusCode(),200);
		
		
		
		
		
		
		}	
		
		@Test(priority=4,dataProvider="petid",dataProviderClass=DataProviders.class)
		public void deletePet(double petId)
		
		{
			
	Response	response =PetEndPoints.deletePet(petId);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
		
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
}
