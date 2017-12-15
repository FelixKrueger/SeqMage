package uk.ac.babraham.SeqMage.Ensembl;

public class Ensembl{

	private String species;
	private String assembly;
	private boolean listSpecies;
	
	public void processEnsembl() {
		System.out.println("Now starting to process the Ensembl parameters");
		
	}
	
	
	// This class is supposed to retrieve a list of all possible assemblies
	public String getSpecies(){
		return species;
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
