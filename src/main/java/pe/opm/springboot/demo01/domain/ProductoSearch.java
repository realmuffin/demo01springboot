package pe.opm.springboot.demo01.domain;

import java.math.BigDecimal;

public class ProductoSearch {


    private String productId;
    private String description;
  
    private BigDecimal priceMin;
    private BigDecimal priceMax;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}
	public BigDecimal getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(BigDecimal priceMax) {
		this.priceMax = priceMax;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
