import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView{

	private JFrame frame;
	private JTextField follow;
	private JTextField message;
	private User user;
	private UserList ul;
	DefaultListModel listModel = new DefaultListModel();
	DefaultListModel newModel = new DefaultListModel();
	//private ArrayList<User> ul = new ArrayList();

	public void run() {
		try {
			UserView window = new UserView();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public UserView() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		follow = new JTextField();
		follow.setBounds(10, 11, 165, 20);
		frame.getContentPane().add(follow);
		follow.setColumns(10);
		
		JButton followButton = new JButton("Follow User");
		followButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = follow.getText();
				User x = ul.getUserName(s);
				user.addFollower(x);
			}
		});
		followButton.setBounds(185, 10, 89, 23);
		frame.getContentPane().add(followButton);
		
		
		JList currentFollowers = new JList(listModel);
		currentFollowers.setBounds(38, 42, 213, 79);
		frame.getContentPane().add(currentFollowers);
		ArrayList<User> l = new ArrayList();
		
		listModel.addElement("Current Followers");
		for(int i = 0; i < l.size(); i++){
			listModel.addElement(l.get(i).getName());
		}
		
		message = new JTextField();
		message.setBounds(10, 132, 165, 20);
		frame.getContentPane().add(message);
		message.setColumns(10);
		
		JButton postTweet = new JButton("Post Tweet");
		postTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = follow.getText();
				user.addMessage(p);
			}
		});
		postTweet.setBounds(185, 132, 89, 23);
		frame.getContentPane().add(postTweet);
		
		
		
		JList newFeed = new JList(newModel);
		newFeed.setBounds(20, 164, 254, 86);
		frame.getContentPane().add(newFeed);
		List<String> m = new ArrayList<>();
		//m = user.getMessages();
		newModel.addElement("News Feed");
		for(int i = 0; i < l.size(); i++){
			listModel.addElement(m.get(i));
		}
		
	}
	
	public void setUser(User u){
		user = u;
	}
	public void setUserList(UserList l){
		ul = l;
	}

}
