package br.com.CriacaoLista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

	public static void main(String[] args) throws SQLException {

		// Alterando o Nome da peossa na lista MySQL usando o cogido 
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o Código da Pessoa: ");
		int codigo = entrada.nextInt();

		String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ? ";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();

		if (r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));

			System.out.println("O Nome atual é: " + p.getNome());
			entrada.nextLine();

			System.out.print("Informe o novo nome: ");
			String novoNome = entrada.nextLine();

			stmt.close();
			// Novo STMT 
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);
			stmt.execute();
			System.out.println("Pessoa alterada Com Sucesso!");
		}else {
			System.out.println("PEssoa não encontrada!");
		}
			


		entrada.close();
		conexao.close();
	}

}
