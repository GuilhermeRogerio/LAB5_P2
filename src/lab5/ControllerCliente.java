package lab5;

import java.util.HashMap;
import java.util.Map;
/**
 * Classe que gerencia os clientes
 * 
 * @author Guilherme Rogerio
 *
 */
public class ControllerCliente {
	/**
	 * Mapa de clientes.
	 */
	private Map<String,Cliente> clientes;
	/**
	 * Constroi o controller e inicia o mapa de clientes.
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	/**
	 * Cadastra um cliente no sistema
	 * 
	 * @param cpf Cpf do cliente
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param localizacao Local de trabalho do cliente
	 * @return O cpf do cliente
	 */
	public String adicionaCliente(String cpf,String nome,String email,String localizacao) {
		if(!clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf,nome,email,localizacao));
			return clientes.get(cpf).getCpf();
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
	}
	/**
	 * Retorna a representação textual de um cliente cadastrado no sistema.
	 * @param cpf Cpf do cliente
	 * @return A representação textual do cliente e retorna "Cliente nao existente" se o cliente não existir
	 */
	public String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		} 
		return "Erro na exibicao do cliente: cliente nao existe.";
	}
	/**
	 * Lista todos os clientes cadastrados no sistema.
	 * 
	 * @return Uma string com todos os clientes cadastrados no sistema
	 */
	public String listaCliente() {
		String retorno = "";
		for(String cpf : this.clientes.keySet()) {
			retorno += this.clientes.get(cpf).toString() + "|";
		}
		return retorno;
	}
	
	public void editaCliente(String cpf,String atributo,String novoValor) {
		if(clientes.containsKey(cpf)) {
			if(atributo.equals("nome"))
				this.clientes.get(cpf).setNome(novoValor);
			if(atributo.equals("email"))
				this.clientes.get(cpf).setEmail(novoValor);
			if(atributo.equals("localizacao"))
				this.clientes.get(cpf).setLocalizacao(novoValor);
			
		}
	}
	/**
	 * Remove um cliente já cadastrado no sistema.
	 * 
	 * @param cpf Cpf do cliente
	 * @return "true" se a remoção for bem sucedida e "false" se o cliente não existir
	 */
	public void removeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		}
	}

}
