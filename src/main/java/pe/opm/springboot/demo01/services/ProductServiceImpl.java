package pe.opm.springboot.demo01.services;

import pe.opm.springboot.demo01.domain.Product;
import pe.opm.springboot.demo01.domain.ProductoSearch;
import pe.opm.springboot.demo01.repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository ;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }
    
    public void ejemplo(String description) {
        productRepository.findByDescription(description);
    }

	@Override
	public List<Product> searchProductByFilters(ProductoSearch productoSearch) {
		//List<Product> lista = productRepository.searchByFilters(productoSearch.getDescription(),productoSearch.getPriceMax(),productoSearch.getPriceMin());
		List<Product> lista = productRepository.searchByFilters(productoSearch.getPriceMax(),"", "");
		return lista;
	}
}
