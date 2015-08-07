package org.techzoo.springmvc.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus_detail", schema = "school_bus_management_system")
public class BusDetail {
	@Id
	@Column(name="bus_detail_id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="bus_stop_name")
	private String busStopName;

	@Column(name="bus_stop_time")
	private String busStopTime;
	
	@Column(name="distance")
	private Integer distance;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "route_id", nullable=false, updatable=false)
	private Route route;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public String getBusStopTime() {
		return busStopTime;
	}

	public void setBusStopTime(String busStopTime) {
		this.busStopTime = busStopTime;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}	
}
