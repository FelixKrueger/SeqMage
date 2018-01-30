package uk.ac.babraham.SeqMage.ParserWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import uk.ac.babraham.SeqMage.DataModel.GenomicCoords;

// import uk.ac.babraham.DataModel;

public class InputFileReader{

	private String delimiterValue = "\t";
	// For a SeqMonk report we use the following values
	private static int chrColValue = 1;
	private static int startColValue = 2;
	private static int endColValue = 3;
	private static int strandColValue = 4;

	private String fileName;
	
	private ArrayList<GenomicCoords> queryStrings = new ArrayList<>();
	
	// constructor
	public InputFileReader(String fileName) {
		this.fileName = fileName;	
	}	

	
	
	// Reading in the input file
	public GenomicCoords[] readFile() {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;
			
			// low-tech, non generic way of reading in and discarding the header line
			// br.readLine();
			
			while( (sCurrentLine = br.readLine()) != null) {
				// 	System.out.println("Full line:\t" + sCurrentLine);

				try {
					// Now let's extract the values we need
					String[] elements = sCurrentLine.split(delimiterValue);
					String chromosome = elements[chrColValue];
					int start = Integer.parseInt(elements[startColValue]);
					int end = Integer.parseInt(elements[endColValue]);
					String strand = elements[strandColValue];

					//System.out.println("start: " + start);
					//System.out.println("end: " +  end);				
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

					GenomicCoords coord = new GenomicCoords(chromosome,start,end,strand);
					// System.out.println(singleQuery);
					queryStrings.add(coord);
				} catch(Exception e){
					// System.err.println("Failed to extract genomic coordinates for line:\t" + sCurrentLine);
					// instead of printing a full stack stack error message, just printing the first message
					System.err.println(e.getLocalizedMessage());
				}
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
		
		return (GenomicCoords[]) queryStrings.toArray(new GenomicCoords[queryStrings.size()]);
	
	}	
	
}


