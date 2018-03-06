package sdz.controller;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import sdz.View.View;

public class ControllerTree implements TreeSelectionListener {

	private View view;
	private JTree tree;

	public ControllerTree(View view, JTree tree) {
		this.view = view;
		this.tree = tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			return;
		else {

			Object nodeInfo = node.getUserObject();
			System.out.println("node info " + nodeInfo);
			view.afficheInfo(nodeInfo);
		}

	}

}
