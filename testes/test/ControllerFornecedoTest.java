package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.ControllerFornecedor;

class ControllerFornecedoTest {
	
	private ControllerFornecedor controller;
	
	@BeforeEach
	void setUp() {
		this.controller = new ControllerFornecedor();
		
		controller.cadastraFornecedor("Dona Inês","DonaInês@email", "1774147483");
	}

	@Test
	void testCadastraFornecedor() {
		assertEquals("Pepsi",controller.cadastraFornecedor("Pepsi", "pepsi@yopmail", "711001211"));
	}
	
	@Test
	void testCadastraFornecedorExcecao() {
		assertThrows(IllegalArgumentException.class, () -> this.controller.cadastraFornecedor("Dona Inês","DonaInês@email", "1774147483"));
	}

	
	void testCadastraProduto() {
		fail("Not yet implemented");
	}

	@Test
	void testExibeFornecedor() {
		assertEquals("Dona Inês - DonaInês@email - 1774147483",controller.exibeFornecedor("Dona Inês"));
	}
	
	@Test
	void testExibeFornecedorInesistente() {
		assertEquals("Fornecedor nao existente",controller.exibeFornecedor("Adidas"));
	}

	
	void testExibeProduto() {
		fail("Not yet implemented");
	}

	
	void testListaFornecedor() {
		fail("Not yet implemented");
	}

	
	void testEditaFornecedor() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveFornecedor() {
		assertTrue(controller.removeFornecedor("Dona Inês"));
	}
	
	@Test
	void testRemoveFornecedorInesistente() {
		assertFalse(controller.removeFornecedor("Adidas"));
	}

}
