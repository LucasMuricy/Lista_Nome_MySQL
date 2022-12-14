package br.com.CriacaoLista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o Código: ");
		int codigo = entrada.nextInt();

		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM  pessoas WHERE codigo = ?";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);

		if (stmt.executeUpdate() > 0) {
			System.out.println("Pessoa Excluida com Sucesso!");
		} else {
			System.out.println("Nada Feito, Codigo não encontrado!");
		}

		conexao.close();
		entrada.close();
	}

}
