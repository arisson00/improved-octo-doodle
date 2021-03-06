package condominio.entities;

import java.util.List;
import java.util.ArrayList;

public class Empresa extends Dados{
	
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Empresa () {
		super();
		
	}

	public Empresa(String nome, Endereco endereco, String cnpj) {
		super(nome, endereco, cnpj); 
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void addNumber(Telefone telefone) {
		this.telefones.add(telefone);
	}
	
	public void removeNumber(Telefone telefone) {
		this.telefones.remove(telefone);
	}

	@Override
	public String toString() {
		return "Empresa [telefones=" + telefones + ", Nome=" + getNome() + ", Endereco=" + getEndereco()
				+ ", Cnpj=" + getCnpj() + "]";
	}
	
	
	
}
