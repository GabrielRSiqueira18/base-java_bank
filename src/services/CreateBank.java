package services;

import entities.Bank;
import repositories.interfaces.InterfaceBank;

public class CreateBank {

	InterfaceBank bankRepositories;

	public CreateBank(InterfaceBank bankRepositories) {
		this.bankRepositories = bankRepositories;
	}

	public Bank execute(String name) {
		Bank bankWithSameName = bankRepositories.getBankByName(name);

		if(bankWithSameName != null) {
			System.out.println("Banco com o nome [" + name + "] " +  "já existe, insira outro nome");
		}
		
		Bank bank = new Bank(name);

		System.out.println("Banco com o nome: " + name + "criado com sucesso.");
		return bank;
	}
}