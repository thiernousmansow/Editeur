package V1.invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import V1.command.Command;

@SuppressWarnings("serial")
public class BoutonCommand extends JButton {

	private String _nom;
	private Command _commande;

	public BoutonCommand(String nom, final Command commande) {
		super(nom);
		_nom = nom;
		_commande = commande;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_commande.execute();
			}
		});
	}
	
	public String getNom() {
		return _nom;
	}
	
	public Command getCommand() {
		return _commande;
	}
	
	

}
