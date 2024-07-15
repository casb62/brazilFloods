package com.casb.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.casb.db.DB;
import com.casb.db.DBIntegrityException;

public class Donation {

	private Integer id;
	private String description;
	private String unitOfMeasurement;
	private Integer quantity;
	private String gender;
	private String size;
	private Date validity;
	private Integer categoryId;
	private Integer distributionCenterId;
	
	public Donation() {
	}

	public Donation(Integer id, String description, String unitOfMeasurement, Integer quantity, String gender, String size, Date validity,
			Integer categoryId, Integer distributionCenterId) {
		super();
		this.id = id;
		this.description = description;
		this.unitOfMeasurement = unitOfMeasurement;
		this.quantity = quantity;
		this.gender = gender;
		this.size = size;
		this.validity = validity;
		this.categoryId = categoryId;
		this.distributionCenterId = distributionCenterId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getDistributionCenterId() {
		return distributionCenterId;
	}

	public void setDistributionCenterId(Integer distributionCenterId) {
		this.distributionCenterId = distributionCenterId;
	}
	
	public void createDonation() {
		
		System.out.println("Entre com os dados dos produtos recebidos um por vez!\n");
		Scanner sc = new Scanner(System.in);
		boolean finish = false;
		do {
			System.out.println("Descrição: ");
			String des = sc.nextLine();
			System.out.println("Unidade de medida: ");
			String uni = sc.next();
			System.out.println("Quantidade: ");
			int qty = sc.nextInt();
			System.out.println("Gênero(M/F): ");
			String gen = sc.next();
			System.out.println("Tamanho: ");
			String siz = sc.next();
			System.out.println("Data de validade(dd/MM/yyyy): ");
			String dat = sc.next();
			System.out.println("Número da categoria: ");
			int cat = sc.nextInt();
			System.out.println("Número do Centro de Distribuição: ");
			int dis = sc.nextInt();
			
			Connection conn = DB.openConnection();
			PreparedStatement st = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				st = conn.prepareStatement("INSERT INTO bf_donations"
				+ "(description, unit_of_measurement, quantity, gender, size, validity, category_id, distribution_center_id)"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)");
				
				st.setString(1, des);
				st.setString(2, uni);
				st.setInt(3, qty);
				st.setString(4, gen);
				st.setString(5, siz);
				st.setDate(6, new java.sql.Date(sdf.parse(dat).getTime()));
				st.setInt(7, cat);
				st.setInt(8, dis);
				
				st.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnection();
			}
			System.out.println("Deseja cadastrar outro?(Y,N)?");
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
	
	public void retrieveDonation() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM bf_donations");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("description") + ", " + rs.getString("unit_of_measurement") + ", " 
				+ rs.getString("gender") + ", " + rs.getString("size") + ", " + rs.getDate("validity") + ", " + rs.getInt("category_id") + ", " 
				+ rs.getInt("distribution_center_id") + ", " + rs.getInt("quantity"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	public void updateDonation() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Digite o número id do item de doação que deseja atualizar: ");
			int id = sc.nextInt();
			System.out.println("Digite a descrição: ");
			String description = sc.nextLine();
			System.out.println("Unidade de medida: ");
			String unitOfMeasurement = sc.next();
			System.out.println("Gênero(M/F): ");
			String gender = sc.next();
			System.out.println("Tamanho: ");
			String size = sc.next();
			System.out.println("Data de Validade(dd/MM/yyyy): ");
			String validity = sc.next();
			System.out.println("Categoria: ");
			int categoryId = sc.nextInt();
			System.out.println("Centro de Distribuição: ");
			int distributionCenterId = sc.nextInt();
			System.out.println("Quantidade: ");
			int quantity = sc.nextInt();
			
			conn = DB.openConnection();
			st = conn.prepareStatement("UPDATE bf_donations " + "SET description = ? " + "SET unit_of_measurement = ? " + "SET gender = ? " +
			"SET size = ? " + "SET validity = ?" + "SET category_id = ? " + "SET distribution_center_id = ? " + "SET quantity = ? " + 
			 "WHERE " + "(id = ? )" );
			st.setString(1, description);
			st.setString(2, unitOfMeasurement);
			st.setString(3, gender);
			st.setString(4, size);
			st.setDate(5, new java.sql.Date(sdf.parse(validity).getTime()));
			st.setInt(6, categoryId);
			st.setInt(7, distributionCenterId);
			st.setInt(8, quantity);
			st.setInt(9, id);
			int rowsAffected = st.executeUpdate();
			System.out.println("Ok. Rows affected: " + rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
}
	
	public void deleteDonation() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
			
		try {
			System.out.println("Digite o número id do item de doação que deseja deletar: ");
			int id = sc.nextInt();
			conn = DB.openConnection();
			st = conn.prepareStatement("DELETE FROM bf_donations " + "WHERE" + "id = ?");
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
	
	public void insertDonationFromCsvFile() {
		
		CsvReading cr = new CsvReading();
		List<String> list = new ArrayList<>();
		list = cr.readFile();
		
		do {
		Connection conn = DB.openConnection();
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for(String string: list) {
			String[] t = string.split(",");
			try {
				st = conn.prepareStatement("INSERT INTO bf_donations"
				+ "(description, unit_of_measurement, gender, size, validity, category_id, distribution_center_id, quantity)"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)");
				
				st.setString(1, t[0]);
				st.setString(2, t[1]);
				st.setString(3, t[2]);
				st.setString(4, t[3]);
				st.setDate(5, new java.sql.Date(sdf.parse(t[4]).getTime()));
				st.setInt(6, Integer.parseInt(t[5]));
				st.setInt(7, Integer.parseInt(t[6]));
				st.setInt(8, Integer.parseInt(t[7]));
				
				st.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnection();
			}
		}
		}
		while(!list.isEmpty());
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
		Donation other = (Donation) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", description=" + description + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", gender=" + gender + ", size=" + size + ", validity=" + validity + ", categoryId=" + categoryId
				+ ", distributionCenterId=" + distributionCenterId + "]";
	}
}
