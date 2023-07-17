package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import entities.User;
import repositories.interfaces.InterfaceUsers;

public class UserRepository implements InterfaceUsers  {
	public List<User> users = new ArrayList<>();

	@Override
	public User getUserById(UUID id) {
		return users.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);
	}

	@Override
	public void listUsers() {
		int i = 1;
		for(User user : users) {
			System.out.println("Nome do usuário " + i + ": " + user.getName());
			System.out.println("Email do usuário " + i + ": " + user.getEmail());
			i++;
		}
	}

	@Override
	public User registerUser(String name, String email, String password) {
		if(getUserByEmail(email) != null) {
			return null;
		}

		User user = new User(name, email, password);
		users.add(user);

		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public List<User> getUserByPasword(String password) {
		return users.stream().filter(user -> user.getPassword().equals(password)).collect(Collectors.toList());
	}

	@Override
	public List<User> fetchUsers() {
		return users;
	}
}
