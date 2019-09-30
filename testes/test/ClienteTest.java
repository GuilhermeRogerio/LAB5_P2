package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Cliente;

class ClienteTest {
	
	private Cliente cliente,cliente1;

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
	
	@Test
	void testCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.cliente = new Cliente(" ","Guilherme","guilherme@gmail","LSD"));
	}
	
	@Test
	void testNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.cliente = new Cliente("1231"," ","guilherme@gmail","LSD"));
	}
	
	@Test
	void testEmailVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.cliente = new Cliente("1231","Guilherme"," ","LSD"));
	}
	
	@Test
	void testLocalizacaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.cliente = new Cliente("1231","Guilherme","guilherme@gmail"," "));
	}
	
	@Test
	void testToString() {
		cliente = new Cliente("1231","Guilherme","guilherme@gmail","LSD");
		
		assertEquals("Guilherme - LSD - guilherme@gmail",cliente.toString());
	}
	
	@Test
	void testHashCode() {
		cliente = new Cliente("1231","Guilherme","guilherme@gmail","LSD");
		cliente1 = new Cliente("1231","Rafael","rafael@gmail","SpLab");
		
		assertEquals(cliente.hashCode(),cliente1.hashCode());
	}
	
	@Test
	void testEqualsObjetosIguais() {
		cliente = new Cliente("1231","Guilherme","guilherme@gmail","LSD");
		cliente1 = new Cliente("1231","Rafael","rafael@gmail","SpLab");
		
		assertTrue(cliente.equals(cliente1));
	}
	
	@Test
	void testEqualsObjetosDiferentes() {
		cliente = new Cliente("1231","Guilherme","guilherme@gmail","LSD");
		cliente1 = new Cliente("4568","Guilherme","guilherme@gmail","LSD");
		
		assertFalse(cliente.equals(cliente1));
	}

}
