package uk.ac.babraham.SeqMage;

import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * TODO: Add processing of arguments from ARGV
		 * e.g. input file
		 * Species
		 * Assembly etc.
		 * 
		 */
		
		runSeqMage initialWorker = new runSeqMage("Mus musculus", "GRCm38", "Test SeqMonk List");
		initialWorker.runSeqmage();
		
	}		
}
