package com.electronicsstore.api;

import com.electronicsstore.api.controller.ProductController;
import com.electronicsstore.api.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUpdateStock() throws Exception {
        String product = """
                {
                    "type":"ELB",
                    "name":"fridge",
                    "stock":10,
                    "deleted":false,
                    "price":1900
                }""";
        mockMvc.perform(post("/products/add")
                        .content(product)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(put("/products/update/1/15"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAvailableProducts() throws Exception {
        mockMvc.perform(get("/products/available"))
                .andExpect(status().isOk());
    }
}
