package com.sellingperfume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class ProductEntity extends AbtractEntity {
	
	@Column(name = "Description", columnDefinition = "varchar(250)")
	private String description;

	@Column(name = "avatar", columnDefinition = "varchar(250)")
	private String avatar;

	@Column(name = "ProductStatus", columnDefinition = "boolean default true ")
	private boolean productStatus;
	
	@Column(name = "UnitPrice")
	private int unitPrice;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "TotalProduct")
	private int totalProduct;
	
	@Column(name = "name_product", columnDefinition = "varchar(150)", unique = true)
	private String nameProduct;

	@Column(name = "ProductTypeId")
	private int productTypeId;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

}
