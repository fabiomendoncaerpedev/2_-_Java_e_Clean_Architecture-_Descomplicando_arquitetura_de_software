package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {
	
	@Test
	void alunoDeveriaSerPersistido() {
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);		
		
		String nomeAluno = "Fabio Mendonca";
		String cpfAluno = "123.456.789-00";
		String emailAluno = "fabio.mendonca@teste.com.br";
		
		MatricularAlunoDTO dados = new MatricularAlunoDTO(
				nomeAluno, 
				cpfAluno, 
				emailAluno);
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(
				new CPF(cpfAluno));
		
		assertEquals(nomeAluno, encontrado.getNome());
		assertEquals(cpfAluno, encontrado.getCpf());
		assertEquals(emailAluno, encontrado.getEmail());
	}
}
