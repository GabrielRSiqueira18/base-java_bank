package entities;

import java.time.LocalDate;

import repositories.UserRepository;

public class Bank {
	private String name;
	private LocalDate createdAt;
	private UserRepository userRepository;
	private Double money;

	public Bank(String name) {
		this.name = name;
		createdAt = LocalDate.now();
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

	public void withdrawn(String userEmail, double moneyWithdray) {
		User user = userRepository.getUserByEmail(userEmail);

		if(user == null) {
			System.out.println("Usuário inexistente no banco.");
		} else {
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
	}

	public void deposit(String userEmail, double moneyDeposit) {
		User user = userRepository.getUserByEmail(userEmail);

		if(user == null) {
			System.out.println("Usuário inexistente no banco.");
		} else {
			double userMoney = user.getMoney();

			if(userMoney < moneyDeposit) {
				System.out.println("Quantia inválida, insira um valor que você tenha");
				System.out.println("Valor que você tem: " + userMoney);
			} else {
				money += moneyDeposit;
				user.increaseMoneyInBank(moneyDeposit);
				user.decreaseMoney(moneyDeposit);
				System.out.println("Dinheiro retirado da usa carteira");
				System.out.println("Adicionado no banco: R$" +  moneyDeposit);
				System.out.println("Dinheiro atualizado no banco: R$" + user.getMoneyInBank());
			}
		}
	}
}