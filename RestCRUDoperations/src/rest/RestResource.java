package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import vehicles.Vehicle;
import service.RestService;

@Path("/VehicleInfo")
public class RestResource {
	RestService restService = new RestService();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vehicle createVehicle(Vehicle vehicle) {
		Vehicle VehicleResponse = restService.createVehicle(vehicle);
		return VehicleResponse;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> VehicleList = restService.getAllVehicles();
		return VehicleList;
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle getVehicleForId(@PathParam("id") String id) {
		Vehicle Vehicle = restService.getVehicleForId(id);
		return Vehicle;
	}


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vehicle updateVehicle(Vehicle Vehicle) {
		Vehicle VehicleResponse = restService.updateVehicle(Vehicle);
		return VehicleResponse;
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle deleteeVehicle(@PathParam("id") String id) {
		Vehicle VehicleResponse = restService.deleteVehicle(id);
		return VehicleResponse;
	}
}