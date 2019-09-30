package lab5;

import java.util.HashMap;
import java.util.Map;
/**
 * Classe que gerencia os fornecedores
 * 
 * @author Guilherme Rogerio
 *
 */
public class ControllerFornecedor {
	/**
	 * Mapa de fornecedores
	 */
	private Map<String,Fornecedor> fornecedores;
	private Map<ProdutoKey,Produto> produtos;
	/**
	 * Constroi o controller e inicia o mapa de fornecedores.
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
		this.produtos = new HashMap<>();
	}
	/**
	 * Cadastra um fornecedor no sistema.
	 * 
	 * @param nome Nome do fornecedor
	 * @param email Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 * @return O nome do fornecedor
	 */
	public String cadastraFornecedor(String nome,String email,String telefone) {
		if(!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome,email,telefone));
			return this.fornecedores.get(nome).getNome();
		}
		throw new IllegalArgumentException("Fornecedor já existente");
	}
	
	public void cadastraProduto(String nomeFornecedor,String nomeProduto,String descricao,String preco) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			if(!this.produtos.containsKey(new ProdutoKey(nomeProduto,descricao))) {
				this.fornecedores.get(nomeFornecedor).addProduto(nomeProduto, descricao, preco);
			}
			
		}else {
			throw new IllegalArgumentException("Fornecedor não existente");
		}
		
	}
	/**
	 * Retorna a representação tetual de um fornecedor já cadastrado no sistema.
	 * 
	 * @param nome Nome do fornecedor
	 * @return A representação tetual de um fornecedor e retorna "Fornecedor nao existente" se o fornecedor não existir
	 */
	public String exibeFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			return this.fornecedores.get(nome).toString();
		} 
		return "Erro na exibicao do fornecedor nao existe";
	}
	
	public String exibeProduto(String nomeFornecedor,String nomeProduto,String descricao) {
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			if(this.produtos.containsKey(new ProdutoKey(nomeProduto,descricao))) {
				return this.produtos.get(new ProdutoKey(nomeProduto,descricao)).toString();
			}
		}
		return "";
	}
	/**
	 * Lista todos os fornecedores já cadastrados no sistema.
	 * @return Uma string com todos os fornecedores já cadastrados no sistema
	 */
	public String listaFornecedor() {
		String retorno = "";
		for(String nome : this.fornecedores.keySet()) {
			retorno += this.fornecedores.get(nome).toString() + "|";
		}
		return retorno;
	}
	
	public boolean editaFornecedor(String nome,String email,String telefone) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			this.fornecedores.get(nome).setTelefone(telefone);
			return true;
		}
		return false;
		
	}
	/**
	 * Remove um fornecedor cadastrado no sistema.
	 * @param nome Nome do fornecedor
	 * @return "true" se a remoção for bem sucedida e "false" se o fornecedor não existir
	 */
	public boolean removeFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}
		return false;
	}

}
