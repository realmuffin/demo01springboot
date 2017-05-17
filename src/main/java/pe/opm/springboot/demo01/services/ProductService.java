package pe.opm.springboot.demo01.services;


import java.util.List;

import pe.opm.springboot.demo01.domain.Product;
import pe.opm.springboot.demo01.domain.ProductoSearch;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

	List<Product> searchProductByFilters(ProductoSearch productoSearch);
}
