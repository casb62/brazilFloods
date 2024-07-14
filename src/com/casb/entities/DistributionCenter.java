package com.casb.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;
import com.casb.db.DB;
import com.casb.db.DBIntegrityException;

public class DistributionCenter {

	private Integer id;
	private String name;
	private Integer addressId;
	
	public DistributionCenter() {
	}

	public DistributionCenter(Integer id, String name, Integer addressId) {
		super();
		this.id = id;
		this.name = name;
		this.addressId = addressId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
public void createDistributionCenter() {
		
		System.out.println("Entre com os dados do centro de distribuição que deseja criar!\n");
		Scanner sc = new Scanner(System.in);
		boolean finish = false;
		do {
			System.out.println("Nome: ");
			String name = sc.nextLine();
			System.out.println("Rua/Avenida: ");
			String public_place = sc.nextLine();
			System.out.println("Número: ");
			String place_number = sc.next();
			System.out.println("Bairro: ");
			String neighborhood = sc.nextLine();
			System.out.println("Cidade: ");
			String city = sc.nextLine();
			System.out.println("Estado: ");
			String federation_unity = sc.next();
			System.out.println("CEP: ");
			String zipcode = sc.next();
						
			Connection conn = DB.openConnection();
			PreparedStatement st = null;
			
			try {
				
				st = conn.prepareStatement("INSERT INTO bf_address" + "(public_place, place_number, "
						+ "neighborhood, city, federation_unity, zipcode)" + "VALUES " + "(?, ?, ?, ?, ?, ?)");
				st.setString(1, public_place);
				st.setString(2, place_number);
				st.setString(3, neighborhood);
				st.setString(4, city);
				st.setString(5, federation_unity);
				st.setString(6, zipcode);
				ResultSet rs = st.getGeneratedKeys();
				int address_id = 0;
				while(rs.next()) {
					address_id = rs.getInt(1);
				}
				
				st = conn.prepareStatement("INSERT INTO bf_distribution_center"
				+ "(name, address_id)"
				+ "VALUES "
				+ "(?, ?)");
				
				st.setString(1, name);
				st.setInt(2, address_id);
												
				st.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnection();
			}
			System.out.println("Deseja cadastrar outra?(Y/N)?");
			String opcao = sc.next();
			if(opcao.equalsIgnoreCase("Y")) {
				finish = false;
			}
			else if(opcao.equalsIgnoreCase("N")) {
				finish = true;
			}
		}
		while(!finish);
		sc.close();
	}
	
	public void retrieveDistributionCenter() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs1 = st.executeQuery("SELECT * FROM bf_distribution_center");
			rs2 = st.executeQuery("SELECT * FROM bf_address");

				System.out.println(rs1.getInt("id") + ", " + rs1.getString("name"));
				while(rs2.next()) {
					System.out.println(rs2.getInt("id") + ", " + rs2.getString("public_place") + ", " + rs2.getString("place_number") + ", "
					+ rs2.getString("neighborhood") + ", " + rs2.getString("city") + ", " + rs2.getString("federation_unity") + ", "
					+ rs2.getString("zipcode"));
				}
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs1);
			DB.closeResultSet(rs2);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	public void updateDistributionCenter() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
				
		try {
			System.out.println("Digite o número id do Centro de Distribuição que deseja atualizar: ");
			int id = sc.nextInt();
			System.out.println("Digite o nome: ");
			String name = sc.nextLine();
			System.out.println("Rua/Avenida: ");
			String public_place = sc.nextLine();
			System.out.println("Número: ");
			String place_number = sc.next();
			System.out.println("Bairro: ");
			String neighborhood = sc.nextLine();
			System.out.println("Cidade: ");
			String city = sc.nextLine();
			System.out.println("Estado: ");
			String federation_unity = sc.next();
			System.out.println("CEP: ");
			String zipcode = sc.next();
			conn = DB.openConnection();
			st = conn.prepareStatement("UPDATE bf_distribution_center " + "SET name = ? " + "SET public_place = ? " + "SET place_number = ? " 
			+ "SET neighborhood = ? " + "SET city = ? " + "SET federation_unity = ? " + "SET zipcode = ? " + "WHERE " + "(id = ? )" );
			st.setString(1, name);
			st.setString(2, public_place);
			st.setString(3,place_number);
			st.setString(4, neighborhood);
			st.setString(5, city);
			st.setString(6, federation_unity);
			st.setString(7, zipcode);
			st.setInt(8, id);
 			int rowsAffected = st.executeUpdate();
			System.out.println("Ok. Rows affected: " + rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
}
	
	public void deleteDistributionCenter() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
			
		try {
			System.out.println("Digite o número id do Centro de Distribuição que deseja deletar: ");
			int id = sc.nextInt();
			conn = DB.openConnection();
			st = conn.prepareStatement("DELETE FROM bf_distribution_center " + "WHERE" + "id = ?");
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			System.out.println("Ok. Rows affected: " + rowsAffected);
		}
		catch(SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistributionCenter other = (DistributionCenter) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DistributionCenter [id=" + id + ", name=" + name + ", addressId=" + addressId + "]";
	}
}