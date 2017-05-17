package pe.opm.springboot.demo01.bootstrap;

import pe.opm.springboot.demo01.domain.Product;
import pe.opm.springboot.demo01.repositories.ProductRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
/*
        Product shirt = new Product();
        shirt.setDescription("Java demon Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("http://www.tshirts.in/image/cache/data/Products/MT/mt00224-700x700.jpg");
        shirt.setProductId("P00000000000000001");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Java white Mug");
        mug.setImageUrl("https://www.mugbug.co.uk/media/products/500/mb.i_love_java_red_love_heart_mug.left.jpg");
        mug.setProductId("P00000000000000002");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
        */
    }
}
