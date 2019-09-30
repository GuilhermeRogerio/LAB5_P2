package lab5;
/**
 * Representação de um cliente
 * 
 * @author Guilherme Rogerio
 *
 */
public class Cliente {
	/**
	 * Cpf do cliente.
	 */
	private String cpf;
	/**
	 * Nome do cliente.
	 */
	private String nome;
	/**
	 * Email do cliente.
	 */
	private String email;
	/**
	 * Local de trabalho do cliente.
	 */
	private String localizacao;
	/**
	 * Controi um cliente tendo como parametros cpf,nome,email,localizacao.
	 * 
	 * @param cpf Cpf do cliente
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param localizacao Local de trabalho do cliente
	 */
	public Cliente(String cpf,String nome,String email,String localizacao) {
		validaEntradas(cpf, nome, email, localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * Retorna uma string com a representação textual do cliente.
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	private void validaEntradas(String cpf,String nome,String email,String localizacao) {
		if(cpf == null) 
			throw new NullPointerException("Cpf nulo!");
		if(nome == null) 
			throw new NullPointerException("Nome nulo!");
		if(email == null)
			throw new NullPointerException("Email nulo!");
		if(localizacao == null)
			throw new NullPointerException("Localizacao nula!");
		if(cpf.trim().equals(""))
			throw new IllegalArgumentException("Cpf vazio!");
		if(nome.trim().equals(""))
			throw new IllegalArgumentException("Nome vazio!");
		if(email.trim().equals(""))
			throw new IllegalArgumentException("Email vazio!");
		if(localizacao.trim().equals(""))
			throw new IllegalArgumentException("Localizacao vazia!");
	}
	

}
