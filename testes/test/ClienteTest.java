package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Cliente;

class ClienteTest {
	
	private Cliente cliente;

	@Test
	void testContructorCliente() {
		cliente = new Cliente("1231","Guilherme","guilherme@gmail","LSD");
		
		assertEquals("1231 Guilherme guilherme@gmail LSD", cliente.getCpf() + " " + cliente.getNome() + " " + cliente.getEmail() + " " + cliente.getLocalizacao());
		
	}
	
	@Test
	void testCpfNulo() {
		assertThrows(NullPointerException.class, () -> this.cliente = new Cliente(null,"Guilherme","guilherme@gmail","LSD"));
	}
	
	@Test
	void testNomeNulo() {
		assertThrows(NullPointerException.class, () -> this.cliente = new Cliente("1231",null,"guilherme@gmail","LSD"));
	}
	
	@Test
	void testEmailNulo() {
		assertThrows(NullPointerException.class, () -> this.cliente = new Cliente("1231","Guilherme",null,"LSD"));
	}
	
	@Test
	void testLocalizacaoNula() {
		assertThrows(NullPointerException.class, () -> this.cliente = new Cliente("1231","Guilherme","guilherme@gmail",null));
	}

}
