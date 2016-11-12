
import java.util.ArrayList;


public class User implements Observer{
	
	private String name;
	private ArrayList<User> followers;
	private ArrayList<User> following;
	private ArrayList<String> messages;
	
	public User(String n){
		name = n;
		messages = new ArrayList<String>();

	}
	public void test(){
		if(following.isEmpty()){
			System.out.println("Empty");
		}
	}
	
	public String getName(){
		return name;
	}
	public void addFollowing(User u){
		following.add(u);
	}
	
	public void addFollower(User u){
		followers.add(u);
	}
	
	public void addMessage(String s){
		System.out.println("Works so far");
		if(messages == null){
			messages = new ArrayList<String>();
		}
		messages.add(s);
	}
	
	public ArrayList<User> getFollowers(){

		return new ArrayList<User>(following);
	}
	
	public ArrayList<String> getMessages(){

		if(messages == null){
			return new ArrayList<String>();
		}
		
		else
			return messages;
	}
	
	public boolean checkFollowers(){
		if(following.get(0) == null){
			return false;
		}
		else
			return true;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

}
