
package V1.receiver;

public class PressePapier {
	
	private String _texte;
	
	public PressePapier(){
		_texte = "";
	}

	public String getTexte() {
		return _texte;
	}
	public void setTexte(String texte) {
		_texte = texte;
	}
	
	public int getLongueurTexte(){
		return _texte.length();
	}

}
