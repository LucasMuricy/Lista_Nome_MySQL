package br.com.CriacaoLista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		
		//Criando Conexão Com o Banco de Dados 
		
		final String url = "jdbc:mysql://localhost";
		final String usuario = "root";
		final String senha = "admin123";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();

	}

}
