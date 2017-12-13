package uk.ac.babraham.Ensembl;

public class Ensembl{

	//	public void checkGenomeInformation{
	//	}

	private String species;
	private String assembly;

	// contructor
	public Ensembl(String species, String assembly){
		this.species = species;
		this.assembly = assembly;
		//	return (species + " _ " + assembly);
	}		
	
	// This class is supposed to retrieve a list of all possible assemblies
	public String getAssembly() {
		return ""; // required
	}
	
	// This class will add 
	public String addAssembly() {
		return ""; // required
	}
	
	public void printInput(){	
		System.out.println(species + " _ " + assembly);
	}	
}
