package repositories.interfaces;

import java.util.List;
import java.util.UUID;

import entities.User;

public interface InterfaceUsers {
	public User getUserById(UUID id, List<User> users);
	public User getUserByEmail(String email, List<User> users);
	public List<User> getUserByPasword(String password, List<User> users);
	public void listUsers(List<User> users);
	public User registerUser(String name, String email, String password);
	public List<User> fetchUsers();
}
