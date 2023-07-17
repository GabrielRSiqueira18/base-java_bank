package entities;

import java.time.LocalDate;
import java.util.UUID;

import repositories.interfaces.InterfaceBank;

public class User {
	private final UUID ID;
	private String name;
	private String email;
	private String password;
	private Double money;
	private Double moneyInBank;
	private Bank bank;
	private LocalDate bankEnteredAt;

	public User(String name, String email, String password) {
		this.ID = UUID.randomUUID();
		this.name = name;
		this.email = email;
		this.password = password;
		money = 0.0;
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

	public Double getMoney() {
		return money;
	}
	
	public Bank getBank() {
		return bank;
	}

	public UUID getID() {
		return ID;
	}

	public Double getMoneyInBank() {
		return moneyInBank;
	}

	public LocalDate getBankEnteredAt() {
		return bankEnteredAt;
	}

	public void increaseMoneyInBank(Double moneyInBank) {
		this.moneyInBank += moneyInBank;
	}

	public void decreaseMoneyInBank(Double moneyInBank) {
		this.moneyInBank -= moneyInBank;
	}

	public void increaseMoney(Double money) {
		this.money += money;
	}

	public void decreaseMoney(Double money) {
		this.money -= money;
	}

	public String toString() {
		return "Nome: " + name +
			"\nEmail: " + email +
			"\nSeu dinheiro: " + money +
			"\nBanco:\n" + bank +
			"\nEntrou no banco na data: " + bankEnteredAt +
			"\nDinheiro no banco: " + moneyInBank;
	}

	public void associateUserToBank(String bankName, InterfaceBank bankReposities) {
		if(bank != null) {
			System.out.println("Já cadastrado aa um banco\n" + bank);
			return;
		}

		Bank bank = bankReposities.getBankByName(bankName);

		this.bank = bank;
		this.bankEnteredAt = LocalDate.now();
	}
}
