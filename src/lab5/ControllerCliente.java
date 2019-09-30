package lab5;

import java.util.HashMap;
import java.util.Map;

public class ControllerCliente {
	
	private Map<String,Cliente> clientes;
	
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	
	public String cadastraCliente(String cpf,String nome,String email,String localizacao) {
		if(!clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf,nome,email,localizacao));
			return clientes.get(cpf).getCpf();
		}
		throw new IllegalArgumentException("Cliente já existente");
	}
	
	public String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		} 
		return "Erro na exibicao do cliente nao existe";
	}
	
	public String listaCliente() {
		String retorno = "";
		for(String cpf : this.clientes.keySet()) {
			retorno += this.clientes.get(cpf).toString() + "|";
		}
		return retorno;
	}
	
	public boolean editaCliente(String cpf,String nome,String email,String localizacao) {
		if(clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
			this.clientes.get(cpf).setEmail(email);
			this.clientes.get(cpf).setLocalizacao(localizacao);
			return true;
		}
		return false;
		
	}
	
	public boolean removeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			return true;
		}
		return false;
	}

}
