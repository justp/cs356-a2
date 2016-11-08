
import java.util.ArrayList;
import java.util.List;

public class User implements Observer{
	
	private String name;
	private List<User> followers;
	private List<User> following;
	private List<String> messages;
	
	public User(String n){
		name = n;
		followers = new ArrayList();
		messages  = new ArrayList();
	}
	
	public String getName(){
		return name;
	}
	
	public void addFollower(User u){
		followers.add(u);
	}
	
	public void addMessage(String s){
		messages.add(s);
	}
	
	public List<User> getFollowers(){

		return followers;
	}
	
	public List<String> getMessages(){

		return messages;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

}
