package pe.opm.springboot.demo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import pe.opm.springboot.demo01.domain.Product;

//public interface ProductRepository extends CrudRepository<Product, Integer>{
//}
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByDescription(String description);

    List<Product> findByProductId(String productId);
    
    List<Product> findByPrice(BigDecimal price);
   
    
	// custom query example and return a stream - 	DESCRIPCION
  //  @Query("select p from Product p where p.description = :description")
    //Stream<Product> findByDescriptionReturnStream(@Param("description") String description);
    
   //PRODUCTID
    //@Query("select p from Product p where p.productId = :productId")
    //Stream<Product> findByProductIdReturnStream(@Param("productId") String productId);
    //PRICE
    //@Query("select p from Product p where p.price = :price")
    //Stream<Product> findByPriceReturnStream(@Param("price") String price);

    @Query("select p from Product p where p.price <= (:priceMax) and p.description = (:description) and p.productId = (:productId)")
	List<Product> searchByFilters(@Param("priceMax") BigDecimal priceMax, @Param("productId") String productId, @Param("description") String description );

	

	
    
    
    
    

}
