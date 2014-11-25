package V1.receiver;

public class Buffer {
	
	private StringBuffer _str_buffer;
	
	 public Buffer(){
	        _str_buffer = new StringBuffer();
    }
	 
	public int getLongueurTexte(){
		return _str_buffer.length();
	}

	
	 public String getTexte(int debutSelection, int finSelection){
	        return _str_buffer.substring(debutSelection, finSelection);
    }
	    
    public void delete(int debutSelection, int finSelection){
        _str_buffer.delete(debutSelection, finSelection);
    }
    
    public void insert(int index, String texte){
        _str_buffer.insert(index, texte);
    }

}
