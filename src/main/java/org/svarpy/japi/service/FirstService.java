package org.svarpy.japi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.svarpy.japi.model.Seeder;

@Service
public class FirstService {
	
	private String nonSeederId = "";
	private String responseMessage = "";
	
	
	/* Initializing an empty TreeMap for storing static data */
	private static Map<String, Seeder> localDataMap = new TreeMap<>();
	
	/* Adding static data to data map */
	static {
		localDataMap.put("101", new Seeder("101", "Yashash", "CS", 7));
		localDataMap.put("102", new Seeder("102", "Aravindh", "Digital", 3));
		localDataMap.put("103", new Seeder("103", "Revanth", "DevOps", 5));
	}
	
	/* Business Logic Methods */ 
	
	// Method to get all seeders
	public Map<String, Seeder> getAllSeeders() {
		return localDataMap;
	}
	// Method to get seeder by id
	public Map<String, Seeder> getSeederById(String id) {
		Map<String, Seeder> resMap = new HashMap<>();
		resMap.put(id, localDataMap.get(id));
		return resMap;
	}
	
	// Method to add new seeder
	public String addNewSeeder(Seeder seeder) {
		try {
			nonSeederId = localDataMap.get(seeder.getId()).getId();
			if(nonSeederId.equalsIgnoreCase(seeder.getId())) {
				responseMessage = "Seeder already joined, please update to make changes";
			}
			else {
				localDataMap.put(seeder.getId(), seeder);
				responseMessage = "Seeder added successfully.";
			}
		}
		catch (Exception e) {
			responseMessage = "Failed to add seeder!";
		}
		return responseMessage;
	}
	
	// Method to update seeder
	public String updateSeeder(Seeder seeder) {
		try {
			nonSeederId = localDataMap.get(seeder.getId()).getId();
			if(nonSeederId.equalsIgnoreCase(seeder.getId())) {
				localDataMap.replace(nonSeederId, seeder);
				responseMessage = "Seeder updated successfully.";
			}
			else responseMessage = "Seeder not joined, cannot update!";
		}
		catch (Exception e) {
			responseMessage = "Failed to update seeder!";
		}
		return responseMessage;
	}
	
	// Method to delete seeder
	public String deleteSeeder(String id) {
		try {
			nonSeederId = localDataMap.get(id).getId();
			if(nonSeederId.equalsIgnoreCase(id)) {
				localDataMap.remove(id);
				responseMessage = "Seeder data deleted successfully.";
			}
			else responseMessage = "Seeder not joined, cannot delete!";
		}
		catch (Exception e) {
			responseMessage = "Failed to delete seeder!";
		}
		return responseMessage;
	}

}
