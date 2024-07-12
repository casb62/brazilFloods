package com.casb.application;

import java.util.Scanner;
import com.casb.entities.Donation;

/**
*
* @author Cássio Alberto Santos Baptistussi
*/

public class BrazilFloodsApplication {
	
	// Constants that represent menu's options.
		private static final int LOGOUT = 0;
		private static final int SHOW_HELP = 1;
		private static final int CREATE_DONATION = 2;
		private static final int RETRIEVE_DONATION = 3;
		private static final int UPDATE_DONATION = 4;
		private static final int DELETE_DONATION = 5;
		
		static boolean exit;

	public static void main(String[] args) {
		
			
		
		runMenu();
	}
	
	
	public static void runMenu() {
		
		while(!exit){
			printHeader();
			showHelp();
			printMenu();
			int choice = getInput();
			performAction(choice);
			clearScreen();
		}
	}
	
	static private void printHeader() {
		System.out.println("                                                 +-----------------------------------------------+");
		System.out.println("                                                 |          Software para gerenciamento          |");
		System.out.println("                                                 |        de crises causadas por enchentes       |");
		System.out.println("                                                 +-----------------------------------------------+");
	}
	
	static private void printMenu() {
		System.out.println("\nEscolha uma opção:\n");
		System.out.println("0 - Sair.");
		System.out.println("1 - Exibir ajuda.");
		System.out.println("2 - Registrar doação.");
		System.out.println("3 - Ler doações.");
		System.out.println("4 - Atualizar doação.");
		System.out.println("5 - Deletar doação.");
	}
	
	static private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 5) {
			try {
				System.out.print("\nDigite sua opção: ");
				choice = Integer.parseInt(sc.next());
				}
				catch (NumberFormatException e) {
				System.out.println("Opção inválida. Por favor, tente novamente.");
				sc.close();
			}
		}
		return choice;
	}
	
	static private void performAction(int choice) {
		switch (choice) {
		case LOGOUT:
			exit = true;
			System.out.println("\nObrigado por usar este software.\n");
			break;
		case SHOW_HELP:
			System.out.println("\n----------IMPORTANTE. LEIA ANTES DE USAR O SISTEMA.----------");
			break;
		case CREATE_DONATION:
			Donation don = new Donation();
			don.createDonation();
			break;
		case RETRIEVE_DONATION:
			don = new Donation();
			don.retrieveDonation();
			break;
		case UPDATE_DONATION:
			don = new Donation();
			don.updateDonation();
			break;
		case DELETE_DONATION:
			don = new Donation();
			don.deleteDonation();
		default:
			System.out.println("Um erro desconhecido ocorreu.");
		}
	}
	
	public static void clearScreen() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		
	}
	
	public static void showHelp() {
		System.out.println("Help menu");
	}
}