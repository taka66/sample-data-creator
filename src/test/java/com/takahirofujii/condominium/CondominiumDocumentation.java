package com.takahirofujii.condominium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.takahirofujii.SampleDataCreatorApplication;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleDataCreatorApplication.class)
@WebAppConfiguration
public class CondominiumDocumentation {

	@Rule
	public RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
	            .apply(documentationConfiguration(this.restDocumentation))
	            .build();
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/condominium/get?size=5&field=master").accept(MediaType.APPLICATION_JSON)) 
	    .andExpect(status().isOk()) 
	    .andDo(document("condominium", requestParameters( 
	            parameterWithName("size").description("Number of data you would like to create."), 
	            parameterWithName("field").description("Data type. 'master': master data of condominium. 'sales': sales data of condominium."))
	            , responseFields( 
	                    fieldWithPath("[].id").description("The identifier"), 
	                    fieldWithPath("[].name").description("Name of condominium"),
	                    fieldWithPath("[].prefecture").description("The user's email address"))
	    )); 
	}

}
