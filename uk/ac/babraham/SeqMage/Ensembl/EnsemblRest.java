package uk.ac.babraham.SeqMage.Ensembl;

import java.net.URL;
import java.net.URLConnection;

import uk.ac.babraham.SeqMage.DataModel.GenomicCoords;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.io.DataOutputStream;


public class EnsemblRest{
	
	private GenomicCoords[] queries;
	
	public String doSomething (GenomicCoords[] coords) throws Exception {
	
		// TODO: Figure out what to pass as the genome information for Sring ext
		String server = "http://rest.ensembl.org";
		String ext = "/sequence/region/human";

		this.queries = coords;
		
		URL url = new URL(server + ext);

		URLConnection connection = url.openConnection();
		HttpURLConnection httpConnection = (HttpURLConnection)connection;

		// TODO: find a way to create the postBody dynamically
		// String postBody = "{ \"regions\" : [ \"MT:1..10:1\",\"X:1000000..1000200:1\", \"ABBA01004489.1:1..100\"] }";
		
		System.out.println("BEEN GIVEN THE FOLLOWING:");
		
		// print Array(queries);
		StringBuffer sb = new StringBuffer();
		for (GenomicCoords gc: queries) {
			sb.append(gc.toString() + ",");
			System.out.print(gc.toString() + ",");
		}
		System.out.println("\nFinal Concatenated String:");
		
		String newPostBody = sb.toString();
		System.out.println(newPostBody);
		System.out.println("Deleting the last character (a ','):");
		newPostBody = newPostBody.substring(0,newPostBody.length() - 1);
		System.out.println("Adding a few more things:");
		newPostBody = "{ \"regions\" : [ " + newPostBody + "] }";
		System.out.println(newPostBody + "\n");
		
	
		String postBody = newPostBody;
		// String postBody = "{ \"regions\" : [ \"MT:1..10:1\",\"X:1000000..1000200:1\", \"ABBA01004489.1:1..100\"] }";
		// String postBody = "{ \"regions\" : [ \"MT:1..10:1\" ] }";
		System.out.println("Submitting:\n" + postBody);
		
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setRequestProperty("Accept", "application/json");
		httpConnection.setRequestProperty("Content-Length", Integer.toString(postBody.getBytes().length));
		httpConnection.setUseCaches(false);
		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);

		// this sends/uploads the postBody	 
		DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		wr.writeBytes(postBody);
		wr.flush();
		wr.close();


		InputStream response = connection.getInputStream();
		int responseCode = httpConnection.getResponseCode();

		if(responseCode != 200) {
			throw new RuntimeException("Response code was not 200. Detected response was "+responseCode);
		}

		String output;
		Reader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(response, "UTF-8"));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			output = builder.toString();
		} 
		finally {
			if (reader != null) try {
				reader.close(); 
			} catch (IOException logOrIgnore) {
				logOrIgnore.printStackTrace();
			}
		}
	
		
		// Find a way to process JSON output: Make immutable JSON objects that can be queried individually
		// There should be resources available to do this kind of stuff
		System.out.println(output);
		return output;
		// String test = processJson();
		// System.out.println(test);
		
	}

	public String processJson() {
		return "Test\n";
	}

}
