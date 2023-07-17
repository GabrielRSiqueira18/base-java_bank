package repositories;

import java.util.List;
import java.util.UUID;

import entities.User;

public interface InterfaceUsers {
	public User getUserById(UUID id, List<User> users);
	public List<User> getUserByEmail(String email, List<User> users);
	public User getUserByPasword(UUID id, List<User> users);
	public void listUsers(List<User> users);
	public void registerUser(String name, String email, String password);
}
