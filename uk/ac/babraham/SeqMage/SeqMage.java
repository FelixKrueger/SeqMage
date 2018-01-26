package uk.ac.babraham.SeqMage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import uk.ac.babraham.SeqMage.Ensembl.*;
import uk.ac.babraham.SeqMage.Genomes.Assembly;
import uk.ac.babraham.SeqMage.Genomes.Species;
import uk.ac.babraham.SeqMage.ParserWriter.InputFileReader;
import uk.ac.babraham.SeqMage.DataModel.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// import java.lang.reflect.ype;
import com.google.gson.reflect.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class SeqMage {

	// This class will do the main processing
	private String species;
	private String assembly;
	private String inputFile;

	private	boolean listSpecies;	
	private	boolean listAssemblies;	

	private Species mySpecies;
	private Assembly myAssembly;
	private static final String fileName = "D:\\Eclipse\\SeqMage\\MT_test_report.txt";
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Starting to process command line arguments");
		/*
		 * TODO: Add processing of arguments from ARGV
		 * e.g. input file
		 * Species
		 * Assembly etc.
		 * 
		 */
		System.out.println("Finished processing command line arguments");

		// read the Input file and return a list of chromosomal coordinates which we are interested in
		InputFileReader inputReader = new InputFileReader(fileName);
		inputReader.readFile();
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
	public void runSeqmage() throws Exception {

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
			
			// make new EnsemblRest Object
			System.out.println("\nNow making a Rest Object");
			EnsemblRest rest = new EnsemblRest();
			String out = rest.doSomething();
			System.out.println("here is the Output, again\n" + out);
			
			System.out.println("Now converting JSON string to an object\n\n");
			
			// JSON to Java object conversion
			// Generally, in JSON: {} is an object
			//                     [] is an array
			// what we get back from Ensembl REST querys are arrays of objects: [{},{},{}..]
			
			
			// This is an example of converting a single JSON object (testJson) to a Java EnsemblSequence Class
			// Not needed for the Ensembl query but I will leave it in here for future reference
			// String testJson = "{'query':'MT:1..10:1','id':'chromosome:GRCh38:MT:1:10:1','seq':'GATCACAGGT','molecule':'dna'}";
			// Gson gson = new Gson();
			// EnsemblSequence s = gson.fromJson(testJson, EnsemblSequence.class);
			// System.out.println("Printing from a single JSON object");
			// System.out.println(s);

			// System.out.println("Values individually:");
			// System.out.println(s.getId());
			// System.out.println(s.getQuery());
			// System.out.println(s.getSeq());
			// System.out.println(s.getMolecule() + "\n");

		
			String testJson2 = "[{'query':'MT:1..10:1','id':'chromosome:GRCh38:MT:1:10:1','seq':'GATCACAGGT','molecule':'dna'},"
					+ "{'query':'MT:1..10:1','id':'chromosome:GRCh38:MT:10:20:1','seq':'TTTAAAGGT','molecule':'dna'},"
					+ "{'query':'MT:1..10:1','id':'chromosome:GRCh38:MT:10:20:1','seq':'TTTAAAGGT','molecule':'dna'}]";
			// private static void 
			Gson gson2 = new Gson();
			
			// As array
			EnsemblSequence[] ensemblSequences = gson2.fromJson(testJson2,EnsemblSequence[].class);
			System.out.println("Printing from an array of JSON objects");
			System.out.println(ensemblSequences.length);
			// sequence of third item in the list (index pos)
			System.out.println(ensemblSequences[2].getSeq() + "\n");
			
			// As an ArrayList. Both should work equally well, I'll leave it here for future reference
			
			// first we need to detect which type of data we going to deal with (an ArrayList of
			// EnsemblSequences objects) with TypeToken (a Gson method)
			// evaluate the type of list we are going to put the JSON objects in
			// Type sequenceListType = new TypeToken<ArrayList<EnsemblSequence>>(){}.getType();
			// translates to: give me the type of an array list of EnsemblSequence objects, and pass the type to gson
			// NOTE: you only have to identify the type if the List is the root element of the JSON string, but not if it is nested.
			
			// ArrayList<EnsemblSequence> ensemblSequencesAsList = gson2.fromJson(testJson2, sequenceListType);
			// System.out.println("Printing from an ArrayList of JSON objects");
			// System.out.println(ensemblSequencesAsList.size());
			// System.out.println(ensemblSequencesAsList.get(2).getSeq());
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

