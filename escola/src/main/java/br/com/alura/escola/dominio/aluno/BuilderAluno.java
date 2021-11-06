package br.com.alura.escola.dominio.aluno;

public class BuilderAluno {
	
	private Aluno aluno;
	
	private String nome;
	private String cpf;
	private String email;
	
	
	public BuilderAluno comNome(String nome)	{
		this.nome = nome;
		return this;
	}
	
	public BuilderAluno comCPF(String cpf)	{
		this.nome = cpf;
		return this;
	}
	
	public BuilderAluno comEmail(String email)	{
		this.nome = email;
		return this;
	}
	
	public BuilderAluno comTelefone(String ddd, String numero)	{
		this.aluno.adicionarTelefone(ddd, numero);		
		return this;
	}
	
	
	public Aluno criar() {
		this.aluno = new Aluno(
				new CPF(this.cpf),
				this.nome, 
				new Email(this.email)
				);		
		return this.aluno;
	}
	
	
}
