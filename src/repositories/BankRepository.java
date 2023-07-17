package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Bank;
import repositories.interfaces.InterfaceBank;

public class BankRepository implements InterfaceBank {
	List<Bank> banks = new ArrayList<>();
	
	@Override
		public Bank create(String name) {
			Bank bank = new Bank(name);
			banks.add(bank);
			System.out.println(banks);
			return bank;
		}

	@Override
	public Bank getBankByName(String name) {
		return banks.stream().filter(bank -> bank.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public void listAllBanks() {
		for(int i = 0; i < banks.size(); i++) {
			System.out.print("Nome do " + (i + 1) + " banco: ");
			System.out.println(banks.get(i).getName());
			System.out.print("Total de dinheiro do " + (i + 1) + " banco: ");
			System.out.println(banks.get(i).getMoney());
		}
	}
}
