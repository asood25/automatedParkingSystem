package org.gojek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParkingLotModel {
	
	private static HashMap<String, ArrayList<String>> colourToRegistrationNumbers = new HashMap<>();
	private static HashMap<String, ArrayList<Integer>> colourToSlotNumbers = new HashMap<>();
	private static HashMap<String, Integer> registrationNumberToSlotNumber = new HashMap<>();
	
	private static HashMap<Integer, String> slotNumberToRegistrationNumber = new HashMap<>();
	
	private static LinkedHashMap<Integer, String> parkingLotStatus = new LinkedHashMap<>();
	
	public static HashMap<String, ArrayList<String>> getColourToRegistrationNumbers() {
		return colourToRegistrationNumbers;
	}	
	
	public static HashMap<String, ArrayList<Integer>> getColourToSlotNumbers() {
		return colourToSlotNumbers;
	}
	
	public static HashMap<String, Integer> getRegistrationNumberToSlotNumber() {
		return registrationNumberToSlotNumber;
	}
	
	public static HashMap<Integer, String> getSlotNumberToRegistrationNumber() {
		return slotNumberToRegistrationNumber;
	}

	public static LinkedHashMap<Integer, String> getParkingLotStatus() {
		return parkingLotStatus;
	}

}
