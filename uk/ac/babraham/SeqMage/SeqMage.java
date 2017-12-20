package uk.ac.babraham.SeqMage;

import java.util.ArrayList;

import uk.ac.babraham.SeqMage.Ensembl.*;
import uk.ac.babraham.SeqMage.Genomes.Assembly;
import uk.ac.babraham.SeqMage.Genomes.Species;
import uk.ac.babraham.SeqMage.DataModel.*;

public class SeqMage {

	// This class will do the main processing
	private String species;
	private String assembly;
	private String inputFile;

	private	boolean listSpecies;	
	private	boolean listAssemblies;	

	private Species mySpecies;
	private Assembly myAssembly;
		
	public static void main(String[] args) {
		
		System.out.println("Starting to process command line arguments");
		/*
		 * TODO: Add processing of arguments from ARGV
		 * e.g. input file
		 * Species
		 * Assembly etc.
		 * 
		 */
		System.out.println("Finished processing command line arguments");

		// Once we have all necessary input we can start by calling a SeqMage object
		SeqMage seqMage = new SeqMage("Mus musculus", "GRCm38", "Test SeqMonk List");
		seqMage.runSeqmage();
		
	}		
	
	// constructor 
	public SeqMage (String species, String assembly, String inputFile) {
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
		Ensembl myEnsembl = new Ensembl();
		System.out.println("Ensembl object instantiated");
		
		// Species
		if (listSpecies) {
			System.out.println("\nList Species requested. Let's see what we can find\n" + repeat("=", 50) + "\n");
	
			// variables inside methods can never be public or private because they are not class variables. 
			// Either no access modifiers or final are the way to go
			Species [] possibleSpecies = myEnsembl.listSpecies();

			System.out.println("\nHere is a list of all possible Species: " + species);
			
			for (int i=0; i < possibleSpecies.length; i++) {
				System.out.println("element " + i +" value is " + possibleSpecies[i].name());
			}
			
			System.out.println("\nAvailable species listed, exiting SeqMage...");
			System.exit(0);	
		}
		else {

			this.mySpecies = myEnsembl.setSpecies(species);
			System.out.println("Creating instance of Species for the following organism: "+ mySpecies.name());
			// TODO: Need to verify that the species provided is a valid name
			System.out.println("\nProceeding with verified species:\t"+ mySpecies.name());
			
			// listing assemblies
			if (listAssemblies) {
				Assembly [] possibleAssemblies = mySpecies.listAssemblies();
				System.out.println("Here is a list of all possible assemblies for species: " + species);
					
				for (int i=0; i < possibleAssemblies.length; i++) {
					System.out.println("element " + i +" value is " + possibleAssemblies[i].name());
				}
				
				System.out.println("Assemblies listed, exiting SeqMage...");
				System.exit(0);
			}
			
			System.out.println("Creating instance of Assembly for the following organism: "+ mySpecies.name());
			
			// TODO: Need to verify that the assemblyprovided is a valid name
			
			System.out.println("Proceeding with verified assembly:\t"+ myEnsembl.getAssembly());
			
			// Instantiating Assembly
			this.myAssembly = new Assembly(mySpecies, assembly);
			
			System.out.println(myAssembly.getSequence("MT", 27, 67, -1));
			
			// Before we start doing First we need to make sure that the specified species and genome assembly are valid 
			//	Ensembl initialStrainAssembly = new Ensembl("Mus musculus", "GRCm38");
			//	System.out.println("Using species: "+ initialStrainAssembly.getSpecies());
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
	
	public static String repeat(String str, int times) {
		return new String(new char[times]).replace("\0", str);
	}

}

