package bancario.tsi;

import java.util.Scanner;

import persistencia.PersistenciaArquivo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersistenciaArquivo pa = new PersistenciaArquivo();
		Scanner sc = new Scanner(System.in);

		boolean sair = true;
		int opcao = 0;

		while (sair) {
			System.out.println("Escolha uma opção:\n1) Cadastrar cliente;\n2) Listar clientes;\n3) Remover cliente;\n4) Entrar no cliente;\n5) Sair;\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Insira o nome do cliente");
				String nome = sc.next();
				System.out.println("Insira o CPF do cliente");
				String cpf = sc.next();
				Cliente cliente = new Cliente(cpf, nome);
				pa.cadastrarCliente(cliente);
				cliente = null;
				break;
			case 2:
				pa.listarClientes();
				break;
			case 3:
				System.out.println("Digite o cpf do cliente");
				String removerCpf = sc.next();
				Cliente removerCliente = new Cliente(removerCpf);
				pa.removerCliente(removerCliente);
				break;
			case 4:
				System.out.println("Insira o CPF do cliente: ");
				String cpfConsulta = "";
				int segundaOpcao = 0;
				boolean segundoSair = true;
				cpfConsulta = sc.next();
				Cliente cliConsulta = pa.buscarClienteCPF(cpfConsulta);
				if (cliConsulta != null) {
					while (segundoSair) {
						System.out.println(
								"\n\n\n\nEscolha as op��es para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Depositar depósito;\n5) Realizar transferencia;\n6) Realizar depósito;\n7) Consultar saldo");
						segundaOpcao = sc.nextInt();
						switch (segundaOpcao) {
						case 1:
							String numeroConta = "";
							System.out.println("Insira o n�mero da conta");
							numeroConta = sc.next();
							Conta c1 = new Conta(numeroConta);
							cliConsulta.adicionarConta(c1);
							pa.atualizarCliente(cliConsulta);
							break;
						case 2:
							System.out.println("Insira o numero da conta");
							String numeroContaRemover = sc.next();
							Conta c1Remover = new Conta(numeroContaRemover);
							cliConsulta.removerConta(c1Remover);
							pa.atualizarCliente(cliConsulta);
							break;
						case 3:
							System.out.println(cliConsulta.getContas());
							break;
						case 4:
							System.out.println("Digite o número da conta");
							String nomeContaConsulta = sc.next();
							Conta c1Consulta = new Conta(nomeContaConsulta);
							boolean consulta = cliConsulta.consultarConta(c1Consulta);; 
							if (consulta == false) {
								System.out.println("Conta não existente");
								break;
							}
							System.out.println("Agora insira a quantia");
							float quantiaDeposito = sc.nextFloat();
							c1Consulta.realizarDeposito(quantiaDeposito);
							pa.atualizarCliente(cliConsulta);
							break;
						case 5 :
							
							break;
						case 6:
							
							break;
						case 7:
							
							
							break;
						default:

							break;
						}
					}
				} else
					System.err.println("Cliente n�o encontrado!");
				break;
			case 5:
				sair = false;
				break;
			}
			
			
			
			
			
//			System.out.println("Escolha uma op��o:\n1) Cadastrar um cliente;\n2) Cadastrar uma conta;\n3) Sair");
//			opcao = sc.nextInt();
//			switch (opcao) {
//			case 1:
//				String nome = "";
//				String cpf = "";
//				System.out.println("Insira o nome do cliente: ");
//				nome = sc.next();
//				System.out.println("Insira o CPF: ");
//				cpf = sc.next();
//				Cliente cli = new Cliente(cpf, nome);
//				pa.cadastrarCliente(cli);
//				break;
//			case 2:
//				System.out.println("Insira o CPF do cliente: ");
//				String cpfConsulta = "";
//				int segundaOpcao = 0;
//				boolean segundoSair = true;
//				cpfConsulta = sc.next();
//				Cliente cliConsulta = pa.buscarClienteCPF(cpfConsulta);
//				if (cliConsulta != null) {
//					while (segundoSair) {
//						System.out.println(
//								"\n\n\n\nEscolha as op��es para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Sair.");
//						segundaOpcao = sc.nextInt();
//						switch (segundaOpcao) {
//						case 1:
//							String numeroConta = "";
//							System.out.println("Insira o n�mero da conta");
//							numeroConta = sc.next();
//							Conta c1 = new Conta(numeroConta);
//							cliConsulta.adicionarConta(c1);
//							pa.atualizarCliente(cliConsulta);
//							break;
//						case 2:
//
//							break;
//						case 3:
//							System.out.println(cliConsulta.getContas());
//							break;
//						case 4:
//							segundoSair = false;
//							System.out.println("\n\n\n");
//							break;
//						default:
//
//							break;
//						}
//					}
//				} else
//					System.err.println("Cliente n�o encontrado!");
//				break;
//			case 3:
//				sair = false;
//				break;
//			default:
//				break;
//			}
		}
	}

}
