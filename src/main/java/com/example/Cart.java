package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToOne(optional = false)
    private Product product;
    @OneToOne(optional = false)
    private Customer customer;

    protected Cart() {}

    public Cart(Product product, Customer customer) {
        this.product = product;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return String.format(
            "[id=%d, customer='%s', product='%s']",
            id, customer, product);
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}