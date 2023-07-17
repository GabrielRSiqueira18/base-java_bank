package entities;

import java.util.UUID;

public class User {
	private final UUID ID;
	private String name;
	private String email;
	private String password;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.ID = UUID.randomUUID();
	}

	public UUID getUserId() {
		return this.ID;
	}

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
