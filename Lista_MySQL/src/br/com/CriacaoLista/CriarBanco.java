package br.com.CriacaoLista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException  {
		
		

		final String url = "jdbc:mysql://localhost";
		final String usuario = "root";
		final String senha = "admin123";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE curso_java");
	
		System.out.println("Banco Cirado Com sucesso!");
		conexao.close();

	}

}
