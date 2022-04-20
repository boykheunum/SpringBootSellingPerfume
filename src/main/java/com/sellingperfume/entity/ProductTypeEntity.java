package com.sellingperfume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_type")
public class ProductTypeEntity extends AbtractEntity {
	
	@Column(name = "ProductType", columnDefinition = "varchar(50)", unique = true)
	private String productType;
	
	
	@Column(name = "Description", columnDefinition = "varchar(250)")
	private String description;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
