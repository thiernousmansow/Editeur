package V1.invoker;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import V1.command.Command;

public class IHM {

	private JFrame _frame;
	protected TextArea _zoneDeSaisie;
	protected BoutonCommand _couper;
	protected BoutonCommand _copier;
	protected BoutonCommand _coller;
	
	public IHM() {
		_frame = new JFrame("Mini-Editeur v1");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setBounds(100, 100, 355, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		_frame.setContentPane(contentPane);
	}
	
	public void initComposants(HashMap<String,Command> commandes){
		_zoneDeSaisie = new TextArea(commandes);
		_couper = Bouton("Couper", commandes.get("couper"));
		_copier = Bouton("Copier", commandes.get("copier"));
		_coller = Bouton("Coller", commandes.get("coller"));
		
		GroupLayout gl_contentPane = new GroupLayout(_frame.getContentPane());
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(_zoneDeSaisie, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(_couper, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(_copier, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(_coller, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(_couper)
						.addComponent(_copier)
						.addComponent(_coller))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_zoneDeSaisie, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
		);
		_frame.getContentPane().setLayout(gl_contentPane);
	}
	
	public void affichage(){
		_frame.pack();
		_frame.setLocationRelativeTo(null);
		_zoneDeSaisie.requestFocusInWindow();
		_frame.setVisible(true);
	}

	private BoutonCommand Bouton(String nom, Command commande) {
		BoutonCommand boutonCommand = new BoutonCommand(nom, commande);
		boutonCommand.setMaximumSize(new Dimension(Short.MAX_VALUE, boutonCommand.getPreferredSize().height));
		boutonCommand.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		boutonCommand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_zoneDeSaisie.requestFocusInWindow();
			}
		});
		return boutonCommand;
	}

	
	public void TextArea(HashMap<String,Command> commandes) {
		_zoneDeSaisie = new TextArea(commandes);
	}

	
	public char getDernierCharactere() {
		return _zoneDeSaisie.getDernierCharactere();
	}

	public int getDebutSelection() {
		return _zoneDeSaisie.getSelectionStart();
	}
	
	public int getFinSelection(){
		return _zoneDeSaisie.getSelectionEnd();
	}

}
