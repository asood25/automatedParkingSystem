package org.gojek.model;

import java.util.SortedSet;
import java.util.TreeSet;

public class CreateParkingLotModel {
	
	private SortedSet<Integer> parkingLotSlots = new TreeSet<>();

	public SortedSet<Integer> getParkingLotSlots() {
		return parkingLotSlots;
	}

}
