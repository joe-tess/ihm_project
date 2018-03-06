/**
 * 
 */
package sdz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sdz.View.View;

/**
 * @author pc
 *
 */
public class ControllerSave implements ActionListener {

	private View view;

	/**
	 * Constructeur
	 * 
	 * @param view
	 * 
	 */
	public ControllerSave(View view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		

		
		
		int age = Integer.parseInt(view.getTxtAge().getText());

		if (view.getTxtSexe().getText() == "M") {
			view.getCurrentEleve().setSexe(true);
		} else {
			view.getCurrentEleve().setSexe(false);
		}
		
		
		
		view.getCurrentClasse().setNiveau(view.getTxtNiveau().getText());
		view.getCurrentClasse().setProf(view.getTxtProf().getText());
		view.getCurrentEleve().setNom(view.getTxtNom().getText());
		view.getCurrentEleve().setPrenom(view.getTxtPrenom().getText());
		view.getCurrentEleve().setAge(age);

		JOptionPane.showMessageDialog(view,
				"Les modifications apportées sont enregistrées.",
				"Modification enregistrées", JOptionPane.INFORMATION_MESSAGE);

	}
}