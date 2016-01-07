package com.takahirofujii.condominium;

import java.math.BigDecimal;
import java.time.YearMonth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Condominium sales information by month.
 * @author fujiitakahiro
 *
 */
@Getter
@AllArgsConstructor
public class CondominiumSales {
	private final long id;
	private final YearMonth month;
	private final BigDecimal sales;
}
