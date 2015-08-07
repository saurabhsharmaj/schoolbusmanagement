package org.techzoo.springmvc.service;

import java.util.List;

import org.techzoo.springmvc.form.TransportMapping;

public interface TransportMappingService {
	
	public void addTransportMapping(TransportMapping tranportMapping);
	public void updateTransportMapping(TransportMapping tranportMapping);
	public TransportMapping getTransportMappingById(Integer id);
	public List<TransportMapping> listTransportMappings();
	public void removeTransportMapping(Integer id);

}
