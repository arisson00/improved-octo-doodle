package condominio.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import condominio.entities.Cliente;
import condominio.entities.Dados;
import condominio.entities.Empresa;
import condominio.entities.Endereco;
import condominio.entities.Servico;
import condominio.entities.ServicoPeriodicos;
import condominio.entities.Telefone;
import condominio.entities.enums.Status;


public class Program2 {
	
	public static Dados adicionaDados(String tipo) {
		
		Dados dados = new Cliente();
		Scanner sc = new Scanner(System.in);
		if (tipo == "empresa") dados = new Empresa();
		
		Endereco endereco = new Endereco();
		
		System.out.print("Nome " + tipo +": ");
		dados.setNome(sc.nextLine());
		
		System.out.print("Rua: ");
		endereco.setRua(sc.nextLine());
		
		System.out.print("Numero: ");
		endereco.setNumero(sc.nextLine());
		
		System.out.print("CEP: ");
		endereco.setCep(sc.nextLine());
		
		System.out.print("Cidade: ");
		endereco.setCidade(sc.nextLine());
		
		System.out.print("Estado: ");
		endereco.setEstado(sc.nextLine());
		
		System.out.print("Pais: ");
		endereco.setPais(sc.nextLine());
		
		System.out.print("CNPJ: ");
		dados.setCnpj(sc.nextLine());
		
		dados.setEndereco(endereco);
	
		return dados;
		
	};
	
	
	public static Telefone adicionaTelefone() {
		
		Scanner sc = new Scanner(System.in);
		Telefone telefone = new Telefone();
		
		System.out.println(">>Telefone<< ");
		
		System.out.print("Tipo: ");
		telefone.setTipo(sc.nextLine());
		
		System.out.print("DDD: ");
		telefone.setDdd(sc.nextLine());
		
		System.out.print("Numero: ");
		telefone.setNumero(sc.nextLine());
		
		return telefone;
		
	};
	
	public static void adicionaCondominio() {
		
	}

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Cliente cliente = new Cliente();

		int menu;
		do {
			
			System.out.println("Menu:");
			System.out.println("0 - Sair.");
			System.out.println("1 - Adicionar Condom??nnio.");
			System.out.println("2 - Adicionar Servi??o");
			System.out.println("3 - Mostrar Dados");
			menu = sc.nextInt();

		
			switch (menu) {
			
			case 0: {
				
				break;
			}
			
			case 1: {
				
				// Pega os dados do condom??nio:
				
				System.out.println(">>Endere??o do Condom??nio<<");
				Dados dados = adicionaDados("Condominio");
				cliente = (Cliente) dados;
				
				System.out.print("Sindico: ");
				cliente.setSindico(sc.nextLine());
				
					
				break;
			}
			
			case 2: {
				
				
				Servico servico = new Servico();
				Empresa empresa;
				
				System.out.print("?? um servi??o peri??dico? (s/n)"); // Mudar a pergunta??
				char ch = sc.next().toLowerCase().charAt(0);
				
				// Tipo do servi??o
				String[] tipos = {"1 - Manuten????o", 
								"2 - Pintura",
								"3 - Limpeza",
								"4 - Troca"};
				
				System.out.println(">>Tipo de servi??o<<");
				
				for(String lista : tipos) {
					System.out.println(lista);
				};
				
				System.out.print("Tipo: ");
				servico.setTipo(sc.nextInt());
				

				// Dados da empresa
				System.out.println(">>Empresa<<");
				Dados dados = adicionaDados("empresa");
				empresa = (Empresa) dados; 
				
				Telefone telefone = adicionaTelefone(); // Adicionar um m??todo para adicionar mais um numero.
				empresa.addNumber(telefone);
				
				servico.setEmpresa(empresa); 
					
				// Data inicial
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				if(ch == 's') {
					servico = new ServicoPeriodicos();
				}
				System.out.println();
				System.out.print("Data Inicial (DD/MM/YYYY): ");
				servico.setData(sdf.parse(sc.next()));
				
				if(servico instanceof ServicoPeriodicos) {
					
					System.out.print("Pr??xima data (DD/MM/YYYY): ");
					((ServicoPeriodicos) servico).setNextDate(sdf.parse(sc.next()));
				}
				
				
				// Pre??o
				System.out.print("Pre??o do servi??o ");
				servico.setPreco(sc.nextDouble());
				
				
				// Status 
				System.out.print("Status (NAO_INICIADO/INICIADO/COMPLETADO)");
				servico.setStatus(Status.valueOf(sc.next()));
			
				cliente.addService(servico); // Adicionando o servi??o 
				
				//VER M??TODO TO STRING
				break;
			}
			
			case 3: {
				
				System.out.println(cliente);
				
				break;
			}
				
			default:
				break;
			}
			
		}while(menu != 0);
		
		
		sc.close();
		
	}

}
