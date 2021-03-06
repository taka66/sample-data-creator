package com.takahirofujii.condominium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondominiumController {

	@Autowired
	CondominiumDataCreator creator;

	@RequestMapping("/condominium/get")
	public List<?> get(@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "field", defaultValue = "master") String field) {
		if (field.equals("sales")) {
			return creator.createSalesData(size);
		} else {
			return creator.createData(size);
		}
	}
}
