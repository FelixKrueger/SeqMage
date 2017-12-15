package uk.ac.babraham.Launcher;

import java.util.ArrayList;

import uk.ac.babraham.Ensembl.Ensembl;
import uk.ac.babraham.GenomicCoords.GenomicCoords;
import uk.ac.babraham.Worker.Worker;

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
