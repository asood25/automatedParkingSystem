package org.gojek.utils;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.search.ParkingLotStatus;
import org.gojek.search.RegistrationNumbersForColour;
import org.gojek.search.SlotNumberForCarNumber;
import org.gojek.search.SlotNumbersForColour;

public class ParkingLotUtils {
	
	private static CreateParkingLot cpl;
	
	static {
		cpl = CreateParkingLot.getInstance();
	}
	
	public void executeCommand(String command, String operationMode) {
		
		String commandToExecute = command.trim();
		
		if(!(FormatUtils.validateInputPattern(commandToExecute, ParkingLotConstants.COMMAND_REGEX, 
    			ParkingLotConstants.COMMAND_ERROR_MESSAGE + commandToExecute, operationMode))) {
			return;
		}
		
		int index = commandToExecute.indexOf(ParkingLotConstants.SPACE);
		
		if(!(index == -1)) {
			commandToExecute = commandToExecute.substring(0, index);
		}
		
		switch (commandToExecute) {
			
			case ParkingLotConstants.COMMAND_CREATE:
				
				cpl.create(command, operationMode);
				
				break;
				
			case ParkingLotConstants.COMMAND_PARK:
				
				ParkTheCar ptc = new ParkTheCar();
				ptc.park(command, operationMode);
				
				break;
						
			case ParkingLotConstants.COMMAND_LEAVE:
				
				ExitTheCar etc = new ExitTheCar();
				etc.exit(command, operationMode);
				
				break;
				
			case ParkingLotConstants.COMMAND_STATUS:
				
				ParkingLotStatus pls = new ParkingLotStatus();
				pls.showParkingLotStatus(command, operationMode);
				
				break;
				
			case ParkingLotConstants.COMMAND_REGISTRATION_NUMBERS_FOR_CAR_COLOUR:
				
				RegistrationNumbersForColour rnfc = new RegistrationNumbersForColour();
				rnfc.searchRegistrationNumbersForColour(command, operationMode);
				
				break;
				
			case ParkingLotConstants.COMMAND_SLOT_NUMBERS_FOR_CAR_COLOUR:
				
				SlotNumbersForColour snfc = new SlotNumbersForColour();
				snfc.searchSlotNumbersForColour(command, operationMode);
				
				break;
				
			case ParkingLotConstants.COMMAND_SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
				
				SlotNumberForCarNumber snfcn = new SlotNumberForCarNumber();
				snfcn.searchSlotNumberForCarNumber(command, operationMode);
				
				break;
	
			default:
				
				break;
		}
	}

}
