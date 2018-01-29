package uk.ac.babraham.SeqMage.DataModel;

public class GenomicCoords {

	private String chr;     // chromosome
	private int start;      // start position
	private int end;        // end position
	private int strand;     // strand. either 1 (top) or -1 (bottom)
	
	// construct a String representation of the genomic coordinates

	public String toString() {
		StringBuffer sb = new StringBuffer();

		/* sb.append("Chromosome:\t" + chr ); technically, "... " + ...) is a StringBuffer in itself,
		 * irrelevant for a few operations
		 * but might make a difference for 100 million objects...
		 * and is better written as:
		 */
		// String singleQuery = "\\\"" + chromosome + ":" + start + ".." + end + ":" + strand +  "\\\"";
		
		sb.append("\\\"");
		sb.append(chr);
		sb.append(":");
		sb.append(start);
		sb.append("..");
		sb.append(end);
		sb.append(":");
		sb.append(strand);
		sb.append("\\\"");
		
		return(sb.toString());
		
	}
	
	// Constructor for new coordinates
	public GenomicCoords(String chr, int start, int end, String strand) {
		this.chr = chr;
		this.start = start;
		this.end = end;
		this.strand = Integer.parseInt(strand); // 1 or -1
	}
	
	public String getChromosome() {
		return chr;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public int getStrand() {
		return strand;
	}
}
