package lab5;

import java.util.HashMap;
import java.util.Map;
/**
 * Representação de um fornecedor
 * 
 * @author Guilherme Rogerio
 *
 */
public class Fornecedor {
	/**
	 * Nome do fornecedor.
	 */
	private String nome;
	/**
	 * Email do fornecedor.
	 */
	private String email;
	/**
	 * Telefone do fornecedor.
	 */
	private String telefone;
	/**
	 * Mapa de produtos.
	 */
	private Map<ProdutoKey,Produto> produtos;
	/**
	 * Constroi um fornecedor e inicia o mapa de produtos.
	 * 
	 * @param nome Nome do fornecedor
	 * @param email Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	public void addProduto(String nome,String descricao,String preco) {
		produtos.put(new ProdutoKey(nome,descricao), new Produto(nome,descricao,preco));
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * Retorna uma string com a representação textual do fornecedor.
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	

}
