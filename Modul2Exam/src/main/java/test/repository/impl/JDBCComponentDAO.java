package test.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import test.model.Component;
import test.model.Producer;
import test.repository.ComponentDAO;
import test.repository.ProducerDAO;

@Repository
public class JDBCComponentDAO implements ComponentDAO {

	private final ProducerDAO producerDAO;
	private final JdbcTemplate jdbcTemplate;

	public JDBCComponentDAO(ProducerDAO producerDAO, JdbcTemplate jdbcTemplate) {
		super();
		this.producerDAO = producerDAO;
		this.jdbcTemplate = jdbcTemplate;
	}

	private class ComponentRowMapper implements RowMapper<Component> {

		@Override
		public Component mapRow(ResultSet rset, int rowNum) throws SQLException {
			int column = 0;
			long id = rset.getLong(++column);
			long producerId = rset.getLong(++column);
			String model = rset.getString(++column);
			LocalDate availabilityDate = rset.getDate(++column).toLocalDate();
			double price = rset.getDouble(++column);
			boolean available = rset.getBoolean(++column);
			String image = rset.getString(++column);

			Producer producer = producerDAO.get(producerId);
			Component component = new Component(id, model, availabilityDate, price, image, available, producer);
			return component;
		}
	}

	@Override
	public Component get(long id) {
		String sql = "SELECT id, producerId, model, availabilityDate, price, available, image FROM components WHERE id=?";
		List<Component> result = jdbcTemplate.query(sql, new ComponentRowMapper(), id);
		return (!result.isEmpty()) ? result.get(0) : null;
	}

	@Override
	public Collection<Component> getAll() {
		String sql = "SELECT id, producerId, model, availabilityDate, price, available, image FROM components";
		return jdbcTemplate.query(sql, new ComponentRowMapper());
	}

	@Override
	public Collection<Component> get(String model, String producerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Component component) {
		String sql = "INSERT INTO components (producerId, model, availabilityDate, price, available, image) VALUES (?, ?, ?, ?,?,?)";
		jdbcTemplate.update(sql, component.getProducer().getId(), component.getModel(), component.getAvailabilityDate(),
				component.getPrice(), component.isAvailability(), component.getImage());
	}

	@Override
	public void update(Component component) {
		String sql = "UPDATE components SET producerId=?, model=?, availabilityDate=?, price=?, available=?, image=? WHERE id = ?";
		jdbcTemplate.update(sql, component.getProducer().getId(), component.getModel(), component.getAvailabilityDate(),
				component.getPrice(), component.isAvailability(), component.getImage(), component.getId());
	}

}
