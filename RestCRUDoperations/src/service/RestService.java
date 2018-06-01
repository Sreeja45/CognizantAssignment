package service;
import java.util.List;

import dao.VehicleDAO;
import vehicles.Vehicle;

	public class RestService {
		VehicleDAO vehicleDAO = new VehicleDAO();

		public List<Vehicle> getAllVehicles() {
			List<Vehicle> VehicleList = vehicleDAO.getAllVehicles();
			return VehicleList;
		}

		public Vehicle getVehicleForId(String id) {
			Vehicle Vehicle = vehicleDAO.getVehicleForId(id);
			return Vehicle;
		}

		public Vehicle createVehicle(Vehicle Vehicle) {
			Vehicle VehicleResponse = vehicleDAO.createVehicle(Vehicle);
			return VehicleResponse;
		}

		public Vehicle updateVehicle(Vehicle Vehicle) {
			Vehicle VehicleResponse = vehicleDAO.updateVehicle(Vehicle);
			return VehicleResponse;
		}

		public Vehicle deleteVehicle(String id) {
			Vehicle VehicleResponse = vehicleDAO.deleteVehicle(id);
			return VehicleResponse;
		}

	}

