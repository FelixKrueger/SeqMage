package uk.ac.babraham.SeqMage.Genomes;

import java.util.ArrayList;

public class Species {

	private String species;
	// private String [] possibleAssemblies = {"GRCm38","NCBIM37","NCBIM36"}; // should be array of Assembly objects
	private Assembly [] possibleAssemblies;
		
	public Species(String species) {
		this.species = species;
		System.out.println("Species instantiated for species: "+ this.species);
	}

	// For a given Species we can list all available assemblies
	public Assembly [] listAssemblies() {

		// TODO: Need to work out how we can fill possibleAssemblies from Ensembl itself
		
		// For now using some mock Assembly names
		ArrayList<Assembly> availableAssemblies = new ArrayList<>();		

		availableAssemblies.add(new Assembly(new Species(species), "GRCm38"));
		availableAssemblies.add(new Assembly(new Species(species), "NCBIM37"));
		availableAssemblies.add(new Assembly(new Species(species), "NCBIM36"));

		possibleAssemblies = availableAssemblies.toArray(new Assembly[availableAssemblies.size()]);
		return possibleAssemblies;

	}

	public String name() {
		return species;
	}

}
