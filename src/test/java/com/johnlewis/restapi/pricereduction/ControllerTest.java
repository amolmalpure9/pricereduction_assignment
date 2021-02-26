package com.johnlewis.restapi.pricereduction;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.johnlewis.restapi.pricereduction.bean.Product;
import com.johnlewis.restapi.pricereduction.service.impl.PricereductionServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

	/*
	 * 
	 * Things to test
	 * 
	 * 1. API call in controller a. Null response as input b. Empty list as input 2.
	 * Service method calls a. Null list b. Empty list as input 3. Label type
	 * response
	 * 
	 */

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PricereductionServiceImpl pricereductionServiceImpl;

	@Test
	public void testForNullServiceResponse() throws Exception {
		when(pricereductionServiceImpl.getPriceReducedItems(any(String.class))).thenReturn((null));

		this.mockMvc.perform(get("http://localhost:8001/getPriceReducedItems"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json("[]"))
				.andExpect(status().isOk());
	}

	@Test
	public void testForEmptyServiceResponse() throws Exception {
		when(pricereductionServiceImpl.getPriceReducedItems(any(String.class))).thenReturn((new ArrayList<Product>()));

		this.mockMvc.perform(get("http://localhost:8001/getPriceReducedItems"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json("[]"))
				.andExpect(status().isOk());
	}

	@Test
	public void testForObjectReturn() throws Exception {

		Product prod1 = new Product("1234", "TestTitle", null, "test", null);
		List<Product> productList = new ArrayList<Product>();
		productList.add(prod1);
		productList.add(prod1);

		when(pricereductionServiceImpl.getPriceReducedItems(any(String.class))).thenReturn(productList);

		this.mockMvc.perform(get("http://localhost:8001/getPriceReducedItems").param("labelType", "test"))
				.andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(status().isOk());

//		List<Product> testResult = pricereductionServiceImpl.getPriceReducedItems("");
//		assertThat(testResult).isNotNull().isNotEmpty().hasSize(1).allMatch(o -> o.getTitle().equals("TestTitle"));
	}

}
