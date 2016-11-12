import java.util.ArrayList;

public class UserList {
	
	private ArrayList<User> users = new ArrayList();
	
	public void addUser(User u){
		users.add(u);
	}
	
	public User getUser(User s){
		int i = users.size(), j = 0;
		
		while(i < j){
			User u = users.get(j);
			if(u == s){
				break;
			}
			else{
				j++;
			}
		}
		
		return users.get(j);
	}
	
	public User getUserName(String s){
		int i = users.size(), j = 0;
		
		while(i < j){
			User u = users.get(j);
			if(u.getName().compareTo(s) == 0){
				break;
			}
			else{
				j++;
			}
		}
		
		return users.get(j);
	}

}
