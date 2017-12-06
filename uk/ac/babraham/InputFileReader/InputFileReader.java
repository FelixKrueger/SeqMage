package uk.ac.babraham.InputFileReader;

import java.util.ArrayList;
import java.util.Iterator;

import uk.ac.babraham.GenomicCoords.GenomicCoords;

public class InputFileReader {
	/*
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Getting started");
		System.out.println("You can often hear owls hoot at night ....,");
	
		System.out.println("but to see on carrying a \"flying broomstick\" - only once!\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// Create a first set of genomic coords
		
		ArrayList<GenomicCoords> allCoords = new ArrayList<>();
		
		allCoords.add(new GenomicCoords("MT",12334,14442));
		allCoords.add(new GenomicCoords("X",10,20));
		
		
		
		for (GenomicCoords coord : allCoords) {
			// coord.
			System.out.println(coord.toString());			
		}

		
	}

}


