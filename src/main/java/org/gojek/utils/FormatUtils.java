package org.gojek.utils;

import org.gojek.constants.ParkingLotConstants;

public class FormatUtils {
	
	public static boolean validateCommandFormat(String command, String operationMode) {
		
		if(command.indexOf(ParkingLotConstants.SPACE) == -1) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Incorrect data entered in the command.");
    		System.out.println();
    		return false;
    	}
		return true;
	}

	public static boolean validateInputPattern(String input, String pattern, String message, String operationMode) {
		
		if(!(input.matches(pattern))) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println(message);
    		System.out.println();
    		return false;
    	}
		return true;
	}
	
	public static boolean validateInputLength(String command, String operationMode) {
		
		if(command.length() > 6) {
    		System.out.println();
    		if(operationMode.equals(ParkingLotConstants.COMMAND_MODE)) {
    			System.out.println(ParkingLotConstants.OUTPUT);
    		}
    		System.out.println("Incorrect data entered in the command.");
    		System.out.println();
    		return false;
    	}
		return true;
	}
}
