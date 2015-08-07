package org.techzoo.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techzoo.springmvc.dao.Dao;
import org.techzoo.springmvc.form.TransportMapping;

@Service
public class TransportMappingServiceImpl implements TransportMappingService {

	@Autowired 
	private Dao dao;
	
	@Transactional
	public void addTransportMapping(TransportMapping transportMapping) {
		dao.add(transportMapping);
	}

	@Transactional
	public void removeTransportMapping(Integer id) {
		dao.remove(dao.getById(id, TransportMapping.class));
	}

	@Transactional
	public List<TransportMapping> listTransportMappings() {
		return dao.list(TransportMapping.class);
	}

	@Transactional
	public void updateTransportMapping(TransportMapping transportMapping) {
		dao.update(transportMapping);
	}

	@Transactional
	public TransportMapping getTransportMappingById(Integer id) {
		return (TransportMapping) dao.getById(id,TransportMapping.class);
	}
}