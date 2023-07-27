package com.moaddi.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Operator_Order_Details_TL")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)

public class OperatorOrderDetailsTL {
	
	@Id
	@GeneratedValue
	private Long orderDetailsId;
	
	private Long orderId;
	private String orderFor;
	private String type;
	private String model;
	private Integer quantity;
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderFor() {
		return orderFor;
	}
	public void setOrderFor(String orderFor) {
		this.orderFor = orderFor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public Long getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	

}
