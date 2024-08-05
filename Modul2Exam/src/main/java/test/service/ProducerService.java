package test.service;

import java.util.Collection;

import test.dto.ProducerDTOGet;

public interface ProducerService {

	public ProducerDTOGet get(long id);

	public Collection<ProducerDTOGet> getAll();

}
