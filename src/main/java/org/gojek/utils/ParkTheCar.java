package org.gojek.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.ParkingLotModel;

public class ParkTheCar {
	
	protected void park(String input, String operationMode) {
		
		if(!(FormatUtils.validateCommandFormat(input, operationMode))) {
			return;
		}

    	int lastIndex = input.lastIndexOf(ParkingLotConstants.SPACE);

    	if(lastIndex == -1) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Incorrect data entered in the command.");
    		System.out.println();
    		return;
    	}

    	String registrationNumber = input.substring((input.indexOf(ParkingLotConstants.SPACE)) + 1, lastIndex);

    	if(!(FormatUtils.validateInputPattern(registrationNumber, ParkingLotConstants.CAR_NUMBER_REGEX, 
    			ParkingLotConstants.CAR_NUMBER_ERROR_MESSAGE, operationMode))) {
    		return;
    	}
    	
    	String carColour = input.substring(lastIndex + 1);
    	
    	if(!(FormatUtils.validateInputPattern(carColour, ParkingLotConstants.CAR_COLOUR_REGEX, 
    			ParkingLotConstants.CAR_COLOUR_ERROR_MESSAGE, operationMode))) {
    		return;
    	}
    	
    	if((ParkingLotModel.getRegistrationNumberToSlotNumber().containsKey(registrationNumber))) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Duplicate Registration Number.");
    		System.out.println();
    		return;
    	}
    	
    	CreateParkingLot cpl = CreateParkingLot.getInstance();
    	
    	if(!(checkAreSlotsAvailable(cpl, operationMode))) {
    		return;
    	}
    	
    	if(!(checkAreSlotsCreated(cpl, operationMode))) {
    		return;
    	}
    	
    	int allocatedSlotNumber = cpl.getCplm().getParkingLotSlots().first();
    	
    	ParkingLotModel.getRegistrationNumberToSlotNumber().put(registrationNumber, allocatedSlotNumber);
    	ParkingLotModel.getSlotNumberToRegistrationNumber().put(allocatedSlotNumber, registrationNumber);
    	
    	insertRegistrationNumberForCarColour(carColour, registrationNumber);
    	insertSlotNumberForCarColour(carColour, allocatedSlotNumber);    	
    	insertParkingLotStatus(allocatedSlotNumber, registrationNumber, carColour);
    	
    	cpl.getCplm().getParkingLotSlots().remove(cpl.getCplm().getParkingLotSlots().first());
    	System.out.println();
    	if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
			System.out.println(ParkingLotConstants.OUTPUT);
		}
    	System.out.println("Allocated slot number: " + allocatedSlotNumber);
    	System.out.println();
	}

	private boolean checkAreSlotsCreated(CreateParkingLot cpl, String operationMode) {

		if(cpl.getCplm().getParkingLotSlots().size() == 0) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
        	System.out.println("Sorry, no slots created in parking lot.");
        	System.out.println();
        	return false;
    	}
		return true;
	}
	
	private boolean checkAreSlotsAvailable(CreateParkingLot cpl, String operationMode) {
		
		if(cpl.getCplm().getParkingLotSlots().size() == 0 && ParkingLotModel.getRegistrationNumberToSlotNumber().size() > 0) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
        	System.out.println("Sorry, parking lot is full.");
        	System.out.println();
        	return false;
    	}
		return true;
	}

	private void insertRegistrationNumberForCarColour(String carColour, String carNumber) {
		
		if(!(ParkingLotModel.getColourToRegistrationNumbers().containsKey(carColour))) {
    		ParkingLotModel.getColourToRegistrationNumbers().put(carColour, new ArrayList<String>(Arrays.asList(carNumber)));
    	} else {
    		ArrayList<String> tempList = ParkingLotModel.getColourToRegistrationNumbers().get(carColour);
    		tempList.add(carNumber);
    		ParkingLotModel.getColourToRegistrationNumbers().put(carColour, tempList);
    	}
	}
	
	private void insertSlotNumberForCarColour(String carColour, int slotNumber) {
		
		if(!(ParkingLotModel.getColourToSlotNumbers().containsKey(carColour))) {
    		ParkingLotModel.getColourToSlotNumbers().put(carColour, new ArrayList<Integer>(Arrays.asList(slotNumber)));
    	} else {
    		ArrayList<Integer> tempList = ParkingLotModel.getColourToSlotNumbers().get(carColour);
    		tempList.add(slotNumber);
    		ParkingLotModel.getColourToSlotNumbers().put(carColour, tempList);
    	}
	}
	
	private void insertParkingLotStatus(int allocatedSlotNumber, String registrationNumber, String carColour) {
		
		ParkingLotModel.getParkingLotStatus().put(allocatedSlotNumber, registrationNumber + ParkingLotConstants.SPACE + carColour);
	}
}
