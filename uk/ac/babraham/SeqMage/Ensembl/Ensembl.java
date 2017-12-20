package uk.ac.babraham.SeqMage.Ensembl;

import java.util.ArrayList;

import uk.ac.babraham.SeqMage.Genomes.Assembly;
import uk.ac.babraham.SeqMage.Genomes.Species;

public class Ensembl{

	private String species;
	private String assembly;
	
	// Only ever needs to list available species and make an assembly class 
		
	public Species setSpecies(String species) {

		this.species = species;
		Species mySpecies = new Species(this.species);
		return mySpecies;
		
	}
	
	// This method is supposed to retrieve a list of all possible assemblies
	public Species [] listSpecies(){
		
		// TODO: Eventually this will be somehow populated from Ensembl
		ArrayList<Species> availableSpecies = new ArrayList<>();
		
		availableSpecies.add(new Species("Homo sapiens"));
		availableSpecies.add(new Species("Arabidopsis thaliana"));
		availableSpecies.add(new Species("Mus musculus"));
		availableSpecies.add(new Species("Sus scrofa"));
	
		Species [] possibleSpecies = availableSpecies.toArray(new Species[availableSpecies.size()]);
		return possibleSpecies;
	}
	
	public String getAssembly(){
		return assembly;
	}
	
	public String getSpecies(){
		return species;
	}
	
}
