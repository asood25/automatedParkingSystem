package org.gojek.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.gojek.constants.ParkingLotConstants;
import org.gojek.utils.ParkingLotUtils;

public class ParkingLotProcess {
	
	protected void process(String operationMode) {

		String nextCommand;
		ParkingLotUtils plu = new ParkingLotUtils();
		
		switch(operationMode) {
			
			case ParkingLotConstants.COMMAND_MODE:
				
				Scanner scan = new Scanner(System.in);
				boolean loop = true;
				
				System.out.println();
				System.out.println("**Welcome**");
				System.out.println();
				System.out.println("At any point enter \"exit\" to leave the system.");
				System.out.println();
				
				while(loop) {
					System.out.println(ParkingLotConstants.INPUT);
					nextCommand = scan.nextLine();
					
					if(nextCommand.equals(ParkingLotConstants.EXIT)) {
						loop = false;
						System.out.println();
						System.out.println("Good Bye. Thanks for using parking lot.");
						break;
					}
					
					plu.executeCommand(nextCommand, operationMode);
				}
				
				break;
			
			case ParkingLotConstants.FILE_MODE:
				
				try (BufferedReader br = new BufferedReader(new FileReader(ParkingLotConstants.COMMANDS_FILE_NAME))) {
					
					while ((nextCommand = br.readLine()) != null) {
						System.out.println();
						System.out.println(nextCommand);
						System.out.println();
						plu.executeCommand(nextCommand, operationMode);
					}

				} catch (IOException e) {
					System.out.println();
					System.out.println("Please check the commands input file.");
					System.out.println();
				}
				
				break;
			
			default:
				
				break;					
		}
	}
}
