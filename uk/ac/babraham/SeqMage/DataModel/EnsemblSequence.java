package uk.ac.babraham.SeqMage.DataModel;

public class EnsemblSequence{
	private String query;
	private String seq;
	private String molecule;
	private String id;
	
	@Override
	public String toString() {
		return query + " - " + id + " - " + seq + " - " + molecule;
	}
	
	public String getQuery(){
		return query;
	}
	public String getSeq() {
		return seq;
	}
	
	public String getMolecule() {
		return molecule;
	}
	
	public String getId() {
		return id;
	}
}
