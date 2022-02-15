package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

import connector.ConexaoComBanco;
import model.CadastroCliente;

public class CadastroClienteService {
		
	public static void save() {
		Scanner sc = new Scanner(System.in);
		
		CadastroCliente cadastroCliente = new CadastroCliente();
		
		System.out.println("Digite seu nome");
		cadastroCliente.setNome(sc.nextLine());
		
		System.out.println("Digite seu CPF");
		cadastroCliente.setCpf(sc.nextLine());
		
		System.out.println("Digite seu email");
		cadastroCliente.setEmail(sc.nextLine());
		sc.nextLine();
		System.out.println("Digite seu endereço");
		cadastroCliente.setEndereco(sc.nextLine());
		
		
		
		String sql = "INSERT INTO cadastrocliente(nome, cpf, email, endereco)VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cadastroCliente.getNome());
			pstm.setString(2, cadastroCliente.getCpf());
			pstm.setString(3, cadastroCliente.getEmail());
			pstm.setString(4, cadastroCliente.getEndereco());
		
			
			pstm.execute();
			
			System.out.println("Cliente Cadastrado com sucesso");
			
			conn.close();
			pstm.close();
			
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		
		}
		}
		public static void deletar() {
			Scanner sc = new Scanner(System.in);
			
			CadastroCliente cadastroCliente = new CadastroCliente();
			
			System.out.println("Digite o Id do Cliente");
			cadastroCliente.setIdCliente(sc.nextInt());
			
			
			String sql = "DELETE FROM cadastrocliente where id = ? LIMIT 1";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, cadastroCliente.getIdCliente());
				
				
				
				pstm.execute();
				System.out.println("Cliente deletado com sucesso");
				conn.close();
				pstm.close();
				
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			
			}
		}
		public static void update() {
			Scanner sc = new Scanner(System.in);
			
			CadastroCliente cadastroCliente = new CadastroCliente();
			
			System.out.println("Digite o Id do Cliente");
			cadastroCliente.setIdCliente(sc.nextInt());
			System.out.println("Digite seu nome");
			cadastroCliente.setNome(sc.nextLine());
			sc.nextLine();
			
			System.out.println("Digite seu CPF");
			cadastroCliente.setCpf(sc.nextLine());
			System.out.println("Digite seu email");
			cadastroCliente.setEmail(sc.nextLine());
			System.out.println("Digite seu endereço");
			cadastroCliente.setEndereco(sc.nextLine());
			
			String sql = "UPDATE cadastrocliente set nome = ?, cpf = ?, email = ?, endereco = ? where id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cadastroCliente.getNome());
				pstm.setString(2, cadastroCliente.getCpf());
				pstm.setString(3, cadastroCliente.getEmail());
				pstm.setString(4, cadastroCliente.getEndereco());
				pstm.setInt(5, cadastroCliente.getIdCliente());
				pstm.execute();
				System.out.println("Cliente Atualizado com sucesso");
				conn.close();
				pstm.close();
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
				
		}
		public static void consultar() {
			String sql = "SELECT * FROM cadastrocliente";
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet reSet = null;
			
			
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				reSet = pstm.executeQuery();
				while(reSet.next()) {
					System.out.println("ID: " + reSet.getInt("id"));
					System.out.println("Nome: " + reSet.getString("nome"));
					System.out.println("CPF: " + reSet.getString("cpf"));
					System.out.println("Email: " + reSet.getString("email"));
					System.out.println("Endereço: " + reSet.getString("endereco"));
					System.out.println();
					}
				
					conn.close();
					pstm.close();
					
			}catch(Exception ex) {
				
				System.out.println(ex.getMessage());
				
			}
		}

}
		
		
