package org.techzoo.springmvc.form;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transport_assignment", schema = "school_bus_management_system")
public class TransportMapping {

	@Id
	@Column(name="transport_assignment_id")
	@GeneratedValue
	private Integer id;	
	
	@Column(name="fees")
	private Double fees;	
	
	@Column(name="paid")
	private Double paid;
	
	@Column(name="due")
	private Double due;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",insertable = true, updatable = true)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bus_detail_id",insertable = true, updatable = false)
	private BusDetail busDetail;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Double getPaid() {
		return paid;
	}

	public void setPaid(Double paid) {
		this.paid = paid;
	}

	public Double getDue() {
		return due;
	}

	public void setDue(Double due) {
		this.due = due;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BusDetail getBusDetail() {
		return busDetail;
	}

	public void setBusDetail(BusDetail busDetail) {
		this.busDetail = busDetail;
	}

}
