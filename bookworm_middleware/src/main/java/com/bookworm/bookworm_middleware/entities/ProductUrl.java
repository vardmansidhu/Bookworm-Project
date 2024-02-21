package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "product_url")
public class ProductUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "url_id")
	private Integer urlId;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product productId;

	@Column(name = "url")
	private String url;

	public Integer geturlId() {
		return urlId;
	}

	public void seturlId(Integer urlId) {
		this.urlId = urlId;
	}

	public Product getproductId() {
		return productId;
	}

	public void setproductId(Product productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}