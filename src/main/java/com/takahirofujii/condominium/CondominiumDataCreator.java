package com.takahirofujii.condominium;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class CondominiumDataCreator {

	private static final List<String> PREFECTURE = new ArrayList<>(
			Arrays.asList("Tokyo", "Kyoto", "Osaka", "Hokkaido"));
	private static final List<String> NAME_SUFFIX = new ArrayList<>(Arrays.asList("Hills", "House", "Mansion"));

	/**
	 * Create condominium master data.
	 * 
	 * @param numberOfData
	 * @return List<Condominium>
	 */
	List<Condominium> createData(int numberOfData) {
		List<Condominium> data = new ArrayList<Condominium>();
		IntStream.range(1, numberOfData + 1)
				.forEach(i -> data.add(new Condominium(i,
						RandomStringUtils.randomAlphabetic(5)
								.concat(NAME_SUFFIX.get((int) (Math.random() * NAME_SUFFIX.size()))),
						PREFECTURE.get((int) (Math.random() * PREFECTURE.size())))));
		return data;
	}

	/**
	 * Create comdominium sales data.
	 * 
	 * @param numberOfData
	 * @return
	 */
	List<CondominiumSales> createSalesData(int numberOfData) {
		List<CondominiumSales> data = new ArrayList<CondominiumSales>();
		IntStream.range(1, numberOfData + 1).forEach(i -> data.addAll(createOneYearData(i)));
		return data;
	}

	private List<CondominiumSales> createOneYearData(long id) {
		List<CondominiumSales> data = new ArrayList<CondominiumSales>();
		IntStream.range(0, 12).forEach(i -> data.add(new CondominiumSales(id, YearMonth.now().minusMonths(i),
				BigDecimal.valueOf((int) (Math.random() * 1000000)))));
		return data;
	}
}
