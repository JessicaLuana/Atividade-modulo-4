package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connector.ConexaoComBanco;
import model.Contato;

public class ContatoService {
	public static void save() {
		Scanner sc = new Scanner(System.in);
		
		Contato contato = new Contato();
		
		System.out.println("Digite seu nome");
		contato.setNome(sc.nextLine());
		
		System.out.println("Digite seu email");
		contato.setEmail(sc.nextLine());
		
		System.out.println("Digite sua mensagem");
		contato.setMensagem(sc.nextLine());
		
		
		
		String sql = "INSERT INTO contato(nome, email, mensagem)VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getMensagem());
		
			
			pstm.execute();
			
			System.out.println("Contato Cadastrado com sucesso");
			
			conn.close();
			pstm.close();
			
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		
		}
		}
		public static void deletar() {
			Scanner sc = new Scanner(System.in);
			
			Contato contato = new Contato();
			
			System.out.println("Digite o Id do contato");
			contato.setIdContato(sc.nextInt());
			sc.nextLine();
			
			String sql = "DELETE FROM contato where id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setString(3, contato.getMensagem());
			
				
				
				pstm.execute();
				System.out.println("Contato deletado com sucesso");
				conn.close();
				pstm.close();
				
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			
			}
		}
		public static void update() {
			Scanner sc = new Scanner(System.in);
			
			Contato contato = new Contato();
			
			System.out.println("Digite o Id do contato");
			contato.setIdContato(sc.nextInt());
			
			System.out.println("Digite seu nome");
			contato.setNome(sc.nextLine());
			sc.nextLine();
			System.out.println("Digite seu email");
			contato.setEmail(sc.nextLine());
			
			System.out.println("Digite sua mensagem");
			contato.setMensagem(sc.nextLine());
			
			String sql = "UPDATE contato set nome = ?, email = ?, mensagem = ? where id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConexaoComBanco.createConnection();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, contato.getNome());
				pstm.setString(2, contato.getEmail());
				pstm.setString(3, contato.getMensagem());
			
				
				pstm.execute();
				System.out.println("Contato deletado com sucesso");
				conn.close();
				pstm.close();
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
				
		}
		public static void consultar() {
			String sql = "SELECT * FROM contato";
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
					System.out.println("Email: " + reSet.getString("email"));
					System.out.println("Mensagem: " + reSet.getString("mensagem"));
					System.out.println();
					}
				
					conn.close();
					pstm.close();
					
			}catch(Exception ex) {
				
				System.out.println(ex.getMessage());
				
			}
		}

}
		
		
