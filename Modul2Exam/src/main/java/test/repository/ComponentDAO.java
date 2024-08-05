package test.repository;

import java.util.Collection;

import test.model.Component;

public interface ComponentDAO {

	public Component get(long id);

	public Collection<Component> getAll();

	public Collection<Component> get(String model, String producerName);

	public void add(Component component);

	public void update(Component component);

}
