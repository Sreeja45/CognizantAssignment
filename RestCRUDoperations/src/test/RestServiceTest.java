pakcage test;
import static io.restassured.RestAssured.get;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
public class RestSericeTest {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		
		HashMap<String, Vehicle> VehiclesMap = new HashMap<String, Vehicle>();
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId("1");
		vehicle1.setVehicleType("Car");
		vehicle1.setVehiclesMake("Honda");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setId("2");
		vehicle2.setVehicleType("Truck");
		vehicle2.setVehiclesMake("Eicher");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setId("3");
		vehicle3.setVehicleType("Airplane");
		vehicle3.setVehiclesMake("Airbus");
		
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setId("4");
		vehicle4.setVehicleType("Boat");
		vehicle4.setVehiclesMake("Swanson");
		
		VehiclesMap.put("1", vehicle1);
		VehiclesMap.put("2", vehicle2);
		VehiclesMap.put("3", vehicle3);
		VehiclesMap.put("4", vehicle4);
	}

@Test
public void testvehicleInfoGet2() {
	given().when()get("/RestCRUDoperations/rest/VehicleInfo/1")
		.then()
		.body("id", equalTo(1))
		.body("vehicleType", equalTo("Car"))
		.body("VehiclesMake", equalTo("Honda"));
	}

@Test
public void testvehicleInfoGet2() {
	given().when().get("/RestCRUDoperations/rest/VehicleInfo/2")
		.then()
		.body("id", equalTo(2))
		.body("vehicleType", equalTo("Truck"))
		.body("VehiclesMake", equalTo("Eicher"));
	}
@Test
public void testvehicleInfoGet3() {
	given().when().get("/RestCRUDoperations/rest/VehicleInfo/3")
		.then()
		.body("id", equalTo(2))
		.body("vehicleType", equalTo("Boat"))
		.body("VehiclesMake", equalTo("Swanson"));
	}

@Test
public void testvehicleInfoGet4() {
	given().when().get("/RestCRUDoperations/rest/VehicleInfo/4")
		.then()
		.body("id", equalTo(2))
		.body("vehicleType", equalTo("Boat"))
		.body("VehiclesMake", equalTo("Swanson"));
	}

@Test
public void testvehicleInfoPost() {
	given()
    .contentType("application/json")
    .body(car)
    .when().post("/RestCRUDoperations/rest/VehicleInfo").as(Vehicle.class);
	assertFalse(Vehicle.isEmpty());
	}

@Test
public void testvehicleInfoDelete() {
given().pathParam("id", vehicle1.getId(1))
.when().delete("/RestCRUDoperations/rest/VehicleInfo/2").then()
.statusCode(200);
}
