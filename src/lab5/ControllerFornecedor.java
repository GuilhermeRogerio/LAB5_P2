package lab5;

import java.util.HashMap;
import java.util.Map;

public class ControllerFornecedor {
	private Map<String,Fornecedor> fornecedores;
	private Map<ProdutoKey,Produto> produtos;
	
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
		this.produtos = new HashMap<>();
	}
	
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
	
	public boolean removeFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}
		return false;
	}

}
