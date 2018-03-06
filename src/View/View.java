package sdz.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import sdz.controller.ControllerSave;
import sdz.controller.ControllerTree;
import sdz.kernel.Classe;
import sdz.kernel.Eleve;
import sdz.model.Model;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

/**
 * MAIN Vue principale.
 * 
 * @author pc
 *
 */
public class View extends JFrame {

	private static final long serialVersionUID = 8934215023070884561L;
	private JSplitPane splitPane;
	private JTree tree;
	private DefaultMutableTreeNode racine;
	private JPanel panEleve;
	private JPanel panProf;
	private JTextField txtProf;
	private JTextField txtNombreEleves;
	private JTextField txtNiveau;
	private JTextField txtPrenom;
	private JTextField txtNom;
	private JTextField txtAge;
	private JTextField txtSexe;
	private JLabel lblProfesseur;
	private JLabel lblNIveau;
	private JLabel lblNbrEleves;
	private JPanel panelFormField;
	private JButton btnSauverClasse;
	private JPanel panelEleveContent;
	private JButton btnSauverEleve;
	private JPanel panelEleveContentFields;
	private JLabel lblPrenomEleve;
	private JLabel lblSexeEleve;
	private JLabel lblAgeEleve;
	private JLabel lblNomEleve;
	private JPanel panelBottom;
	private JLabel lblCopy;
	private Eleve currentEleve;
	private Classe currentClasse;

	private Model model;
	private ViewTable viewTable;

	// create the frame
	public View() {

		// Base
		getContentPane().setFont(new Font("Droid Sans", Font.PLAIN, 12));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setTitle("Gestion des \u00E9l\u00E8ves 1.0");
		setFont(new Font("Droid Sans", Font.PLAIN, 12));

		// Creation des models pour cette view
		this.model = new Model();

		// Crea table
		this.viewTable = new ViewTable(this);
		viewTable.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// PNL BOTTOM
		panelBottom = new JPanel();
		getContentPane().add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new BorderLayout(0, 0));

		lblCopy = new JLabel("Amiand Alexis - Gphy - HCI 2017 - Etape 4 ");
		lblCopy.setForeground(Color.GRAY);
		lblCopy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopy.setFont(new Font("Droid Sans", Font.PLAIN, 11));
		lblCopy.setVerticalAlignment(SwingConstants.BOTTOM);
		panelBottom.add(lblCopy);
		// SPLIT THE FRAME
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		getContentPane().add(splitPane);

		// J3 J3
		racine = new DefaultMutableTreeNode(model.getEcole().getNom());
		tree = new JTree(racine);
		tree.setShowsRootHandles(true);
		tree.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		tree.getSelectionModel()
				.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Ajout du Listenner
		tree.addTreeSelectionListener(new ControllerTree(this, this.tree));

		// Suie design
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
		splitPane.setLeftComponent(scrollPane);
		JPanel panContent = new JPanel();
		splitPane.setRightComponent(panContent);
		panContent.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panForm = new JPanel();
		panContent.add(panForm);
		panForm.setLayout(new GridLayout(2, 1, 0, 0));

		panProf = new JPanel();
		panForm.add(panProf);
		panProf.setLayout(new BorderLayout(0, 0));

		panelFormField = new JPanel();

		panProf.add(panelFormField);
		panelFormField.setLayout(new GridLayout(0, 3, 0, 0));

		lblProfesseur = new JLabel("Professeur");
		lblProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesseur.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		panelFormField.add(lblProfesseur);

		lblNIveau = new JLabel("Niveau");
		lblNIveau.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		lblNIveau.setHorizontalAlignment(SwingConstants.CENTER);
		panelFormField.add(lblNIveau);

		lblNbrEleves = new JLabel("Effectif");
		lblNbrEleves.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbrEleves.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		panelFormField.add(lblNbrEleves);

		txtProf = new JTextField();
		txtProf.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProfesseur.setLabelFor(txtProf);
		panelFormField.add(txtProf);
		txtProf.setText("Prof");
		txtProf.setColumns(10);

		txtNiveau = new JTextField();
		txtNiveau.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelFormField.add(txtNiveau);
		txtNiveau.setText("Niveau");
		txtNiveau.setColumns(10);

		txtNombreEleves = new JTextField();
		txtNombreEleves.setEditable(false);
		txtNombreEleves.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNbrEleves.setLabelFor(txtNombreEleves);
		panelFormField.add(txtNombreEleves);
		txtNombreEleves.setText("nombreEleves");
		txtNombreEleves.setColumns(10);

		btnSauverClasse = new JButton("Sauver");
		btnSauverClasse.addActionListener(new ControllerSave(this));

		btnSauverClasse.setFont(new Font("Droid Sans", Font.PLAIN, 15));
		panProf.add(btnSauverClasse, BorderLayout.EAST);

		panEleve = new JPanel();
		panForm.add(panEleve);
		panEleve.setLayout(new BorderLayout(0, 0));

		panelEleveContent = new JPanel();
		panEleve.add(panelEleveContent, BorderLayout.CENTER);
		panelEleveContent.setLayout(new GridLayout(0, 1, 0, 0));

		panelEleveContentFields = new JPanel();
		panelEleveContent.add(panelEleveContentFields);
		panelEleveContentFields.setLayout(new GridLayout(0, 4, 0, 0));

