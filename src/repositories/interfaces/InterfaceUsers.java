package repositories.interfaces;

import java.util.List;
import java.util.UUID;

import entities.User;

public interface InterfaceUsers {
	public User getUserById(UUID id);
	public User getUserByEmail(String email);
	public List<User> getUserByPasword(String password);
	public void listUsers(List<User> users);
	public User registerUser(String name, String email, String password);
	public List<User> fetchUsers();
}
