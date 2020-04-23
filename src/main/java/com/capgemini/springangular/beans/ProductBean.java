package com.capgemini.springangular.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "productBean")

public class ProductBean implements Serializable {
	@Id
	@Column
	private String productName;
	@Column
	private String productImgUrl;
	@Column
	private Double productPrice;
	@Column
	private String productDescription;
}
