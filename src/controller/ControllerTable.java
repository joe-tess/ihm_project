/**
 * 
 */
package sdz.controller;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sdz.View.View;
import sdz.kernel.Classe;
import sdz.kernel.Eleve;

/**
 * @author pc
 *
 */
public class ControllerTable implements ListSelectionListener {
	private JTable table;
	private Classe classe;
	private View view;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 */
	public ControllerTable(JTable table, Classe classe, View view) {
		this.table = table;
		this.classe = classe;
		this.view = view;

	}

	public void valueChanged(ListSelectionEvent listSelectionEvent) {
		if (listSelectionEvent.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel) listSelectionEvent
				.getSource();
		if (lsm.isSelectionEmpty()) {
			System.out.println("No rows selected");
		} else {

			int selectedRow = lsm.getMinSelectionIndex();

			Eleve selectedEleve = classe
					.get(table.convertRowIndexToModel(selectedRow));
			System.out.println(
					"The row " + selectedEleve.toString() + " is now selected");

			view.afficheInfo(selectedEleve);
		}
	}
}
