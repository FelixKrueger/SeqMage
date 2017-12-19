package uk.ac.babraham.SeqMage.Ensembl;

import java.util.ArrayList;

import uk.ac.babraham.SeqMage.Genomes.Assembly;
import uk.ac.babraham.SeqMage.Genomes.Species;

public class Ensembl{

	private String species;
	private String assembly;
	private boolean listSpecies;
	private boolean listAssemblies;
	
	private	Assembly [] possibleAssemblies;
	private Species [] possibleSpecies;
	
	// constructor
	public Ensembl(String species, String assembly, boolean listSpecies, boolean listAssemblies) {
			this.species = species;
			this.assembly = assembly;
			this.listSpecies = listSpecies;
			this.listAssemblies = listAssemblies;
	}

	// overloaded constructor for listSpecies only
	public Ensembl(String species) {
		this.species = species;	
	}

	public void processEnsembl() {
		
		// Species
		if (listSpecies) {
			System.out.println("\nList Species requested. Let's see what we can do");
			listSpecies();

			System.out.println("\nHere is a list of all possible Species: " + species);
			
			for (int i=0; i < possibleSpecies.length; i++) {
				System.out.println("element " + i +" value is " + possibleSpecies[i].name());
			}
			
			System.out.println("Available species listed, exiting...");
			System.exit(0);	
		}

		System.out.println("Creating instance of Species for the following organism: "+ species);
		Species mySpecies = new Species(species);
		
		if (listAssemblies) {
			possibleAssemblies = mySpecies.listAssemblies();
			System.out.println("Here is a list of all possible assemblies for species: " + species);
			
			for (int i=0; i < possibleAssemblies.length; i++) {
				System.out.println("element " + i +" value is " + possibleAssemblies[i].name());
			}
			System.out.println("Assemblies listed, exiting...");
			System.exit(0);
		}
		
		// Assembly
		Assembly myAssembly = new Assembly(mySpecies, assembly);
		System.out.println(myAssembly.getSequence("MT", 12345, 89027, 1));
		
	}
	
	
	// This method is supposed to retrieve a list of all possible assemblies
	public Species [] listSpecies(){
		ArrayList<Species> availableSpecies = new ArrayList<>();
		
		availableSpecies.add(new Species("Homo sapiens"));
		availableSpecies.add(new Species("Arabidopsis thaliana"));
		availableSpecies.add(new Species("Mus musculus"));
		availableSpecies.add(new Species("Sus scrofa"));
	
		possibleSpecies = availableSpecies.toArray(new Species[availableSpecies.size()]);
		return possibleSpecies;
	}
	
	public String organismName() {
		// This method will need to lsit Species names from Ensembl
		String organismName = "to_be_determined";
		return organismName; 
	}
	
	public String getAssembly(){
		return assembly;
	}
	
	public String getSpeciesArray(){
		// this should be a list and not a String
		return species; 
	}
	
	
	public void setSpecies(){
		//	return ""; // required
	}
	
	// Major contructor
	//	public Ensembl(String species, String assembly, boolean listSpecies){
	//		this.species = species;
	//		this.assembly = assembly;
	//		this.listSpecies = listSpecies;
	//	}	
	//
	//	// If only species and assembly were supplied we assume that the user knows what they are asking for
	//	public Ensembl(String species, String assembly){
	//		// setting listSpecies to false
	//		this(species, assembly, false);
	//		// System.out.println("Species supplied: "+ species + "\nAssembly supplied: " + assembly);
	//	}	
	//	
	//	// Overloaded constructor when only --list-species was specified
	//	public Ensembl(boolean listSpecies){
	//		// 	if --list-species was defined we need to query Ensembl for the species that are available
	//		this("NA","NA",true);
	//		if(listSpecies) {	
	//			System.out.println("--list-species called: Querying Ensembl for available Species\n");
	//			System.out.println("Available species include: 'Homo sapiens', 'Mus musculus' or 'Arabidopsis thaliana'");
	//		}	
	//	}
		

}
