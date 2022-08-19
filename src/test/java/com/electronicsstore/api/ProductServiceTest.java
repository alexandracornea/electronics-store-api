package com.electronicsstore.api;

import com.electronicsstore.api.model.Product;
import com.electronicsstore.api.model.Type;
import com.electronicsstore.api.repository.ProductRepository;
import com.electronicsstore.api.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductService.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void testAddNewProduct() {
        Product product = new Product(Type.ELB, "spoon", 200, false, 5d);
        when(productRepository.save(product)).thenReturn(product);
        Product created = productService.addNewProduct(product);
        assertThat(created.getName()).isSameAs(product.getName());
    }
}
