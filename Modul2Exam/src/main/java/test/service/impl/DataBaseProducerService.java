package test.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import test.dto.ProducerDTOGet;
import test.model.Producer;
import test.repository.ProducerDAO;
import test.service.ProducerService;
@Service
public class DataBaseProducerService implements ProducerService {
	
	private final ProducerDAO producerDAO;
	private final ModelMapper mapper = new ModelMapper();

	

	public DataBaseProducerService(ProducerDAO producerDAO) {
		super();
		this.producerDAO = producerDAO;
	}
	
	private ProducerDTOGet createDTO (Producer producer) {
		return mapper.map(producer, ProducerDTOGet.class);
	}
	
	private Collection<ProducerDTOGet> createDTO (Collection<Producer> producers){
		Collection<ProducerDTOGet>producerDTOs= new ArrayList<ProducerDTOGet>();
		for(Producer itProducer : producers) {
			ProducerDTOGet producerDTO = createDTO(itProducer);
			producerDTOs.add(producerDTO);
		}
		return producerDTOs;
	}

	@Override
	public ProducerDTOGet get(long id) {
		Producer producer = producerDAO.get(id);
		if(producer==null) {
			throw new NoSuchElementException("producer not found!");
		}
		return createDTO(producer);
	}

	@Override
	public Collection<ProducerDTOGet> getAll() {
		Collection<Producer>producers= producerDAO.getAll();
		return createDTO(producers);
	}



}
