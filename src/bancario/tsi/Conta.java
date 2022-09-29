package bancario.tsi;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numero;
	private float saldo;
	Date dataAbertura;
	boolean status;
	
	public Conta(String numero) {
		this.numero = numero;
		this.saldo = 0f;
		this.dataAbertura = new Date();
		this.status = true;
	}
	
	public void realizarDeposito(float quantia) {
		if(status == true && quantia > 0)
			this.saldo = this.saldo + quantia;
		else
			System.out.println("Não foi possível realizar o depósito");
	}
	
	public void realizarSaque(float quantia) {
		if(status && this.saldo >= quantia)
			this.saldo -= quantia;
		else
			System.out.println("Não foi possível realizar o saque");
		
	}
	
	public void realizarTranferencia(Conta destino, float quantia) {
	
		if(destino.status && this.saldo>= quantia && this.status) {
			this.realizarSaque(quantia);
			destino.realizarDeposito(quantia);;
		}
		else
			System.out.println("Não foi possível realizar a transferência");
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura + ", status=" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numero, other.numero);
	}
	
}
