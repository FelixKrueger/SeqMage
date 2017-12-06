package uk.ac.babraham.GenomicCoords;

public class GenomicCoords {

	private String chr;     // chromosome
	private int start;      // start position
	private int end;        // end position
	
	// construct a String representation of the genomic coordinates
	public String toString() {
		StringBuffer sb = new StringBuffer();

		/* sb.append("Chromosome:\t" + chr ); techically, "... " + ...) is a StringBuffer in itself,
		 * irrelevant for a few operations
		 * but might make a difference for 100 million objects...
		 * and is better written as:
		 */
		
		sb.append("Chromosome:\t");
		sb.append(chr);
		sb.append("\n");
		sb.append("Start pos:\t");
		sb.append(start);
		sb.append("\n");
		sb.append("End pos:\t");
		sb.append(end);
		
		return(sb.toString());
	}
	
	// Constructor method for new coordinates
	public GenomicCoords(String c, int s, int e) {
		chr = c;
		start = s;
		end = e;
	}
	/*
	 * 
	 */
}
