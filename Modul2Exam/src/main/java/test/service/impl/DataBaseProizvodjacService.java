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
public class DataBaseProizvodjacService implements ProducerService {
	
	private final ProducerDAO proizvodjacDAO;
	private final ModelMapper mapper = new ModelMapper();

	

	public DataBaseProizvodjacService(ProducerDAO proizvodjacDAO) {
		super();
		this.proizvodjacDAO = proizvodjacDAO;
	}
	
	private ProducerDTOGet createDTO (Producer proizvodjac) {
		return mapper.map(proizvodjac, ProducerDTOGet.class);
	}
	
	private Collection<ProducerDTOGet> createDTO (Collection<Producer> proizvodjaci){
		Collection<ProducerDTOGet>ProizvodjaciDTOs= new ArrayList<ProducerDTOGet>();
		for(Producer itProizvodjac : proizvodjaci) {
			ProducerDTOGet proizvodjacDTO = createDTO(itProizvodjac);
			ProizvodjaciDTOs.add(proizvodjacDTO);
		}
		return ProizvodjaciDTOs;
	}

	@Override
	public ProducerDTOGet get(long id) {
		Producer proizvodjac = proizvodjacDAO.get(id);
		if(proizvodjac==null) {
			throw new NoSuchElementException("Proizvodjac nije pronađen!");
		}
		return createDTO(proizvodjac);
	}

	@Override
	public Collection<ProducerDTOGet> getAll() {
		Collection<Producer>proizvodjaci= proizvodjacDAO.getAll();
		return createDTO(proizvodjaci);
	}



}
