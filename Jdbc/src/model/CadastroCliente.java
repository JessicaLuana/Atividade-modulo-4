package model;

import java.util.Scanner;

import services.CadastroClienteService;

public class CadastroCliente {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;

	public CadastroCliente() {
		
	}
	
	public CadastroCliente(String nome, String cpf, String email, String endereco) {
		super();
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}









	public String getNome() {
		return nome;
	}









	public void setNome(String nome) {
		this.nome = nome;
	}









	public String getCpf() {
		return cpf;
	}









	public void setCpf(String cpf) {
		this.cpf = cpf;
	}









	public String getEmail() {
		return email;
	}









	public void setEmail(String email) {
		this.email = email;
	}









	public String getEndereco() {
		return endereco;
	}









	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}





	public static void menuCliente() {
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("1 - Adicionar Cliente");
			System.out.println("2 - Deletar Cliente");
			System.out.println("3 - Alterar Cliente");
			System.out.println("4 - Consultar Cliente");
			System.out.println("0 - Sair do programa");
			
			int opcao = sc.nextInt();
			CadastroClienteService cadastroClienteService = new CadastroClienteService();
			
			switch(opcao) {
			case 0:
				repetir = false;
				break;
			case 1:
				CadastroClienteService.save();
				break;
			case 2:
				CadastroClienteService.deletar();
				break;
			case 3:
				CadastroClienteService.update();	
				break;
			case 4:
				CadastroClienteService.consultar();
				break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
		} while(repetir);
	}


	}
