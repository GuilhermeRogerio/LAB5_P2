package lab5;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	public Cliente(String cpf,String nome,String email,String localizacao) {
		validaEntradas(cpf, nome, email, localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
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
