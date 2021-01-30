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
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Remolacha\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Nabos\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Papas cocidas\",\n" +
						"        \"weight\":66.42\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{\n" +
								"    \"fullCalories\": 15686.13,\n" +
								"    \"ingredienteResponseDTOList\": [\n" +
								"        {\n" +
								"            \"name\": \"Acelgas\",\n" +
								"            \"fullCalories\": 1140.15\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Alcachofas\",\n" +
								"            \"fullCalories\": 4250.88\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Remolacha\",\n" +
								"            \"fullCalories\": 2656.8\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Nabos\",\n" +
								"            \"fullCalories\": 1926.18\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Papas cocidas\",\n" +
								"            \"fullCalories\": 5712.12\n" +
								"        }\n" +
								"    ],\n" +
								"    \"ingredienteResponseDTOMayorCalorias\": {\n" +
								"        \"name\": \"Papas cocidas\",\n" +
								"        \"fullCalories\": 5712.12\n" +
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
						"        \"name\":\"asdasd\",\n" +
						"        \"weight\":34.55\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Alcachofas\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Remolacha\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Nabos\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"Papas cocidas\",\n" +
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

	@Test
	void shouldCalculateCaloriesSuccessWithCaseIgnore() throws Exception {
		this.mockMvc.perform(post("/calorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"name\":\"comida\",\n" +
						"    \"ingredienteRequestDTOList\": [\n" +
						"        {\n" +
						"        \"name\":\"acELgas\",\n" +
						"        \"weight\":34.55\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"alcacHOfas\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"remolacha\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"nabos\",\n" +
						"        \"weight\":66.42\n" +
						"        },\n" +
						"        {\n" +
						"        \"name\":\"papas cocidas\",\n" +
						"        \"weight\":66.42\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{\n" +
								"    \"fullCalories\": 15686.13,\n" +
								"    \"ingredienteResponseDTOList\": [\n" +
								"        {\n" +
								"            \"name\": \"Acelgas\",\n" +
								"            \"fullCalories\": 1140.15\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Alcachofas\",\n" +
								"            \"fullCalories\": 4250.88\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Remolacha\",\n" +
								"            \"fullCalories\": 2656.8\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Nabos\",\n" +
								"            \"fullCalories\": 1926.18\n" +
								"        },\n" +
								"        {\n" +
								"            \"name\": \"Papas cocidas\",\n" +
								"            \"fullCalories\": 5712.12\n" +
								"        }\n" +
								"    ],\n" +
								"    \"ingredienteResponseDTOMayorCalorias\": {\n" +
								"        \"name\": \"Papas cocidas\",\n" +
								"        \"fullCalories\": 5712.12\n" +
								"    }\n" +
								"}"));
	}

}
