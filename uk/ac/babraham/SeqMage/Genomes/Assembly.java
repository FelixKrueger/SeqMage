package uk.ac.babraham.SeqMage.Genomes;

public class Assembly {

	private Species species;
	private String assembly;
	private String sequence;

	private String chromosome;
	// private int start;
	// private int end;
	// private int strand; // 1 for top strand, -1 for reverse strand

	public Assembly(Species species, String assembly) {
		this.species = species;
		this.assembly = assembly;
		System.out.println("Assembly constructor called (Params: \""+ this.species.name() + "\" and \"" + this.assembly + "\")\n");
	}

	public String getSequence(String chr, int start, int end, int strand){

		System.out.println("Now returning a sequence for chromosome "+ chr +", start: "+ start + ", end: "+ end + " (strand: "+ strand);
		sequence = "CATGGGATTCGATGCAGGATATTTCCGGATGCTGATATGCTAGATTATAGCGCGCATAGGATTATAGGAGTTTTAGGATATTTTTGTTTTTATTATTCTTCTCTATTATATTATTATAGGGCGCGCTATTATATATATTATATAGCGCGCGCGCTATATATAGAGAGANTCT";	
		return sequence;
	}

	public String name() {
		return assembly;
	}

}
