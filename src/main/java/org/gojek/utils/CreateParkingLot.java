package org.gojek.utils;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.CreateParkingLotModel;

public class CreateParkingLot {
	
	private static CreateParkingLot cpl;
	private CreateParkingLotModel cplm;

    private CreateParkingLot() { 
    	cplm = new CreateParkingLotModel();
    }
  
    public static CreateParkingLot getInstance() {
    	
        if(cpl == null) {
            cpl = new CreateParkingLot();
        }
        
        return cpl;
    }
     
    public CreateParkingLotModel getCplm() {
		return cplm;
	}

	public void setCplm(CreateParkingLotModel cplm) {
		this.cplm = cplm;
	}

	protected void create(String input, String operationMode) {
        
		if(!(FormatUtils.validateCommandFormat(input, operationMode))) {
			return;
		}
    	
    	try {
    		int numberOfSlots = Integer.parseInt(input.substring(input.indexOf(ParkingLotConstants.SPACE) + 1));
    		
    		if(numberOfSlots <= 0) {
    			System.out.println();
        		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
        			System.out.println(ParkingLotConstants.OUTPUT);
        		}
        		System.out.println("Incorrect data entered in the command.");
        		System.out.println();
        		return;
    		}
    		
    		int parkingLotSize = cplm.getParkingLotSlots().size();
    		
    		for(int i = parkingLotSize; i < (parkingLotSize + numberOfSlots);) {
    			cplm.getParkingLotSlots().add(++i);
    		}
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Created a parking lot with " + numberOfSlots + " slots");
    		System.out.println();
    		
    	} catch (NumberFormatException nfe) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Error Creating Parking Lot.");
    		System.out.println();
    	}
    }
}
