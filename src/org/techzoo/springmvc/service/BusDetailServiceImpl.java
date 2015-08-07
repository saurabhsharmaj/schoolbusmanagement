package org.techzoo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techzoo.springmvc.dao.Dao;
import org.techzoo.springmvc.form.BusDetail;

@Service
public class BusDetailServiceImpl implements BusDetailService {

	@Autowired 
	private Dao dao;
	
	@Transactional
	public void addBusDetail(BusDetail busDetail) {
		dao.add(busDetail);
	}

	@Transactional
	public void removeBusDetail(Integer id) {
		dao.remove(dao.getById(id, BusDetail.class));
	}

	@Transactional
	public List<BusDetail> listBusDetails() {
		return dao.list(BusDetail.class);
	}

	@Transactional
	public void updateBusDetail(BusDetail busDetail) {
		dao.update(busDetail);
	}

	@Transactional
	public BusDetail getBusDetailById(Integer id) {
		return (BusDetail) dao.getById(id,BusDetail.class);
	}
}