		lblPrenomEleve = new JLabel("Prenom");
		lblPrenomEleve.setLabelFor(lblPrenomEleve);
		lblPrenomEleve.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		lblPrenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblPrenomEleve);

		lblNomEleve = new JLabel("Nom");
		lblNomEleve.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		lblNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblNomEleve);

		lblAgeEleve = new JLabel("Age");
		lblAgeEleve.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeEleve.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		panelEleveContentFields.add(lblAgeEleve);

		lblSexeEleve = new JLabel("Sexe");
		lblSexeEleve.setFont(new Font("Droid Sans", Font.PLAIN, 13));
		lblSexeEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panelEleveContentFields.add(lblSexeEleve);

		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelEleveContentFields.add(txtPrenom);
		txtPrenom.setText("Prenom");
		txtPrenom.setColumns(10);

		txtNom = new JTextField();
		txtNom.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNomEleve.setLabelFor(txtNom);
		panelEleveContentFields.add(txtNom);
		txtNom.setText("Nom");
		txtNom.setColumns(10);

		txtAge = new JTextField();
		txtAge.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblAgeEleve.setLabelFor(txtAge);
		panelEleveContentFields.add(txtAge);
		txtAge.setText("Age");
		txtAge.setColumns(10);

		txtSexe = new JTextField();
		txtSexe.setFont(new Font("Roboto", Font.PLAIN, 14));
		panelEleveContentFields.add(txtSexe);
		txtSexe.setText("Sexe");
		txtSexe.setColumns(10);

		btnSauverEleve = new JButton("Sauver");
		btnSauverEleve.setFont(new Font("Droid Sans", Font.PLAIN, 15));
		btnSauverEleve.addActionListener(new ControllerSave(this));
		panEleve.add(btnSauverEleve, BorderLayout.EAST);

		JPanel panFiche = new JPanel();
		panFiche.setBackground(Color.LIGHT_GRAY);
		panContent.add(panFiche);
		panFiche.setLayout(new GridLayout(0, 1, 0, 0));

		this.pack(); // il est placé ici ce qui permet de pack sans la scroll
						// bar

		// AJOUT SCROLL SUR TABLE
		JPanel panScroll = new JPanel();
		panScroll.setBackground(Color.WHITE);
		panFiche.add(panScroll);
		panScroll.setLayout(new GridLayout(0, 1, 0, 0));
		panScroll.add(viewTable);

		// OPERATION
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	/**
	 * @return the txtProf
	 */
	public JTextField getTxtProf() {
		return txtProf;
	}

	/**
	 * @return the txtNombreEleves
	 */
	public JTextField getTxtNombreEleves() {
		return txtNombreEleves;
	}

	/**
	 * @return the txtNiveau
	 */
	public JTextField getTxtNiveau() {
		return txtNiveau;
	}

	/**
	 * @return the txtPrenom
	 */
	public JTextField getTxtPrenom() {
		return txtPrenom;
	}

	/**
	 * @return the txtNom
	 */
	public JTextField getTxtNom() {
		return txtNom;
	}

	/**
	 * @return the txtAge
	 */
	public JTextField getTxtAge() {
		return txtAge;
	}

	/**
	 * @return the txtSexe
	 */
	public JTextField getTxtSexe() {
		return txtSexe;
	}

	/**
	 * Fonction de creation d'un Jtree à partir d'une école
	 */
	public void createTree() {
		for (Classe classe : this.model.getEcole().getClasses()) {
			DefaultMutableTreeNode laClasse = new DefaultMutableTreeNode(
					classe);
			for (Eleve el : classe.getEleves()) {
				System.out.println(el);
				DefaultMutableTreeNode eleve = new DefaultMutableTreeNode(el);
				laClasse.add(eleve);
			}
			racine.add(laClasse);
		}
	}

	/**
	 * Recpteur du controler JTree JTree
	 * 
	 * @param node
	 */
	public void afficheInfo(Object node) {
		if (node instanceof Eleve) {
			currentEleve = (Eleve) node;
			currentClasse =currentEleve.getClasse();
			
			update();
		} else if (node instanceof Classe) {
			currentClasse = (Classe) node;
			currentEleve = null;
			update();
			
		} else {
			System.out.println("Print");
		}

	}

	/**
	 * @return the currentEleve
	 */
	public Eleve getCurrentEleve() {
		return currentEleve;
	}

	/**
	 * @return the currentClasse
	 */
	public Classe getCurrentClasse() {
		return currentClasse;
	}

	/**
	 * Recepteur des modifs de table
	 */
	public void afficheInfo(View this,Eleve node) {
		if (node instanceof Eleve) {
			currentEleve = node;
			currentClasse =currentEleve.getClasse();
			update();
		}
	}

	/**
	 * Met a jour tous les champs de la view;
	 */
	public void update() {
		if (currentEleve != null) {
			txtSexe.setText(currentEleve.getSexe());
			txtAge.setText(currentEleve.getAge());
			txtNom.setText(currentEleve.getNom());
			txtPrenom.setText(currentEleve.getPrenom());
			String taille = ""
					+ (currentEleve.getClasse().getNombreEleves() + "");
			txtNombreEleves.setText(taille);
			txtProf.setText(currentEleve.getClasse().getProf());
			txtNiveau.setText("" + currentEleve.getClasse().getNiveau());
			this.viewTable.setData(currentEleve.getClasse());
		} else if (currentClasse != null) {
			String taille = "" + (currentClasse.getNombreEleves());
			txtNombreEleves.setText(taille);
			txtProf.setText(currentClasse.getProf());
			txtNiveau.setText("" + currentClasse.getNiveau());
			this.viewTable.setData(currentClasse);
			txtSexe.setText("");
			txtAge.setText("");
			txtNom.setText("");
			txtPrenom.setText("");
		} else {
			System.out.println("null");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();

					frame.createTree();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
