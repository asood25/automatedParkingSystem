package org.gojek.search;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.ParkingLotModel;
import org.gojek.utils.FormatUtils;

public class SlotNumberForCarNumber {
	
	public void searchSlotNumberForCarNumber(String input, String operationMode) {
		
		if(!(FormatUtils.validateCommandFormat(input, operationMode))) {
			return;
		}
		
		String carNumber = input.substring(input.indexOf(ParkingLotConstants.SPACE) + 1);
    	
    	if(!(FormatUtils.validateInputPattern(carNumber, ParkingLotConstants.CAR_NUMBER_REGEX, 
    			ParkingLotConstants.CAR_NUMBER_ERROR_MESSAGE, operationMode))) {
    		return;
    	}
    	
    	if(!(ParkingLotModel.getRegistrationNumberToSlotNumber().containsKey(carNumber))) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Not Found");
    		System.out.println();
    		return;
    	}
    	
    	System.out.println();
    	if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
			System.out.println(ParkingLotConstants.OUTPUT);
		}
    	System.out.println(ParkingLotModel.getRegistrationNumberToSlotNumber().get(carNumber));
    	System.out.println();
	}

}
