package uk.ac.babraham.SeqMage;

import java.util.ArrayList;


public class Launcher {
	
	public static void main(String[] args) {
		
		/*
		 * TODO: Add processing of arguments from ARGV
		 * e.g. input file
		 * Species
		 * Assembly etc.
		 * 
		 */
		Worker initialWorker = new Worker("Test SeqMonk List", "Mus musculus", "GRCm38");
	
		initialWorker.runSeqmage();
		
	}		
}
