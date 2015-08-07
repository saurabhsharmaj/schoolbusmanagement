package org.techzoo.springmvc.service;

import java.util.List;

import org.techzoo.springmvc.form.BusDetail;

public interface BusDetailService {
	
	public void addBusDetail(BusDetail busDetail);
	public void updateBusDetail(BusDetail busDetail);
	public BusDetail getBusDetailById(Integer id);
	public List<BusDetail> listBusDetails();
	public void removeBusDetail(Integer id);

}
