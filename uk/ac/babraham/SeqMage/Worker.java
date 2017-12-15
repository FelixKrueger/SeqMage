package uk.ac.babraham.Worker;

import java.util.ArrayList;

import uk.ac.babraham.Ensembl.Ensembl;
import uk.ac.babraham.GenomicCoords.GenomicCoords;

public class Worker {

	// This class will do the main processing
	private String species;
	private String assembly;
	private String inputFile;

	// constructor 
	public Worker (String inputFile, String species, String assembly) {
		this.assembly = assembly;
		this.species = species;
		this.inputFile = inputFile;
	}

	// this method will kick off the processing
	public void runSeqmage() {

		// F	irst we need to make sure that the specified species and genome assembly are valid 
		Ensembl strainAssembly = new Ensembl("GRCm38", "Mus musculus");
		strainAssembly.printInput();
		
		// Create a first set of genomic coords
		
		// Do I really want to store all Genomic Coords
		// or can interrogate and write them line by line?	
		//		ArrayList<GenomicCoords> allCoords = new ArrayList<>();
		//
		//		allCoords.add(new GenomicCoords("MT",12334,14442));
		//		allCoords.add(new GenomicCoords("X",10,20));
		//		allCoords.add(new GenomicCoords("Y",12314,232566));
		//		allCoords.add(new GenomicCoords("22",10000000,20000000));
		//
		//		for (GenomicCoords coord : allCoords) {
		//			// coord.
		//			System.out.println(coord.toString());	
		//			System.out.println("   ~~~");
		//		}	
	}
}
