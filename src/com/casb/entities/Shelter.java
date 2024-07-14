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

public class Shelter {
	
	private Integer id;
	private String name;
	private String sponsor;
	private String phone;
	private String email;
	private Integer addressId;
	
	public Shelter() {
	}

	public Shelter(Integer id, String name, String sponsor, String phone, String email, Integer addressId) {
		super();
		this.id = id;
		this.name = name;
		this.sponsor = sponsor;
		this.phone = phone;
		this.email = email;
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

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
public void createShelter() {
		
		System.out.println("Entre com os dados do Abrigo que deseja criar!\n");
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
			System.out.println("Nome do responsável: ");
			String sponsor = sc.nextLine();
			System.out.println("Telefone do abrigo: ");
			String phone = sc.next();
			System.out.println("Email do abrigo: ");
			String email = sc.next();
									
			Connection conn = DB.openConnection();
			PreparedStatement st = null;
			
			try {
				
				st = conn.prepareStatement("INSERT INTO bf_address" + "(public_place, place_number, "	
				+ "neighborhood, city, federation_unity, zipcode)" + "VALUES " 
				+ "(?, ?, ?, ?, ?, ?)");
				st.setString(1, public_place);
				st.setString(2, place_number);
				st.setString(3, neighborhood);
				st.setString(4, city);
				st.setString(5, federation_unity);
				st.setString(6, zipcode);
				ResultSet rs = st.getGeneratedKeys();
				int address_id = rs.getInt(1);
				st.executeUpdate();
				
				st = conn.prepareStatement("INSERT INTO bf_shelter"
				+ "(name, address_id, sponsor, phone, email)"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?)");
				
				st.setString(1, name);
				st.setInt(2, address_id);
				st.setString(3, sponsor);
				st.setString(4, phone);
				st.setString(5, email);
				st.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnection();
			}
			finish = true;
			sc.close();
		}
		while(!finish);
}
	
	public void retrieveShelters() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs1 = st.executeQuery("SELECT * FROM bf_shelter");
			rs2 = st.executeQuery("SELECT * FROM bf_address");
			
			while(rs1.next()) {
				System.out.println(rs1.getInt("id") + ", " + rs1.getString("name"));
				while(rs2.next()) {
					System.out.println(rs2.getInt("id") + ", " + rs2.getString("public_place") + ", " + rs2.getString("place_number") + ", "
					+ rs2.getString("neighborhood") + ", " + rs2.getString("city") + ", " + rs2.getString("federation_unity") + ", "
					+ rs2.getString("zipcode"));
				}
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
	
public void retrieveShelter(int id) {
		//implementar metodo para mostrar estoque
		Connection conn = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs1 = st.executeQuery("SELECT * FROM bf_shelter");
			rs2 = st.executeQuery("SELECT * FROM bf_address");
			
			while(rs1.next()) {
				if(rs1.getInt("id") == id) {
					System.out.println(rs1.getInt("id") + ", " + rs1.getString("name"));
					while(rs2.next()) {
						System.out.println(rs2.getInt("id") + ", " + rs2.getString("public_place") + ", " + rs2.getString("place_number") + ", "
						+ rs2.getString("neighborhood") + ", " + rs2.getString("city") + ", " + rs2.getString("federation_unity") + ", "
						+ rs2.getString("zipcode"));
					}	
				}
				
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
	
	public void updateShelter() {
		
		Connection conn = null;
		PreparedStatement pt = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Digite o número id do Abrigo que deseja atualizar: ");
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
		System.out.println("Nome do responsável: ");
		String sponsor = sc.nextLine();
		System.out.println("Telefone do abrigo: ");
		String phone = sc.next();
		System.out.println("Email do abrigo: ");
		String email = sc.next();
			
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs1 = st.executeQuery("SELECT * FROM bf_shelter");
			rs2 = st.executeQuery("SELECT * FROM bf_address");
			if(id == this.getId()) {
			
				pt = conn.prepareStatement("UPDATE bf_address " + "SET public_place = ? " + "SET place_number = ? " 
				+ "SET neighborhood = ? " + "SET city = ? " + "SET federation_unity = ? " + "SET zipcode = ? " + "WHERE " + "(id = ? )");
				pt.setString(1, public_place);
				pt.setString(2,place_number);
				pt.setString(3, neighborhood);
				pt.setString(4, city);
				pt.setString(5, federation_unity);
				pt.setString(6, zipcode);
				pt.setInt(7, this.getAddressId());
				int rowsAffected = pt.executeUpdate();
				System.out.println("Ok. Rows affected: " + rowsAffected);
				
				pt = conn.prepareStatement("UPDATE bf_shelter " + "SET name = ? " + "SET address_id = ? " + "SET sponsor = ? " 
				+ "SET phone = ? " + "SET email = ? " + "WHERE " + "(id = ? )" );
				pt.setString(1, name);
				pt.setInt(2, this.getAddressId());
				pt.setString(3, sponsor);
				pt.setString(4, phone);
				pt.setString(5, email);
				pt.setInt(6, id);
	 			rowsAffected = pt.executeUpdate();
				System.out.println("Ok. Rows affected: " + rowsAffected);
			}
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
		
	public void deleteShelter() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
			
		try {
			System.out.println("Digite o número id do Abrigo que deseja deletar: ");
			int id = sc.nextInt();
			conn = DB.openConnection();
			st = conn.prepareStatement("DELETE FROM bf_shelter " + "WHERE" + "id = ?");
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
		Shelter other = (Shelter) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Shelter [id=" + id + ", name=" + name + ", sponsor=" + sponsor + ", phone=" + phone + ", email=" + email
				+ ", addressId=" + addressId + "]";
	}
}