package org.gojek.search;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.model.ParkingLotModel;
import org.gojek.utils.FormatUtils;

public class ParkingLotStatus {
	
	public void showParkingLotStatus(String input, String operationMode) {
		
		if(!(FormatUtils.validateInputLength(input, operationMode))) {
			return;
		}
		
		System.out.println();
		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
			System.out.println(ParkingLotConstants.OUTPUT);
		}
		System.out.println("Slot No." +	"\t" + "Registration No." + "\t\t" + "Colour");
		System.out.println();
		
		int size = ParkingLotModel.getParkingLotStatus().size();
		
		if(size == 0) {
			System.out.println("Parking lot is empty.");
			System.out.println();
			return;
		}
		
		for(int i : ParkingLotModel.getParkingLotStatus().keySet()) {
			String data = ParkingLotModel.getParkingLotStatus().get(i);
			System.out.println(i + "\t\t" + data.substring(0, data.indexOf(ParkingLotConstants.SPACE))
					+ "\t\t\t" + data.substring(data.indexOf(ParkingLotConstants.SPACE) + 1));
			
		}
		
		System.out.println();
	}

}
