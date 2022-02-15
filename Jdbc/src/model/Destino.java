package model;

import java.util.Scanner;

import services.DestinoService;



public class Destino {
	
	private Integer idDestino;
	private String nome;
	private String email;
	private String destino;
	private double valor;

	public Destino() {
		
	}
	
	public Destino( String nome, String email, String destino, double valor) {
		super();
	
		this.nome = nome;
		this.email = email;
		this.destino = destino;
		this.valor = valor;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public static void menuDestino() {
		Scanner sc = new Scanner(System.in);
		boolean repetir = true;
		
		
		do {
			System.out.println("Digite uma das opções abaixo: ");
			System.out.println("1 - Adicionar Destino");
			System.out.println("2 - Deletar Destino");
			System.out.println("3 - Alterar Destino");
			System.out.println("4 - Consultar Destino");
			System.out.println("0 - Sair do programa");
			
			int opcao = sc.nextInt();
			
			DestinoService destinoService = new DestinoService();
			
			switch(opcao) {
			case 0:
				repetir = false;
				break;
			case 1:
				DestinoService.save();
				break;
			case 2:
				DestinoService.deletar();
				break;
			case 3:
				DestinoService.update();	
				break;
			case 4:
				DestinoService.consultar();
				break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
		} while(repetir);
	}
}
	

