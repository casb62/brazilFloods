package com.casb.application;

import java.util.Scanner;

/**
*
* @author Cássio Alberto Santos Baptistussi
*/

public class BrazilFloodsApplication {
	
	// Constants that represent menu's options.
		private static final int LOGOUT = 0;
		private static final int SHOW_HELP = 1;
		private static final int ADD_USER = 2;
		
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
		System.out.println("1 - Exibir ajuda.");
		System.out.println("0 - Sair.");
	}
	
	static private int getInput() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while (choice < 0 || choice > 1) {
			try {
				System.out.print("\nDigite sua opção: ");
				choice = Integer.parseInt(sc.next());
				sc.close();
			} catch (NumberFormatException e) {
				System.out.println("Opção inválida. Por favor, tente novamente.");
			}
		}
		return choice;
	}
	
	static private void performAction(int choice) {
		Scanner sc = new Scanner(System.in);
		switch (choice) {
		case LOGOUT:
			exit = true;
			System.out.println("\nObrigado por usar este software.\n");
			break;
		case SHOW_HELP:
			System.out.println("\n----------IMPORTANTE. LEIA ANTES DE USAR O SISTEMA.----------");
			break;
		default:
			System.out.println("Um erro desconhecido ocorreu.");
			sc.close();
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