package test.repository;

import java.util.Collection;

import test.model.Producer;

public interface ProducerDAO {

	public Producer get(long id);

	public Collection<Producer> getAll();

}
