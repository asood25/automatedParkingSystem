package org.gojek.utils;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.ParkingLotModel;

public class ExitTheCar {
	
	protected void exit(String input, String operationMode) {
		
		if(!(FormatUtils.validateCommandFormat(input, operationMode))) {
			return;
		}
		
		try {
    		int slotNumber = Integer.parseInt(input.substring(input.indexOf(ParkingLotConstants.SPACE) + 1));
    		
    		if(slotNumber <= 0) {
    			System.out.println();
        		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
        			System.out.println(ParkingLotConstants.OUTPUT);
        		}
        		System.out.println("Incorrect data entered in the command.");
        		System.out.println();
        		return;
    		}
    		
    		if(!(ParkingLotModel.getSlotNumberToRegistrationNumber().containsKey(slotNumber))) {
    			System.out.println();
    			if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
        			System.out.println(ParkingLotConstants.OUTPUT);
        		}
        		System.out.println("Slot number currently not occupied.");
        		System.out.println();
        		return;
    		}
    		
    		ParkingLotModel.getRegistrationNumberToSlotNumber().remove((ParkingLotModel.getSlotNumberToRegistrationNumber().get(slotNumber)));
    		ParkingLotModel.getSlotNumberToRegistrationNumber().remove(slotNumber);
    		
    		String carDetails = ParkingLotModel.getParkingLotStatus().get(slotNumber);
    		
    		ParkingLotModel.getColourToRegistrationNumbers().get(carDetails.substring(carDetails.indexOf
    				(ParkingLotConstants.SPACE) + 1)).remove(carDetails.substring(0, carDetails.indexOf(ParkingLotConstants.SPACE)));
    		
    		ParkingLotModel.getColourToSlotNumbers().get(carDetails.substring(carDetails.indexOf
    				(ParkingLotConstants.SPACE) + 1)).remove(Integer.valueOf(slotNumber));
    		
    		ParkingLotModel.getParkingLotStatus().remove(slotNumber);
    		
    		CreateParkingLot cpl = CreateParkingLot.getInstance();
    		cpl.getCplm().getParkingLotSlots().add(slotNumber);
    		
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Slot number " + slotNumber + " is free");
    		System.out.println();
    		
    	} catch (NumberFormatException nfe) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Error exiting car from parking lot.");
    		System.out.println();
    	}
		
	}

}
