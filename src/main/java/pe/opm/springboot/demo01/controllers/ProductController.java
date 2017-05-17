package pe.opm.springboot.demo01.controllers;

import pe.opm.springboot.demo01.domain.Product;
import pe.opm.springboot.demo01.domain.ProductoSearch;

import pe.opm.springboot.demo01.services.ProductService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@Autowired
    private ProductService productService;
    
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        System.out.println("redirec");
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        
        
        
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){
    	
    	System.out.println("que se recibe : " + product);
    	System.out.println(" " + product.getDescription());
    	System.out.println(" " + product.getPrice());
    	
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
                         
    }

    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    
    
    @RequestMapping("product/searchForm")
    public String searchForm(ProductoSearch	productoSearch){ 	
    	
        return "productsearch";
    }
    
    @RequestMapping("product/search")
    public String search(ProductoSearch	productoSearch,Model model){
        	
    	System.out.println("pricemin "+ productoSearch.getPriceMin());
    	System.out.println("pricemax " + productoSearch.getPriceMax());
    	System.out.println("descripcion "+ productoSearch.getDescription());
    	
    	List<Product> resultado = productService.searchProductByFilters(productoSearch);
    	
    	for (Product product : resultado) {
			System.out.println(product.getId()+"," + product.getDescription() +"," + product.getPrice());
		}
    	
    	model.addAttribute("listaProducto", resultado);
        return "productsearch";
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
