package sdz.View;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import sdz.controller.ControllerTable;
import sdz.kernel.Classe;
import sdz.kernel.Eleve;

/**
 * Classe permettant de gener un panel qui contient la table des eleves lorsque une classe ou un eleve est selectionnée. Au clique, provoque la modification des informations affichées sur l'ecran
 * @author pc
 *
 */
public class ViewTable extends JScrollPane {
    /**
     * 
     */
    private static final long serialVersionUID = 6941198035701357586L;
    private JTable table;
    private ModelTable modelTable;
    private ListSelectionModel listSelectionModel;
    private View view;

    /**
     * Permet de creeer une ViewTable dans une view
     * @param view
     */
    public ViewTable(View view) {
	Classe classe = new Classe("", "");
	this.view = view;
	modelTable = new ModelTable(classe);
	table = new JTable(modelTable);
	table.setAutoCreateRowSorter(true);
	table.setCellSelectionEnabled(true);
	ListSelectionModel cellSelectionModel = table.getSelectionModel();
	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.add(table);
	this.setViewportView(table);
    }

    /**
     * Permet de setter une classe a afficher dans le tableau
     * @param c a classe contenue dans e tableau
     */
    public void setData(Classe c) {
	modelTable = new ModelTable(c);
	table = new JTable(modelTable);
	table.setAutoCreateRowSorter(true);
	table.setCellSelectionEnabled(true);
	ListSelectionModel cellSelectionModel = table.getSelectionModel();
	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	this.add(table);
	this.setViewportView(table);
	listSelectionModel = table.getSelectionModel();
	listSelectionModel.addListSelectionListener(new ControllerTable(table, c, view));
	for (Eleve el : c.getEleves()) {
	    System.out.println(el.getNom());
	    this.modelTable.fireTableDataChanged();
	}
    }

    /**
     * Sous clase, model utilisé pour generer la JTable
     * @author pc
     *
     */
    static class ModelTable extends AbstractTableModel {
	private static final long serialVersionUID = 3833559037349078513L;
	private ArrayList<Eleve> eleves;

	public ModelTable(Classe classe) {
	    eleves = classe.getEleves();
	}

	private final String[] entetes = { "ID", "Nom", "Prénom", "Sexe", "Age" };

	@Override
	public int getColumnCount() {
	    return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
	    return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
	    return eleves.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    switch (columnIndex) {
	    case 0:
		return eleves.get(rowIndex).getID();
	    case 1:
		return eleves.get(rowIndex).getPrenom();
	    case 2:
		return eleves.get(rowIndex).getNom();
	    case 3:
		return eleves.get(rowIndex).getSexe();
	    case 4:
		return eleves.get(rowIndex).getAge();
	    default:
		throw new IllegalArgumentException();
	    }
	}
    }

    /**
     * 
     * @return JTable des eleves
     */
    public JTable getTable() {
	return this.table;
    }
}
