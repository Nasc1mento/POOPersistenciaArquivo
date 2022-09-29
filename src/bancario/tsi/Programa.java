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
				boolean voltarMenuCliente = false;
				cpfConsulta = sc.next();
				Cliente cliConsulta = pa.buscarClienteCPF(cpfConsulta);
				if (cliConsulta != null) {
					while (voltarMenuCliente == false) {
						System.out.println(
								"\n\n\n\nEscolha as opções para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Entrar na conta;\n5) Voltar");
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
							Conta consulta = cliConsulta.consultarConta(c1Consulta);
							if (consulta == null) {
								System.out.println("Conta não existente");
								break;
							}
							boolean sairMenuConta = false;
							int opcaoMenuConta = 0;
							while (sairMenuConta == false) {
								System.out.println("\n\n\n\nEscolha qual operação deseja realizar: \n1) Depositar;\n2) Sacar;\n3) Ver Saldo;\n4) Voltar");
								opcaoMenuConta = sc.nextInt();
								switch(opcaoMenuConta) {
								case 1:
									System.out.println("Insira a quantia a ser depositada");
									float quantiaDeposito = sc.nextFloat();
									consulta.realizarDeposito(quantiaDeposito);
									pa.atualizarCliente(cliConsulta);
									break;
								case 2:
									System.out.println("Insira a quantia a ser sacada");
									float quantiaSaque = sc.nextFloat();
									consulta.realizarSaque(quantiaSaque);
									pa.atualizarCliente(cliConsulta);
									break;
								case 3:
									System.out.println(consulta.getSaldo());
									break;
								case 4:
									sairMenuConta = true;
									break;
								}
							}
						case 5:
							voltarMenuCliente = true;
							break;
						}
					}
				} else
					System.err.println("Cliente não encontrado!");
				break;
			case 5:
				sair = false;
				break;
			}
		}
	}
}
