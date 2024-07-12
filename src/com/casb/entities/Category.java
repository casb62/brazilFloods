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

public class Category {

	private Integer id;
	private String name;
	
	public Category() {
	}

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
public void createCategory() {
		
		System.out.println("Entre com os nomes das categorias que deseja criar!\n");
		Scanner sc = new Scanner(System.in);
		boolean finish = false;
		do {
			System.out.println("Nome: ");
			String name = sc.nextLine();
						
			Connection conn = DB.openConnection();
			PreparedStatement st = null;
			
			try {
				st = conn.prepareStatement("INSERT INTO bf_category"
				+ "(name)"
				+ "VALUES "
				+ "(?)");
				
				st.setString(1, name);
								
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
	
	public void retrieveCategory() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.openConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM bf_category");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
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
	
	public void updateCategory() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
				
		try {
			System.out.println("Digite o número id da categoria que deseja atualizar: ");
			int id = sc.nextInt();
			System.out.println("Digite o nome: ");
						
			conn = DB.openConnection();
			st = conn.prepareStatement("UPDATE bf_category " + "SET name = ? " + "WHERE " + "(id = ? )" );
			st.setString(1, name);
			st.setInt(2, id);
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
	
	public void deleteCategory() {
		
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
			
		try {
			System.out.println("Digite o número id da categoria que deseja deletar: ");
			int id = sc.nextInt();
			conn = DB.openConnection();
			st = conn.prepareStatement("DELETE FROM bf_category " + "WHERE" + "id = ?");
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
