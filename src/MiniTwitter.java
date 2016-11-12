import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;


public class MiniTwitter {

	private JFrame frame;
	private JTextField userID;
	private JTextField groupID;
	private JTree tree;
	private ArrayList<User> group = new ArrayList();
	UserList ul = new UserList();



	/**
	 * Create the application.
	 */
	public MiniTwitter() {

		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

        //Create a tree that allows one selection at a time.
        tree = new JTree();
        tree.setModel(new DefaultTreeModel(
        	new DefaultMutableTreeNode("Root") {
        		{
        		}
        	}
        ));
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		tree.setBounds(10, 11, 140, 239);
		frame.getContentPane().add(tree);
		tree.removeAll();
		
		userID = new JTextField();
		userID.setBounds(160, 11, 190, 20);
		frame.getContentPane().add(userID);
		userID.setColumns(10);
		
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(userID.getText());

				model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
				User u = new User(userID.getText());

				ul.addUser(u);
				model.reload();
				
			}
		});
		addUser.setBounds(360, 8, 114, 23);
		frame.getContentPane().add(addUser);

		groupID = new JTextField();
		groupID.setBounds(160, 45, 190, 20);
		frame.getContentPane().add(groupID);
		groupID.setColumns(10);
		
		JButton addGroup = new JButton("Add Group");
		addGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if(!selectedNode.isLeaf()){
					
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode(groupID.getText());
					selectedNode.add(node_1);
					String selectedNodeName = selectedNode.toString();
					User u = new User(selectedNodeName);
					group.add(u);
					model.reload();
				}
			}
		});
		addGroup.setBounds(360, 44, 114, 23);
		frame.getContentPane().add(addGroup);
		
		JButton userView = new JButton("Open User View");
		userView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String selectedNodeName = selectedNode.toString();
				User u = ul.getUserName(selectedNodeName);
				UserView openView = new UserView();
				openView.setUser(u);
				openView.setUserList(ul);
				openView.run();
				
			}
		});
		userView.setBounds(160, 76, 314, 23);
		frame.getContentPane().add(userView);
		
		JButton showMessages = new JButton("Show Messages Total");
		showMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Test");
			}
		});
		showMessages.setBounds(160, 227, 148, 23);
		frame.getContentPane().add(showMessages);
		
		JButton showPositives = new JButton("Show Positive Messages");
		showPositives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Test");
			}
		});
		showPositives.setBounds(326, 227, 148, 23);
		frame.getContentPane().add(showPositives);
		
		JButton showTotal = new JButton("Show User Total");
		showTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Test");
			}
		});
		showTotal.setBounds(160, 193, 148, 23);
		frame.getContentPane().add(showTotal);
		
		JButton showGroupTotal = new JButton("Show Group Total");
		showGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Number of Groups: " + group.size());
			}
		});
		showGroupTotal.setBounds(326, 193, 148, 23);
		frame.getContentPane().add(showGroupTotal);
		
	}
}
