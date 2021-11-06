package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Email;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecoInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Email(null);
		});	
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Email("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Email("emailinvalido");
		});
	}
	
	@Test
	void deveriaCriarEmailValido() {
		String enderecoEmail = "fabio.mendonca@totvs.com.br";
		Email email = new Email(enderecoEmail);
		assertEquals(enderecoEmail, email.getEndereco());
	}
}
