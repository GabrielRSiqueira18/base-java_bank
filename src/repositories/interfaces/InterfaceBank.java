package repositories.interfaces;

import entities.Bank;

public interface InterfaceBank {
	public Bank getBankByName(String name);
	public Bank create(String name);
	public void listAllBanks();
}
