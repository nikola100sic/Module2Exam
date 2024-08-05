package test.service;

import java.util.Collection;

import jakarta.validation.Valid;
import test.dto.ComponentDTOAddUpdate;
import test.dto.ComponentDTOGet;

public interface ComponentService {

	public ComponentDTOGet get(long id);

	public Collection<ComponentDTOGet> getAll();

	public Collection<ComponentDTOGet> get(String model, String producerName);

	public void add(@Valid ComponentDTOAddUpdate componentDTO);

	public void update(@Valid ComponentDTOAddUpdate componentDTO);
}
