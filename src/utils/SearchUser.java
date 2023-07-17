package utils;

import java.util.List;

import entities.User;
import repositories.UserRepository;

public class SearchUser {
	public static User getUser(String email, String password, UserRepository userRepository) {
		User user = null;
		List<User> usersWithPassword = userRepository.getUserByPasword(password);

		for(User userTarget : usersWithPassword) {
			if(userTarget.getEmail().equals(email)) {
				user = userTarget;
			}
		}

		return user;
	}
}
