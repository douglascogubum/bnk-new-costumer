package com.zup.bank.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.bank.mocks.MockBean;

@ExtendWith(MockitoExtension.class)
class PerfilTest {

	private Perfil perfil;
	
	@BeforeEach
	public void setUp( ) {
		perfil = MockBean.mockPerfil();
	}
	
	@Test
	public void PerfilClassTest() {
		assertThat( Perfil.class, hasValidGettersAndSetters());
		Assertions.assertNotNull(perfil);
	}
}
