package test.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import test.dto.ComponentDTOAddUpdate;
import test.dto.ComponentDTOGet;
import test.dto.validation.Validation;
import test.model.Component;
import test.model.Producer;
import test.repository.ComponentDAO;
import test.repository.ProducerDAO;
import test.service.ComponentService;

@Service
@Validated
public class DataBaseComponentService implements ComponentService {

	private final ProducerDAO producerDAO;
	private final ComponentDAO componentDAO;
	private final ModelMapper mapper = new ModelMapper();

	public DataBaseComponentService(ProducerDAO producerDAO, ComponentDAO componentDAO) {
		super();
		this.producerDAO = producerDAO;
		this.componentDAO = componentDAO;
	}

	private ComponentDTOGet createDTO(Component component) {
		return mapper.map(component, ComponentDTOGet.class);
	}

	private Collection<ComponentDTOGet> createDTO(Collection<Component> components) {
		Collection<ComponentDTOGet> componentsDTOs = new ArrayList<>();
		for (Component component : components) {
			ComponentDTOGet componentDTO = createDTO(component);
			componentsDTOs.add(componentDTO);
		}
		return componentsDTOs;
	}

	@Override
	public ComponentDTOGet get(long id) {
		Component component = componentDAO.get(id);
		if (component == null) {
			throw new NoSuchElementException("Component not found!");
		}
		return createDTO(component);
	}

	@Override
	public Collection<ComponentDTOGet> getAll() {
		Collection<Component> components = componentDAO.getAll();
		return createDTO(components);
	}

	@Override
	public Collection<ComponentDTOGet> get(String model, String producerName) {
		Collection<Component> components = componentDAO.getAll();

		List<Component> result = new ArrayList<>();
		for (Component component : components) {
			if ((model.isEmpty() || component.getModel().toLowerCase().contains(model.toLowerCase()))
					&& (producerName.isEmpty()
							|| component.getProducer().getName().toLowerCase().contains(producerName.toLowerCase()))) {
				result.add(component);
			}
		}
		return createDTO(result);
	}

	@Override
	@Validated(Validation.Add.class)
	public void add(@Valid ComponentDTOAddUpdate componentDTO) {
		Producer producer = producerDAO.get(componentDTO.getProducerId());
		if (producer == null) {
			throw new NoSuchElementException("Producer not found!");
		}
		Component component = mapper.map(componentDTO, Component.class);
		component.setProducer(producer);
		componentDAO.add(component);
	}

	@Override
	@Validated(Validation.Update.class)
	public void update(@Valid ComponentDTOAddUpdate componentDTO) {
		long id = componentDTO.getId();
		Component component = componentDAO.get(id);
		component.setAvailability(componentDTO.isAvailability());

		componentDAO.update(component);
	}
}
