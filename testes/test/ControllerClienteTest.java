package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ControllerCliente;

class ControllerClienteTest {

	private ControllerCliente controllerCliente;
	
	@BeforeEach
	void setUp() {
		controllerCliente = new ControllerCliente();
		
		controllerCliente.cadastraCliente("1231","Rafael","rafael@gmail","SpLab");
	}

	@Test
	void testCadastraCliente() {
		assertEquals("1234",controllerCliente.cadastraCliente("1234", "Guilherme", "guilherme@gmail", "LSD"));
	}
	
	@Test
	void testCadastraClienteExcecao() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerCliente.cadastraCliente("1231","Rafael","rafael@gmail","SpLab"));
	}

	@Test
	void testExibeCliente() {
		assertEquals("Rafael - SpLab - rafael@gmail",controllerCliente.exibeCliente("1231"));
	}
	
	@Test
	void testExibeClienteInesistente() {
		assertEquals("Cliente nao existente",controllerCliente.exibeCliente("10230"));
	}

	@Test
	void testListaCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testEditaCliente() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCliente() {
		assertTrue(controllerCliente.removeCliente("1231"));
	}
	
	@Test
	void testRemoveClienteInesistente() {
		assertFalse(controllerCliente.removeCliente("0202"));
	}

}
