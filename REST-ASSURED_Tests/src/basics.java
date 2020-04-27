import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","500").
				param("type","restaurant").
				param("keyword","cruise").
				param("key","AIzaSyDxeUgptccx5i2Y0HRQZzCpd1N2ew8t43c").
		when().
				get("/maps/api/place/nearbysearch/json").
		then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("results[2].name", equalTo("Australian Cruise Group"));
		

	}

}
