package com.casb.application;

import java.util.Scanner;

import com.casb.entities.Category;
import com.casb.entities.DistributionCenter;
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
		private static final int CREATE_CATEGORY = 6;
		private static final int RETRIEVE_CATEGORY = 7;
		private static final int UPDATE_CATEGORY = 8;
		private static final int DELETE_CATEGORY = 9;
		private static final int CREATE_DISTRIBUTION_CENTER = 10;
		private static final int RETRIEVE_DISTRIBUTION_CENTER = 11;
		private static final int UPDATE_DISTRIBUTION_CENTER = 12;
		private static final int DELELE_DISTRIBUTION_CENTER = 13;
		
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
		System.out.println("6 - Registrar categoria de produtos doados.");
		System.out.println("7 - Ler categorias.");
		System.out.println("8 - Atualizar categoria.");
		System.out.println("9 - Deletar categoria.");
		System.out.println("10 - Registrar Centro de Distribuição.");
		System.out.println("11 - Ler Centros de Distribuição.");
		System.out.println("12 - Atualizar Centro de Distribuição.");
		System.out.println("13 - Deletar Centro de Distribuição.");
	}
	
	static private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 13) {
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
			break;
		case CREATE_CATEGORY:
			Category cat = new Category();
			cat.createCategory();
			break;
		case RETRIEVE_CATEGORY:
			cat = new Category();
			cat.retrieveCategory();
			break;
		case UPDATE_CATEGORY:
			cat = new Category();
			cat.updateCategory();
			break;
		case DELETE_CATEGORY:
			cat = new Category();
			cat.deleteCategory();
			break;
		case CREATE_DISTRIBUTION_CENTER:
			DistributionCenter dis = new DistributionCenter();
			dis.createDistributionCenter();
			break;
		case RETRIEVE_DISTRIBUTION_CENTER:
			dis = new DistributionCenter();
			dis.retrieveDistributionCenter();
			break;
		case UPDATE_DISTRIBUTION_CENTER:
			dis = new DistributionCenter();
			dis.updateDistributionCenter();
			break;
		case DELELE_DISTRIBUTION_CENTER:
			dis = new DistributionCenter();
			dis.deleteDistributionCenter();
			break;
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