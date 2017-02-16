package org.gojek.search;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.ParkingLotModel;
import org.gojek.utils.FormatUtils;

public class SlotNumbersForColour {
	
	public void searchSlotNumbersForColour(String input, String operationMode) {
		
		if(!(FormatUtils.validateCommandFormat(input, operationMode))) {
			return;
		}
		
		String carColour = input.substring(input.indexOf(ParkingLotConstants.SPACE) + 1);
    	
    	if(!(FormatUtils.validateInputPattern(carColour, ParkingLotConstants.CAR_COLOUR_REGEX, 
    			ParkingLotConstants.CAR_COLOUR_ERROR_MESSAGE, operationMode))) {
    		return;
    	}
    	
    	if(!(ParkingLotModel.getColourToSlotNumbers().containsKey(carColour))) {
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
    	System.out.println(ParkingLotModel.getColourToSlotNumbers().get(carColour).toString().replace(ParkingLotConstants.OPEN_SQUARE_BRACKET, 
    			ParkingLotConstants.EMPTY).replace(ParkingLotConstants.CLOSE_SQUARE_BRACKET, ParkingLotConstants.EMPTY));
    	System.out.println();
	}

}
