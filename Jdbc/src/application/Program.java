package application;

import java.util.Scanner;

import model.CadastroCliente;
import model.Contato;
import model.Destino;




public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Scanner sc = new Scanner(System.in);
				boolean repetir = true;
				
				do {
					System.out.println("Digite uma das opções abaixo: ");
					System.out.println("(1) - Cliente");
					System.out.println("(2) - Contato");
					System.out.println("(3) - Destino");
					System.out.println("(0) - Sair do programa");
					
					int opcao = sc.nextInt();
					CadastroCliente cadastroCliente = new CadastroCliente();
					Contato contato = new Contato();
					Destino destino = new Destino();
					
					switch(opcao) {
					case 0:
						repetir = false;
						System.out.println("Volte Sempre!!");
						break;
					case 1:
						CadastroCliente.menuCliente();
						break;
					case 2:
						Contato.menuContato();
						break;
					case 3:
						Destino.menuDestino();	
						break;
						default:
							System.out.println("Opção Inválida!");
							break;
					}
				} while(repetir);
			}
		}