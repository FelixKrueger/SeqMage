package uk.ac.babraham.SeqMage;

import java.util.ArrayList;

import uk.ac.babraham.SeqMage.Ensembl.*;
import uk.ac.babraham.SeqMage.Genomes.Species;
import uk.ac.babraham.SeqMage.DataModel.*;

public class runSeqMage {

	// This class will do the main processing
	private String species;
	private String assembly;
	private String inputFile;

	private	boolean listSpecies;	
	private	boolean listAssemblies;	

	
	// constructor 
	public runSeqMage (String species, String assembly, String inputFile) {
		this.species = species;
		this.assembly = assembly;
		this.inputFile = inputFile;
		this.listSpecies = false;
		this.listAssemblies = false;
		// System.out.println("Species set to: " + this.species);
		// System.out.println("Assembly set to: "+ this.assembly);
	}

	// this method will kick off the processing
	public void runSeqmage() {

		// instantiating Ensembl object that talks to the Ensembl API
		Ensembl myEnsembl = new Ensembl(species, assembly, false, false);
		System.out.println("Ensembl object instantiated");
		
		myEnsembl.processEnsembl();
		
	    // System.out.println("\nProceeding with verified species:\t"+ myEnsembl.getSpecies());
		System.out.println("Proceeding with verified assembly:\t"+ myEnsembl.getAssembly());
		
		// System.out.println(myEnsembl.myAssembly.getSequence());
		
		
					
		if (listSpecies) {
			//	Ensembl listingSpecies = new Ensembl(true);
			//	System.out.println("Need to exit the program at this point");
		}
		else if(listAssemblies){

		}
		else {
			// Before we start doing First we need to make sure that the specified species and genome assembly are valid 
			//				Ensembl initialStrainAssembly = new Ensembl("Mus musculus", "GRCm38");
			//		System.out.println("Using species: "+ initialStrainAssembly.getSpecies());
		}


		//String = initialStrainAssembly.printInput();
		//public void printInput(){	
		//System.out.println(species + " _ " + assembly);
		//	}	
		// Create a first set of genomic coords
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
