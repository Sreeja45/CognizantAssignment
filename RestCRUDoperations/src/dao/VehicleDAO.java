package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vehicles.Vehicle;

public class VehicleDAO {
		static HashMap<String, Vehicle> VehiclesMap = new HashMap<String, Vehicle>();

		public VehicleDAO() {
				Vehicle vehicle1 = new Vehicle();
				vehicle1.setId("1");
				vehicle1.setVehicleType("Car");
				vehicle1.setVehiclesMake("Honda");
				
				Vehicle vehicle2 = new Vehicle();
				vehicle2.setId("2");
				vehicle2.setVehicleType("Truck");
				vehicle2.setVehiclesMake("Eicher");
				
				VehiclesMap.put("1", vehicle1);
				VehiclesMap.put("2", vehicle2);
		}

		public List<Vehicle> getAllVehicles() {

			List<Vehicle> VehicleList = new ArrayList<Vehicle>(VehiclesMap.values());
			return VehicleList;
		}

		public Vehicle getVehicleForId(String id) {
			Vehicle Vehicle = VehiclesMap.get(id);
			return Vehicle;
		}

		public Vehicle createVehicle(Vehicle Vehicle) {
			VehiclesMap.put(Vehicle.getId(), Vehicle);
			return VehiclesMap.get(Vehicle.getId());
		}

		public Vehicle updateVehicle(Vehicle Vehicle) {
			if (VehiclesMap.get(Vehicle.getId()) != null) {
				VehiclesMap.get(Vehicle.getId()).setVehicleType(Vehicle.getVehicleType());
			} else {
				VehiclesMap.put(Vehicle.getId(), Vehicle);
			}
			return VehiclesMap.get(Vehicle.getId());
		}

		public Vehicle deleteVehicle(String id) {
			Vehicle VehicleResponse = VehiclesMap.remove(id);
			return VehicleResponse;
		}

	}

