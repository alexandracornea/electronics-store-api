package com.electronicsstore.api;

import com.electronicsstore.api.model.ShoppingCart;
import com.electronicsstore.api.repository.ShoppingCartRepository;
import com.electronicsstore.api.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartService.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void testCreateShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartRepository.save(shoppingCart)).thenReturn(shoppingCart);
        ShoppingCart created = shoppingCartService.createShoppingCart();
        assertThat(created.getId()).isSameAs(shoppingCart.getId());
    }
}
