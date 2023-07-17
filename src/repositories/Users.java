package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.User;

public class Users implements InterfaceUsers {
	public List<User> users = new ArrayList<>();

	@Override
	public User getUserById(UUID id, List<User> users) {
		return users.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);
	}

	@Override
	public void listUsers(List<User> users) {
		for(User user : users) {
			int i = 1;
			System.out.println("Nome do usuário " + i + ": " + user.getName());
			System.out.println("Email do usuário " + i + ": " + user.getEmail());
			i++;
		}
	}

	@Override
	public void registerUser(String name, String email, String password) {
		User user = new User(name, email, password);
		users.add(user);
	}

}
