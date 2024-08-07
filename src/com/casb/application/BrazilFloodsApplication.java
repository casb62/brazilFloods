package com.casb.application;

import java.util.Scanner;
import com.casb.entities.Category;
import com.casb.entities.DistributionCenter;
import com.casb.entities.Donation;
import com.casb.entities.Shelter;

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
		private static final int CREATE_SHELTER = 14;
		private static final int RETRIEVE_SHELTERS = 15;
		private static final int RETRIEVE_SHELTER = 16;
		private static final int UPDATE_SHELTER = 17;
		private static final int DELETE_SHELTER = 18;
		private static final int INSERT_FROM_FILE = 19;
		
		Scanner sc = new Scanner(System.in);
		static boolean exit;

	public static void main(String[] args) {
		BrazilFloodsApplication bfa = new BrazilFloodsApplication();
		bfa.runMenu();
	}
	
	public void runMenu() {
		
		while(!exit){
			printHeader();
			printAlert();
			printMenu();
			int choice = getInput();
			performAction(choice);
			sc.nextLine();
			clearScreen();
		}
	}
	
	public void printHeader() {
		
		System.out.println("                                                 +-----------------------------------------------+");
		System.out.println("                                                 |   Software para gerenciamento de crises       |");
		System.out.println("                                                 |      causadas por enchentes no Brasil         |");
		System.out.println("                                                 +-----------------------------------------------+");
	}
	
	public void printAlert() {
		
		System.out.println("\n\n----------IMPORTANTE. LEIA A AJUDA NA OPÇÃO 1 DO MENU ANTES DE USAR O SISTEMA.----------\n\n");
	}
	
	public void printMenu() {
		
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
		System.out.println("14 - Registrar Abrigo.");
		System.out.println("15 - Ler Abrigos.");
		System.out.println("16 - Ler Abrigo.");
		System.out.println("17 - Atualizar Abrigo.");
		System.out.println("18 - Deletar Abrigo.");
		System.out.println("19 - Inserir doações através de um arquivo csv.");
	}
	
	public int getInput() {
		
		int choice = -1;
		while (choice < 0 || choice > 19) {
			try {
				System.out.print("\nDigite sua opção: ");
				choice = Integer.parseInt(sc.next());
				}
				catch (NumberFormatException e) {
				System.out.println("Opção inválida. Por favor, tente novamente.");
				
			}
		}
		return choice;
	}
	
	public void performAction(int choice) {
		
		switch (choice) {
		case LOGOUT:
			exit = true;
			System.out.println("\nObrigado por usar este software.\n");
			break;
		case SHOW_HELP:
			System.out.println(showHelp());
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
		case CREATE_SHELTER:
			Shelter she = new Shelter();
			she.createShelter();
			break;
		case RETRIEVE_SHELTERS:
			she = new Shelter();
			she.retrieveShelters();
			break;
		case RETRIEVE_SHELTER:
			she = new Shelter();
			System.out.println("Digite o número id do abrigo que deseja obter mais detalhes: ");
			int id = sc.nextInt();
			she.retrieveShelter(id);
			sc.close();
			break;
		case UPDATE_SHELTER:
			she = new Shelter();
			she.updateShelter();
			break;
		case DELETE_SHELTER:
			she = new Shelter();
			she.deleteShelter();
			break;
		case INSERT_FROM_FILE:
			don = new Donation();
			don.insertDonationFromCsvFile();
			break;
		default:
			System.out.println("Um erro desconhecido ocorreu.");
		}
	}
	
	public void clearScreen() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println();
		}
	}
	
	public String showHelp() {
		
		StringBuilder sb = new StringBuilder();
        sb.append("\nPara começar a usar este sistema, o primeiro passo é cadastrar as categorias dos itens das doações.\n");
        sb.append("Os itens obrigatórios são: Roupas, Higiene e Alimentos.\n");
        sb.append("Depois, cadastrar os Abrigos e Centros de Distribuição.\n");
        sb.append("Digitar as datas no formato dd/mm/aaaa.\n");
        return sb.toString();
	}
}