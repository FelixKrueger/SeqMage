package uk.ac.babraham.Ensembl;

public class Ensembl{

	//	public void checkGenomeInformation{
	//	}

	private String species;
	private String assembly;

	// Major contructor
	public Ensembl(String species, String assembly){
		// saving field values directly is preferred in a constructor (mixed opinions here), because calling any other methods
		// apart from calling another construc
		this.species = species;
		this.assembly = assembly;
	}	
	
	// Overloaded constructor when no parameters are specified
	public Ensembl(){
		// if this() is specified as the very first line of code this will call the other constructor 
		// (here public Ensembl(String species, String assembly){} ) with the default values provided.
		this("Default species","Default assembly");
	}
		
	// Overloaded constructor when only --listSpecies was specified
	public Ensembl(String listSpecies){
		this("Default species","Default assembly");
	}
	
	// This class is supposed to retrieve a list of all possible assemblies
	public String getAssembly() {
		return ""; // required
	}
	
	public String getSpecies(){
		return this.species;
	}
	
	public void setSpecies(){
		//	return ""; // required
	}
	
	public void printInput(){	
		System.out.println(species + " _ " + assembly);
	}	
}
