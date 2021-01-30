package com.meli.ejercicioCalorias;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Clase3SpringApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldCalculateCaloriesSuccess() throws Exception {
		this.mockMvc.perform(post("/calorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"name\":\"comida\",\n" +
						"    \"ingredienteRequestDTOList\": [\n" +
						"        {\n" +
						"        \"name\":\"Acelgas\",\n" +
						"        \"weight\":34.55\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Alcachofas\",\n" +
						"        \"weight\":66.42\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{\n" +
								"    \"fullCalories\": 5391.03,\n" +
								"    \"ingredienteDAOList\": [\n" +
								"        {\n" +
								"            \"name\": \"Acelgas\",\n" +
								"            \"calories\": 1140.1499999999999\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Alcachofas\",\n" +
								"            \"calories\": 4250.88\n" +
								"        }\n" +
								"    ],\n" +
								"    \"ingredienteDAOMayorCalorias\": {\n" +
								"        \"name\": \"Alcachofas\",\n" +
								"        \"calories\": 4250.88\n" +
								"    }\n" +
								"}"));
	}

	@Test
	void shouldCalculateCaloriesFail() throws Exception {
		this.mockMvc.perform(post("/calorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"name\":\"comida\",\n" +
						"    \"ingredienteRequestDTOList\": [\n" +
						"        {\n" +
						"        \"name\":\"miau\",\n" +
						"        \"weight\":34.55\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Alcachofas\",\n" +
						"        \"weight\":66.42\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().is(400))
				.andExpect(content()
						.json("{\n" +
								"    \"errorMessage\": \"Ingrediente no encontrado\"\n" +
								"}"));
	}

}
