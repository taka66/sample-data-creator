package com.takahirofujii.condominium;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
@Service
public class CondominiumDataCreator {

	private static final List<String> PREFECTURE = new ArrayList<>(Arrays.asList("Tokyo","Kyoto","Osaka","Hokkaido"));
	private static final List<String> NAME_SUFFIX = new ArrayList<>(Arrays.asList("Hills","House","Mansion"));	

	/**
	 * Create condominium master data.
	 * @param numberOfData
	 * @return List<Condominium>
	 */
	List<Condominium> createData(int numberOfData){
		List<Condominium> data = new ArrayList<Condominium>();
		IntStream.range(1,numberOfData + 1)
		.forEach(i -> data.add(new Condominium(i,RandomStringUtils.randomAlphabetic(5).concat(NAME_SUFFIX.get((int)(Math.random()*NAME_SUFFIX.size())))
				,PREFECTURE.get((int)(Math.random()*PREFECTURE.size())))));
		return data;
	}
	
	List<CondominiumSales> createSalesData(int numberOfData){
		List<Condominium> data = new ArrayList<Condominium>();
		//TODO implement logic
		return null;
	}
}