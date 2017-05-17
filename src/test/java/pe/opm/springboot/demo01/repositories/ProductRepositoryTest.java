package pe.opm.springboot.demo01.repositories;

import pe.opm.springboot.demo01.configuration.RepositoryConfiguration;
import pe.opm.springboot.demo01.domain.Product;
import pe.opm.springboot.demo01.repositories.ProductRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct(){
        
        Product product = new Product();
        product.setDescription("java demon Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("1234");

     
        assertNull(product.getId()); 
        productRepository.save(product);
        assertNotNull(product.getId()); 

        
        Product fetchedProduct = productRepository.findOne(product.getId());


        assertNotNull(fetchedProduct);


        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());


        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);


        Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());


        long productCount = productRepository.count();
        assertEquals(productCount, 1);


        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
