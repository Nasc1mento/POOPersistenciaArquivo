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
			System.out.println("Escolha uma opção:\n1) Cadastrar um cliente;\n2) Cadastrar uma conta;\n3) Sair");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				String nome = "";
				String cpf = "";
				System.out.println("Insira o nome do cliente: ");
				nome = sc.next();
				System.out.println("Insira o CPF: ");
				cpf = sc.next();
				Cliente cli = new Cliente(cpf, nome);
				pa.cadastrarCliente(cli);
				break;
			case 2:
				System.out.println("Insira o CPF do cliente: ");
				String cpfConsulta = "";
				int segundaOpcao = 0;
				boolean segundoSair = true;
				cpfConsulta = sc.next();
				Cliente cliConsulta = pa.buscarClienteCPF(cpfConsulta);
				if (cliConsulta != null) {
					while (segundoSair) {
						System.out.println(
								"\n\n\n\nEscolha as opções para CONTA: \n1) Cadastrar uma conta;\n2) Remover uma conta;\n3) Listar contas;\n4) Sair.");
						segundaOpcao = sc.nextInt();
						switch (segundaOpcao) {
						case 1:
							String numeroConta = "";
							System.out.println("Insira o número da conta");
							numeroConta = sc.next();
							Conta c1 = new Conta(numeroConta);
							cliConsulta.adicionarConta(c1);
							pa.atualizarCliente(cliConsulta);
							break;
						case 2:

							break;
						case 3:
							System.out.println(cliConsulta.getContas());
							break;
						case 4:
							segundoSair = false;
							System.out.println("\n\n\n");
							break;
						default:

							break;
						}
					}
				} else
					System.err.println("Cliente não encontrado!");
				break;
			case 3:
				sair = false;
				break;
			default:
				break;
			}
		}
	}

}
