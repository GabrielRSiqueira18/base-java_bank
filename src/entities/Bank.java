package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String name;
	private LocalDate createdAt;
	private List<User> userRepository;
	private Double money;

	public Bank(String name) {
		this.name = name;
		createdAt = LocalDate.now();
		this.money = 0.0;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money += money;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "Nome do banco: " + name + "\nO banco foi criado na data: " + createdAt + "\nDinheiro do banco: " + money;
	}

	public void addUserRepository(User user) {
		if(user.getBank().getName().equals(name)) {
			System.out.println("Ja cadastrado neste banco");
			return;
		}

		if(userRepository == null) {
			List<User> users = new ArrayList<>();
			users.add(user);
			this.userRepository = users;
		} else {
			this.userRepository.add(user);
		}
	}

	public void withdrawn(User user, double moneyWithdray) {
		double userBankMoney = user.getMoneyInBank();

		if(userBankMoney < moneyWithdray) {
			System.out.println("Quantia inválida, insira um valor que esteja acessível no banco!");
			System.out.println("Valor que está no banco: " + userBankMoney);
		} else {
			money -= moneyWithdray;
			user.decreaseMoneyInBank(moneyWithdray);
			user.increaseMoney(moneyWithdray);
			System.out.println("Dinheiro aidionado em usa carteira");
			System.out.println("Adicionado: R$" +  moneyWithdray);
			System.out.println("Dinheiro atualizado: R$" + user.getMoney());
		}

	}

	public void deposit(User userTarget, double moneyDeposit) {
		

		double userMoney = userTarget.getMoney();

		if(userMoney < moneyDeposit) {
			System.out.println("Quantia inválida, insira um valor que você tenha");
			System.out.println("Valor que você tem: " + userMoney);
		} else {
			money += moneyDeposit;
			userTarget.increaseMoneyInBank(moneyDeposit);
			userTarget.decreaseMoney(moneyDeposit);
			System.out.println("Dinheiro retirado da usa carteira");
			System.out.println("Adicionado no banco: R$" +  moneyDeposit);
			System.out.println("Dinheiro atualizado no banco: R$" + userTarget.getMoneyInBank());
			}
		
	}
}