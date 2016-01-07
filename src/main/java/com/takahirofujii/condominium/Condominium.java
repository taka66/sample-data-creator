package com.takahirofujii.condominium;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Store master information of condominium.
 * @author fujiitakahiro
 */
@Getter
@AllArgsConstructor
public class Condominium {
	private final long id;
	private final String name;
	private final String prefecture;
}
