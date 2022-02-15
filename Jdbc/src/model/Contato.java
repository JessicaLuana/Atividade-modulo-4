package model;

import java.util.Scanner;


import services.ContatoService;

public class Contato {
	
	private Integer idContato;
	private String nome;
	private String email;
	private String mensagem;

	public Contato() {
		
	}

	public Contato(String nome, String email, String mensagem) {
		super();
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}


	public Integer getIdContato() {
		return idContato;
	}


	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public static void menuContato() {
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("1 - Adicionar Contato");
			System.out.println("2 - Deletar Contato");
			System.out.println("3 - Alterar Contato");
			System.out.println("4 - Consultar Contato");
			System.out.println("0 - Sair do programa");
			
			int opcao = sc.nextInt();
			ContatoService contatoService = new ContatoService();
			
			switch(opcao) {
			case 0:
				repetir = false;
				break;
			case 1:
				ContatoService.save();
				break;
			case 2:
				ContatoService.deletar();
				break;
			case 3:
				ContatoService.update();	
				break;
			case 4:
				ContatoService.consultar();
				break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
		} while(repetir);
	}
}


