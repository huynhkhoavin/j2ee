package com.grocerystore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "affablebean")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = -336993081282961543L;
	
	private Integer id;
	private Category category;
	private String name;
	private BigDecimal price;
	private String description;
	private Date lastUpdate;
        private String detail;
	private Set<OrderedProduct> orderedProducts = new HashSet<OrderedProduct>(0);

	public Product() {
	}

	public Product(Category category, String name, BigDecimal price,
			Date lastUpdate, String detail) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.lastUpdate = lastUpdate;
                this.detail = detail;
	}

	public Product(Category category, String name, BigDecimal price,
			String description, Date lastUpdate, Set<OrderedProduct> orderedProducts, String detail) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.orderedProducts = orderedProducts;
                this.detail = detail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
        @Column(name = "detail", nullable = false, length =45 )
        public String getDetail(){
            return this.detail;
        }
        public void setDetail(String detail)
        {
            this.detail = detail;
        }
	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 5)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderedProduct> getOrderedProducts() {
		return this.orderedProducts;
	}

	public void setOrderedProducts(Set<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

}
