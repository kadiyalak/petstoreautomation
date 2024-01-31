package api.endPoints;

/*Swagger URL=https://petstore.swagger.io
 create user(post):https://petstore.swagger.io/v2/user
get user (get):https://petstore.swagger.io/v2/user/{username}

update user (put):https://petstore.swagger.io/v2/user/{username}
delete user (delete);https://petstore.swagger.io/v2/user/{username}*/




public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	/*public static String post_url=base_url+"/user";
	public static String post_url1=base_url+"/user/createWithArray";
	public static String post_url2=base_url+"/user/createWithList";
	public static String get_url=base_url+"/user/{username}";
	public static String get_url1=base_url+"/user/login";
	public static String get_url2=base_url+"/user/logout";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";*/
	
	//https://petstore.swagger.io/v2/pet
	
	//store
	public static String post_url=base_url+"/store/order";
	public static String get_url=base_url+"/store/order/{orderId}";
	public static String update_url=base_url+"/store/inventory";
	public static String delete_url=base_url+"/store/order/{orderId}";
	//pet
	/*public static String post_url=base_url+"/pet";
	
	
	public static String post_url1=base_url+"/pet/{petId}/uploadImage";
	public static String post1_url=base_url+"/pet/{petId}";
	public static String get_url=base_url+"/pet/{petId}";
	public static String get1_url=base_url+"/pet/findByStatus?status=pending";
	public static String update_url=base_url+"/pet";
	public static String delete_url=base_url+"/pet/{petId}";*/
	
	
	
}
