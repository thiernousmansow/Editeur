package V1.invoker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import V1.command.*;

@SuppressWarnings("serial")
public class TextArea extends JTextArea {
	
	private int _debutSelection;
	private int _finSelection;
	private char _dernierChar;
	
	public TextArea(HashMap<String, Command> commandes) {
		
		_debutSelection = 0;
		_finSelection = 0;
		final Command selectionner = commandes.get("selectionner");
		final Command inserer = commandes.get("inserer");
		final Command supprimer = commandes.get("supprimer");
		
		setRows(20);
		setColumns(60);

		addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				int debut = Math.min(e.getDot(), e.getMark());
				int fin = Math.max(e.getDot(), e.getMark());
				if (debut != _debutSelection || fin != _finSelection) {
					setSelection(debut, fin);
					selectionner.execute();
				}
			}

		});

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
				char keyChar = e.getKeyChar();
				if (keyChar != '\b') {
					_dernierChar = keyChar;
					inserer.execute();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					e.consume(); 
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						supprimer.execute();
					}
				}
			}
		});
	}

	public void setSelection(int debutSelection, int finSelection) {
		_debutSelection = debutSelection;
		_finSelection = finSelection;
	}
	
	public char getDernierCharactere() {
		return _dernierChar;
	}

	public void miseAJour(String texte, int debutSelection, int finSelection) {
		setText(texte);
		setSelectionStart(debutSelection);
		setSelectionEnd(finSelection);
		setSelection(debutSelection, finSelection);
		requestFocusInWindow();
	}
}
