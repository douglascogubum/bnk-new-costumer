package com.zup.bank.mocks;

import com.zup.bank.model.Perfil;

public class MockBean {
	private static final Long ID = 1L;
	private static final String AUTH = "Douglas Cogubum";
	
	public static Perfil mockPerfil() {
		
		return Perfil.builder()
				.id(ID)
				.authority(AUTH)
				.build();
	}
}
