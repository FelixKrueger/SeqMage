package uk.ac.babraham.SeqMage.ParserWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// import uk.ac.babraham.DataModel;

public class InputFileReader{

	private String delimiterValue = "\t";
	// For a SeqMonk report we use the following values
	private static int chrColValue = 1;
	private static int startColValue = 2;
	private static int endColValue = 3;
	private static int strandColValue = 4;

	private String fileName;
	
	// constructor
	public InputFileReader(String fileName) {
		this.fileName = fileName;	
	}	

	// Reading in the input file
	public void readFile() {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while( (sCurrentLine = br.readLine()) != null) {
				// System.out.println("Full line:\t" + sCurrentLine);

				// Now let's extract the chromosome value
				String[] elements = sCurrentLine.split(delimiterValue);
				String chromosome = elements[chrColValue];
				String start = elements[startColValue];
				String end = elements[endColValue];
				String strand = elements[strandColValue];

				switch(strand){
				case "+":case "1":
					// System.out.println("Strand was '+' or '1' (actually it was: '" + strand + ")");
					strand = "1";
					break;
				case "-":case "-1":
					// System.out.println("Strand was '-' or '-1' (actually it was '" + strand + ")");
					strand = "-1";
					break;

				default: 
					// System.out.println("Strand was not defined, using top strand as default");
					strand = "1";
					break;
				}
				// System.out.println(">" + strand + "<");


				/* This is a sample command for submitting a postBody in the EnsemblRest class:
				 * String postBody = "{ \"regions\" : [ \"MT:1..10:1\",\"X:1000000..1000200:1\", \"ABBA01004489.1:1..100\"] }"
				 */
				
				String singleQuery = toString(chromosome,start,end,strand);
				System.out.println(singleQuery);

			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();

			} catch (IOException ex) { 
				ex.printStackTrace();
			}
		}
	}	
	
	private String toString(String chromosome, String start, String end, String strand) {
		StringBuffer sb = new StringBuffer();

		/* sb.append("Chromosome:\t" + chr ); techically, "... " + ...) is a StringBuffer in itself,
		 * irrelevant for a few operations
		 * but might make a difference for 100 million objects...
		 * and is better written as:
		 */
		// String singleQuery = "\\\"" + chromosome + ":" + start + ".." + end + ":" + strand +  "\\\"";
		
		sb.append("\\\"");
		sb.append(chromosome);
		sb.append(":");
		sb.append(start);
		sb.append("..");
		sb.append(end);
		sb.append(":");
		sb.append(strand);
		sb.append("\\\"");
		
		return(sb.toString());
		
	}
}


