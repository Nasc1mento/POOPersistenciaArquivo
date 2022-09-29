package bancario.tsi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cpf;
	String nome;
	
	private ArrayList<Conta> contas = new ArrayList<>();
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public void adicionarConta(Conta c) {
		if(contas.contains(c))
			System.out.println("Conta j� cadastrada");
		else
			contas.add(c);
	}
	
	public void removerConta(Conta c) {
		if(contas.contains(c)) {
			contas.remove(c);
		}
		else
			System.out.println("Conta n�o cadastrada para este cliente");
	}
	
	public boolean consultarConta(Conta c) {
		if (contas.contains(c)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
	}
	

	public ArrayList<Conta> getContas() {
		return contas;
	}
}
