package org.gojek.constants;

public class ParkingLotConstants {
	
	public static final String COMMANDS_FILE_NAME = "file_inputs.txt";
	public static final String FILE_MODE = "FileMode";
	public static final String COMMAND_MODE = "CommandMode";
	public static final String INPUT = "Input:";
	public static final String OUTPUT = "Output:";
	public static final String SPACE = " ";
	
	public static final String COMMAND_REGEX = "^[a-zA-Z0-9 _-]+$";
	public static final String CAR_NUMBER_REGEX = "^[A-Z]{2}[-][0-9]{2}[-][A-Z]{1,2}[-][0-9]{1,4}+$";
	public static final String CAR_COLOUR_REGEX = "^[a-zA-Z]+$";
	
	public static final String COMMAND_CREATE = "create_parking_lot";
	public static final String COMMAND_PARK = "park";
	public static final String COMMAND_LEAVE = "leave";
	public static final String COMMAND_STATUS = "status";
	public static final String COMMAND_REGISTRATION_NUMBERS_FOR_CAR_COLOUR = "registration_numbers_for_cars_with_colour";
	public static final String COMMAND_SLOT_NUMBERS_FOR_CAR_COLOUR = "slot_numbers_for_cars_with_colour";
	public static final String COMMAND_SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	
	public static final String COMMAND_ERROR_MESSAGE = "Not a valid command = ";
	public static final String CAR_NUMBER_ERROR_MESSAGE = "Invalid resgistration number.";
	public static final String CAR_COLOUR_ERROR_MESSAGE = "Invalid car colour.";
	
	public static final String OPEN_SQUARE_BRACKET = "[";
	public static final String CLOSE_SQUARE_BRACKET = "]";
	public static final String EMPTY = "";
	
	public static final String EXIT = "exit";

}
