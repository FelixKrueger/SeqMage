package uk.ac.babraham.SeqMage.Genomes;

public class Assembly {

	private Species species;
	private String assembly;
	private String fullSequence;

	private String chromosome;
	private int start;
	private int end;
	private int strand; // 1 for top strand, -1 for reverse strand

	public Assembly(Species species, String assembly) {
		this.species = species;
		this.assembly = assembly;
		System.out.println("Assembly constructor called (Params: \""+ this.species.name() + "\" and \"" + this.assembly + "\")\n");
	}

	public String getSequence(String chr, int start, int end, int strand){

		this.chromosome	= chr;
		this.start = start;
		this.end = end;
		this.strand = strand;
		
		System.out.println("Now returning a sequence for chromosome "+ chr +", start: "+ start + ", end: "+ end + " (strand: "+ strand + ")");

		//	this is a mock full sequence
		fullSequence = "CATGGGATTCGATGCAGGATATTTCCGGATGCTGATATGCTAGATTATAGCGCGCATAGGATTATAGGAGTTTTAGGATATTTTTGTTTTTATTATTCTTCTCTATTATATTATTATAGGGCGCGCTATTATATATATTATATAGCGCGCGCGCTATATATAGAGAGANTCT";
		
		String sequence = fullSequence.substring(start,end);
		
		if (strand == -1) {
		String rcSequence = rc(sequence);
			System.out.println("The reverse complemented sequence is:\n" + rcSequence);
		}
				
		return sequence;
	}

	public String name() {
		return assembly;
	}

	// this method reverse complements asequence
	public String rc (String sequence) {
		String rcSeq = sequence;
		
		// string wise comparison using switch statement
		return rcSeq;
	}
	
	
}
