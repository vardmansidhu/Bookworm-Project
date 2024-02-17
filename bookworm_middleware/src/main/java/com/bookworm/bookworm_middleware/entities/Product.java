package com.bookworm.bookworm_middleware.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_eng_name")
	private String productEngName;
    //each Product instance is associated with exactly one ProductType
	@ManyToOne
	@JoinColumn(name="type_id")
	private ProductType typeId;

	@Column(name = "base_price")
	private float basePrice;

	@Column(name = "special_cost")
	private float specialCost;

	@Column(name = "offer_price")
	private float offerPrice;

	@Column(name = "offer_exp_date")
	private Date offerExpDate;

	@Column(name = "short_desc", columnDefinition = "TEXT")
	private String shortDesc;

	@Column(name = "long_desc", columnDefinition = "MEDIUMTEXT")
	private String longDesc;

	@Column(name = "ISBN", length = 13)
	private String ISBN;

	@Column(name = "author")
	private String author;
//    //multiple Product instances can be associated with the same Publisher
//	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
//	@JoinColumn(name = "publisher")
//	private Publisher publisher;
	private String publisher;
    //multiple Product instances can be associated with the same Language
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
	@JoinColumn(name="language_id")
	private Language languageId;

	//multiple Product instances can be associated with the same Genre
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
	@JoinColumn(name="genre_id")
	private Genre genreId;

	@Column(name = "is_rentable")
	private boolean isRentable;

	@Column(name = "is_library")
	private boolean isLibrary;

	@Column(name = "rent_per_day")
	private float rentPerDay;

	@Column(name = "min_rent_days")
	private int minRentDays;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductEngName() {
		return productEngName;
	}

	public void setProductEngName(String productEngName) {
		this.productEngName = productEngName;
	}

	public ProductType getTypeId() {
		return typeId;
	}

	public void setTypeId(ProductType typeId) {
		this.typeId = typeId;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public float getSpecialCost() {
		return specialCost;
	}

	public void setSpecialCost(float specialCost) {
		this.specialCost = specialCost;
	}

	public float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Date getOfferExpDate() {
		return offerExpDate;
	}

	public void setOfferExpDate(Date offerExpDate) {
		this.offerExpDate = offerExpDate;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Language languageId) {
		this.languageId = languageId;
	}

	public Genre getGenreId() {
		return genreId;
	}

	public void setGenreId(Genre genreId) {
		this.genreId = genreId;
	}

	public boolean isRentable() {
		return isRentable;
	}

	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}

	public boolean isLibrary() {
		return isLibrary;
	}

	public void setLibrary(boolean isLibrary) {
		this.isLibrary = isLibrary;
	}

	public float getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(float rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public int getMinRentDays() {
		return minRentDays;
	}

	public void setMinRentDays(int minRenDays) {
		this.minRentDays = minRenDays;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productEngName=" + productEngName
				+ ", typeId=" + typeId + ", basePrice=" + basePrice + ", specialCost=" + specialCost + ", offerPrice="
				+ offerPrice + ", offerExpDate=" + offerExpDate + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", ISBN=" + ISBN + ", author=" + author + ", publisher=" + publisher + ", languageId=" + languageId
				+ ", genreId=" + genreId + ", isRentable=" + isRentable + ", isLibrary=" + isLibrary + ", rentPerDay="
				+ rentPerDay + ", minRenDays=" + minRentDays + "]";
	}

}
