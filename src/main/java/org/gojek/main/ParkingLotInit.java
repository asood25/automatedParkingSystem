package org.gojek.main;

import org.gojek.constants.ParkingLotConstants;

public class ParkingLotInit {
	
	public static void main(String[] args) {		
		
		String operationMode = ParkingLotConstants.COMMAND_MODE; //default mode kept to command line.
		
		if(args.length == 1 && args[0].equalsIgnoreCase(ParkingLotConstants.COMMANDS_FILE_NAME)) {
			operationMode = ParkingLotConstants.FILE_MODE;			
		}
		
		ParkingLotProcess plp = new ParkingLotProcess();
		plp.process(operationMode);
		
	}
}
