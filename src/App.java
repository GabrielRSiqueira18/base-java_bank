import repositories.UserRepository;
import services.CreateUser;

public class App {
	public static void main(String[] args) throws Exception {
		UserRepository userRepository = new UserRepository();

		CreateUser createUser = new CreateUser(userRepository);
	}
}
